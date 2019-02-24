package br.com.cezarcruz.lojaweb.gateway.rest.transformacao;

import br.com.cezarcruz.lojaweb.entidade.Produto;
import br.com.cezarcruz.lojaweb.gateway.rest.response.ProdutoResponse;

public class ProdutoToProdutoResponse {

    public static ProdutoResponse de(final Produto produto) {
        return ProdutoResponse.builder()
                .nome(produto.getNome())
                .valor(produto.getPreco())
                .id(produto.getId())
                .build();
    }

}
