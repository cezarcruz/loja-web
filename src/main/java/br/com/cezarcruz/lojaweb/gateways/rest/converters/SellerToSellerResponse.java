package br.com.cezarcruz.lojaweb.gateways.rest.converters;

import br.com.cezarcruz.lojaweb.entities.Seller;
import br.com.cezarcruz.lojaweb.gateways.rest.response.SellerResponse;

public class SellerToSellerResponse {

    private SellerToSellerResponse() {
    }

    public static SellerResponse from(final Seller savedSeller) {
        return SellerResponse.builder()
                .name(savedSeller.getName())
                .document(savedSeller.getDocument())
                .build();
    }

}
