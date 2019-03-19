package br.com.cezarcruz.lojaweb.gateways.database.dao;

import br.com.cezarcruz.lojaweb.entities.Product;
import br.com.cezarcruz.lojaweb.gateways.database.converters.ProductToProductEntity;
import br.com.cezarcruz.lojaweb.gateways.database.entidade.ProductEntity;
import br.com.cezarcruz.lojaweb.gateways.database.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductDAO {

    private ProductRepository productRepository;

    public Product save(final Product product) {

        final ProductEntity productEntity = ProductToProductEntity.de(product);
        final ProductEntity savedProduct = productRepository.save(productEntity);
        return product.toBuilder().id(savedProduct.getId()).build();

    }
}
