package br.com.cezarcruz.lojaweb.casodeuso.vendas;

import br.com.cezarcruz.lojaweb.casodeuso.estoque.RemoveEstoque;
import br.com.cezarcruz.lojaweb.data.entidades.ProdutoEntidade;
import br.com.cezarcruz.lojaweb.data.entidades.VendaEntidade;
import br.com.cezarcruz.lojaweb.data.entidades.VendedorEntidade;
import br.com.cezarcruz.lojaweb.data.repositorios.ProdutoRepository;
import br.com.cezarcruz.lojaweb.data.repositorios.VendaRepository;
import br.com.cezarcruz.lojaweb.data.model.request.ProdutoQuantidadeRequest;
import br.com.cezarcruz.lojaweb.data.model.request.VendaRequest;
import br.com.cezarcruz.lojaweb.data.model.response.VendaResponse;
import br.com.cezarcruz.lojaweb.excecao.ValidacaoException;
import br.com.cezarcruz.lojaweb.transformacao.VendaParaVendaResponse;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RealizaVenda {

    private ProdutoRepository produtoRepository;
    private VendaRepository vendaRepository;
    private RemoveEstoque removeEstoque;

    public RealizaVenda(final ProdutoRepository produtoRepository,
                        final VendaRepository vendaRepository,
                        final RemoveEstoque removeEstoque) {
        this.produtoRepository = produtoRepository;
        this.vendaRepository = vendaRepository;
        this.removeEstoque = removeEstoque;
    }

    public VendaResponse executa(final VendaRequest venda) {

        if (venda.getProdutoQuantidade().isEmpty()) {
            throw new ValidacaoException("nao pode vender produtos vazio");
        }

        final Map<Long, Integer> produtoQuantidade = venda.getProdutoQuantidade()
                .stream()
                .collect(Collectors.toMap(ProdutoQuantidadeRequest::getProduto, ProdutoQuantidadeRequest::getQuantidade));

        final List<ProdutoEntidade> produtos = venda.getProdutoQuantidade()
                .stream()
                .map(longIntegerEntry -> produtoRepository.findById(longIntegerEntry.getProduto())
                        .orElseThrow(() -> new ValidacaoException("produto nao existe")))
                .map(produto -> {
                    if (produto.getEstoque().getQuantidade() > produtoQuantidade.get(produto.getId())) {
                        return produto;
                    }
                    throw new ValidacaoException("Nao ha estoque suficiente");
                }).collect(Collectors.toList());

        venda.getProdutoQuantidade()
                .forEach(pq -> removeEstoque.executa(pq.getProduto(), pq.getQuantidade()));

        final Double valorTotal = obtemValorTotal(venda, produtos, produtoQuantidade);

        final VendedorEntidade vendedor = VendedorEntidade.builder().id(venda.getVendedor()).build();

        final VendaEntidade vendaEntidade = VendaEntidade.builder()
                .dataVenda(new Date())
                .produtos(produtos)
                .valorTotal(valorTotal)
                .vendedor(vendedor)
                .tipoPagamento(venda.getTipoPagamento())
                .build();

        final VendaEntidade vendaRealizada = vendaRepository.save(vendaEntidade);
        return VendaParaVendaResponse.para(vendaRealizada);
    }

    private Double obtemValorTotal(final VendaRequest venda,
                                   final List<ProdutoEntidade> produtos,
                                   final Map<Long, Integer> produtoQuantidade) {
        if (venda.getValorTotal() != null && venda.getValorTotal() != 0) {
            return venda.getValorTotal();
        } else {
            return produtos.stream()
                    .mapToDouble(p -> p.getPreco() * produtoQuantidade.get(p.getId()))
                    .sum();
        }
    }
}
