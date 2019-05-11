package br.com.cezarcruz.lojaweb.fixtures;

import br.com.cezarcruz.lojaweb.entities.Product;

import java.math.BigDecimal;

public class ProductFixture {

    public static Product defaultValues() {
        return Product.builder()
                .price(BigDecimal.TEN)
                .name("Product")
                .build();
    }

    public static Product defaultValuesWithId() {
        return defaultValues().toBuilder().id(1L).build();
    }

    public static Product defaultValuesWithId(final Long id) {
        return defaultValues().toBuilder().id(id).build();
    }

}
