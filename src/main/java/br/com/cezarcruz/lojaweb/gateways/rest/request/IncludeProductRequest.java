package br.com.cezarcruz.lojaweb.gateways.rest.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class IncludeProductRequest {

    private String name;
    private BigDecimal price;

}
