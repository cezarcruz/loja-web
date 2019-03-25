package br.com.cezarcruz.lojaweb.gateways.database.converters;

import br.com.cezarcruz.lojaweb.entities.Stock;
import br.com.cezarcruz.lojaweb.gateways.database.entities.StockEntity;

public class StockToStockEntity {

    private StockToStockEntity() {
    }

    public static StockEntity from(final Stock stock) {
        return StockEntity.builder()
                .product(ProductToProductEntity.from(stock.getProduct()))
                .quantity(stock.getQuantity())
                .build();
    }

    public static Stock from (final StockEntity stockEntity) {
        return Stock.builder()
                .id(stockEntity.getId())
                .product(ProductToProductEntity.from(stockEntity.getProduct()))
                .quantity(stockEntity.getQuantity())
                .build();
    }

}
