package br.com.cezarcruz.lojaweb.gateways.rest.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CreateSellerRequest {
    private String name;
    private String document;
}

