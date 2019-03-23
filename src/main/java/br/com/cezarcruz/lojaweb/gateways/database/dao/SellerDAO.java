package br.com.cezarcruz.lojaweb.gateways.database.dao;

import br.com.cezarcruz.lojaweb.entities.Seller;
import br.com.cezarcruz.lojaweb.gateways.database.converters.SellerToSellerEntity;
import br.com.cezarcruz.lojaweb.gateways.database.entidade.SellerEntity;
import br.com.cezarcruz.lojaweb.gateways.database.repositories.SellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SellerDAO {

    private SellerRepository sellerRepository;


    public Seller save(final Seller seller) {
        final SellerEntity entity = SellerToSellerEntity.from(seller);
        sellerRepository.save(entity);
        return seller.toBuilder().build();
    }

    /**
     *
     *
     *
     * public Product save(final Product product) {
     *
     *         final ProductEntity productEntity = ProductToProductEntity.from(product);
     *         final ProductEntity savedProduct = productRepository.save(productEntity);
     *         return product.toBuilder().id(savedProduct.getId()).build();
     *
     *     }
     *
     */
}
