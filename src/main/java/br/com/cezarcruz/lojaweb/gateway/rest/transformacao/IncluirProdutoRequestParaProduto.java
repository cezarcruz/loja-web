package br.com.cezarcruz.lojaweb.gateway.rest.transformacao;

import br.com.cezarcruz.lojaweb.entidade.Produto;
import br.com.cezarcruz.lojaweb.gateway.rest.request.IncluiProdutoRequest;

public class IncluirProdutoRequestParaProduto {

    public static Produto de(final IncluiProdutoRequest incluiProdutoRequest) {
        return Produto.builder()
                .nome(incluiProdutoRequest.getNome())
                .preco(incluiProdutoRequest.getValor())
                .build();
    }

}
