package br.com.cezarcruz.lojaweb.fixtures;

import br.com.cezarcruz.lojaweb.gateways.rest.request.CreateSellerRequest;

public class IncludeSellerRequestFixture {

    public static CreateSellerRequest withDefaultValues() {

        return CreateSellerRequest.builder()
                .document("12121212108")
                .name("Jose Carlos Pagode")
                .build();

    }

}
