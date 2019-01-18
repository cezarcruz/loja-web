package br.com.cezarcruz.lojaweb.dataprovider;

import br.com.cezarcruz.lojaweb.data.entidades.EstoqueEntidade;
import br.com.cezarcruz.lojaweb.data.entidades.ProdutoEntidade;
import br.com.cezarcruz.lojaweb.data.model.request.IncluiProdutoRequest;
import br.com.cezarcruz.lojaweb.data.model.response.ProdutoResponse;
import br.com.cezarcruz.lojaweb.data.repositorios.ProdutoRepository;
import br.com.cezarcruz.lojaweb.gateways.IncluiProdutoGateway;
import br.com.cezarcruz.lojaweb.transformacao.ProdutoParaProdutoResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class IncluiProdutoDataProvider implements IncluiProdutoGateway {

    private ProdutoRepository produtoRepository;

    public IncluiProdutoDataProvider(final ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoResponse salva(IncluiProdutoRequest incluiProdutoRequest) {

        final var estoque = EstoqueEntidade.builder()
                .quantidade(incluiProdutoRequest.getQuantidade())
                .build();

        final var produto = ProdutoEntidade.builder()
                .nome(incluiProdutoRequest.getNome())
                .preco(incluiProdutoRequest.getPreco())
                .descricao(incluiProdutoRequest.getDescricao())
                .estoque(estoque)
                .build();

        try {
            final ProdutoEntidade produtoSalvo = produtoRepository.save((produto));
            return ProdutoParaProdutoResponse.para(produtoSalvo);
        } catch (final Exception e) {
            log.error("erro ao salvar produto", e);
        }

        return null;
    }
}
