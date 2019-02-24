package br.com.cezarcruz.lojaweb.gateway.database.conversor;

import br.com.cezarcruz.lojaweb.entidade.Produto;
import br.com.cezarcruz.lojaweb.gateway.database.entidade.ProdutoEntity;

public class ProdutoToProdutoEntity {

    public static ProdutoEntity de(final Produto produto) {

        return ProdutoEntity.builder()
                .nome(produto.getNome())
                .preco(produto.getPreco())
                .build();

    }

}
