package br.com.cezarcruz.lojaweb.fixtures;

import br.com.cezarcruz.lojaweb.entidade.Produto;

import java.math.BigDecimal;

public class ProdutoFixture {

    public static Produto valoresPadrao() {
        return Produto.builder()
                .preco(BigDecimal.TEN)
                .nome("Produto")
                .build();
    }

}
