package br.com.cezarcruz.lojaweb.gateways.database.converters;

import br.com.cezarcruz.lojaweb.entities.Product;
import br.com.cezarcruz.lojaweb.gateways.database.entidade.ProductEntity;

public class ProductToProductEntity {

    private ProductToProductEntity() {}

    public static ProductEntity de(final Product product) {

        return ProductEntity.builder()
                .name(product.getName())
                .price(product.getPrice())
                .build();

    }

}
