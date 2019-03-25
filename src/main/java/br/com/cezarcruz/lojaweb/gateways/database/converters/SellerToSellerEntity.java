package br.com.cezarcruz.lojaweb.gateways.database.converters;

import br.com.cezarcruz.lojaweb.entities.Seller;
import br.com.cezarcruz.lojaweb.gateways.database.entities.SellerEntity;

public class SellerToSellerEntity {

    private SellerToSellerEntity() {
    }

    public static SellerEntity from(final Seller seller) {

        return SellerEntity.builder()
                .document(seller.getDocument())
                .name(seller.getName())
                .build();

    }

}
