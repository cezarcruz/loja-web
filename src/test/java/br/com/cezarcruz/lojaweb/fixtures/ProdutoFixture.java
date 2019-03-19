package br.com.cezarcruz.lojaweb.fixtures;

import br.com.cezarcruz.lojaweb.entities.Product;

import java.math.BigDecimal;

public class ProdutoFixture {

    public static Product valoresPadrao() {
        return Product.builder()
                .price(BigDecimal.TEN)
                .name("Product")
                .build();
    }

}
