package br.com.cezarcruz.lojaweb.gateways.rest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SellerResponse {

    private String name;
    private String document;

}
