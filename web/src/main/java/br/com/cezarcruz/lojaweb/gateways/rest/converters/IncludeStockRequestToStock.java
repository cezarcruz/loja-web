package br.com.cezarcruz.lojaweb.gateways.rest.converters;

import br.com.cezarcruz.lojaweb.entities.Product;
import br.com.cezarcruz.lojaweb.entities.Stock;
import br.com.cezarcruz.lojaweb.gateways.rest.request.IncludeStockRequest;

public class IncludeStockRequestToStock {
    public static Stock from(final Long productId,
                             final IncludeStockRequest includeStockRequest) {

        return Stock.builder().quantity(includeStockRequest.getQuantity())
                .product(Product.builder().id(productId).build())
                .build();

    }
}
