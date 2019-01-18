package br.com.cezarcruz.lojaweb.casodeuso.produtos;

import br.com.cezarcruz.lojaweb.data.entidades.ProdutoEntidade;
import br.com.cezarcruz.lojaweb.data.repositorios.ProdutoRepository;
import br.com.cezarcruz.lojaweb.data.model.request.PaginacaoRequest;
import br.com.cezarcruz.lojaweb.data.model.response.RespostaPaginavel;
import br.com.cezarcruz.lojaweb.transformacao.ProdutoParaProdutoResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class BuscaProduto {

    private ProdutoRepository produtoRepository;

    public BuscaProduto(final ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public RespostaPaginavel buscaTodos(final PaginacaoRequest paginacao) {

        final Page<ProdutoEntidade> produtosPaginados = produtoRepository.findAll(paginacao.toPageRequest());

        var produtos = ProdutoParaProdutoResponse.para(produtosPaginados.getContent());

        return RespostaPaginavel.builder()
                .data(Collections.unmodifiableList(produtos))
                .tamanho(produtosPaginados.getTotalElements())
                .build();
    }

    public RespostaPaginavel buscaTodos(final PaginacaoRequest paginacao,
                                       final String filtro) {

        final var produtosPaginados = produtoRepository.findByNomeContainingIgnoreCase(paginacao.toPageRequest(), filtro);

        var produtos = ProdutoParaProdutoResponse.para(produtosPaginados.getContent());

        return RespostaPaginavel.builder()
                .data(Collections.unmodifiableList(produtos))
                .tamanho(produtosPaginados.getTotalElements())
                .build();
    }
}
