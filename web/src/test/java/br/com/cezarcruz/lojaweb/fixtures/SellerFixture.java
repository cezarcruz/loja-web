package br.com.cezarcruz.lojaweb.fixtures;

import br.com.cezarcruz.lojaweb.entities.Seller;

public class SellerFixture {

    public static Seller withDefaultValues() {

        return Seller.builder()
                .name("Jose Carlos Pagode")
                .document("12121212108")
                .build();

    }

}
