package br.com.cezarcruz.lojaweb.gateways.rest.converters;

import br.com.cezarcruz.lojaweb.entities.Stock;
import br.com.cezarcruz.lojaweb.gateways.rest.response.StockResponse;

public class StockToStockResponse {

    private StockToStockResponse() {
    }

    public static StockResponse from(final Stock stockUpdated) {

        return StockResponse.builder()
                .product(ProductToProductResponse.from(stockUpdated.getProduct()))
                .quantity(stockUpdated.getQuantity())
                .build();

    }

}
