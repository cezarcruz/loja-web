package br.com.cezarcruz.lojaweb.gateways.rest.converters;

import br.com.cezarcruz.lojaweb.entities.Seller;
import br.com.cezarcruz.lojaweb.gateways.rest.request.CreateSellerRequest;

public class IncludeSellerToSeller {
    public static Seller from(CreateSellerRequest sellerRequest) {

        return Seller.builder()
                .document(sellerRequest.getDocument())
                .name(sellerRequest.getName())
                .build();

    }
}
