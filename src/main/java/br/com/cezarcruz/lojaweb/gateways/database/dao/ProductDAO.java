package br.com.cezarcruz.lojaweb.gateways.database.dao;

import br.com.cezarcruz.lojaweb.entities.Product;
import br.com.cezarcruz.lojaweb.gateways.database.converters.ProductToProductEntity;
import br.com.cezarcruz.lojaweb.gateways.database.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ProductDAO {

    private ProductRepository productRepository;

    public Product save(final Product product) {

        log.info("saving product {}", product);

        final var productEntity = ProductToProductEntity.from(product);
        final var savedProduct = productRepository.save(productEntity);

        return product.toBuilder().id(savedProduct.getId()).build();

    }

    public Optional<Product> findById(final Long id) {

        log.info("finding product by id {}", id);

        final var productEntity = productRepository.findById(id);
        return productEntity.map(ProductToProductEntity::from);
    }

}
