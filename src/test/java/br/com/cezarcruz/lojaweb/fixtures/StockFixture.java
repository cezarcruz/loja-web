package br.com.cezarcruz.lojaweb.fixtures;

import br.com.cezarcruz.lojaweb.entities.Stock;

public class StockFixture {

    public static Stock withDefaultValues() {

        return Stock.builder()
                .quantity(10)
                .product(ProductFixture.defaultValues())
                .build();

    }

}
