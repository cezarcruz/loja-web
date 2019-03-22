package br.com.cezarcruz.lojaweb.fixtures;

import br.com.cezarcruz.lojaweb.gateways.rest.request.IncludeProductRequest;

import java.math.BigDecimal;

public class IncludeProductRequestFixture {

    public static IncludeProductRequest withDefaultValues() {
        return IncludeProductRequest.builder()
                .name("Agua Limpa").price(BigDecimal.TEN).build();
    }

}
