package br.com.cezarcruz.lojaweb.gateways.rest.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
public class ProductResponse {

    private Long id;
    private String name;
    private BigDecimal price;

}
