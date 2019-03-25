package br.com.cezarcruz.lojaweb.gateways.database.converters;

import br.com.cezarcruz.lojaweb.entities.Product;
import br.com.cezarcruz.lojaweb.gateways.database.entities.ProductEntity;

public class ProductToProductEntity {

    private ProductToProductEntity() {}

    public static ProductEntity from(final Product product) {

        return ProductEntity.builder()
                .name(product.getName())
                .price(product.getPrice())
                .build();

    }

    public static Product from(final ProductEntity productEntity) {

        return Product.builder()
                .name(productEntity.getName())
                .id(productEntity.getId())
                .price(productEntity.getPrice())
                .build();

    }

}
