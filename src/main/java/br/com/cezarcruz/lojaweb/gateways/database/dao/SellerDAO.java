package br.com.cezarcruz.lojaweb.gateways.database.dao;

import br.com.cezarcruz.lojaweb.entities.Seller;
import br.com.cezarcruz.lojaweb.gateways.database.converters.SellerToSellerEntity;
import br.com.cezarcruz.lojaweb.gateways.database.entities.SellerEntity;
import br.com.cezarcruz.lojaweb.gateways.database.repositories.SellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SellerDAO {

    private SellerRepository sellerRepository;


    public Seller save(final Seller seller) {

        final var entity = SellerToSellerEntity.from(seller);

        sellerRepository.save(entity);
        return seller.toBuilder().build();

    }

}
