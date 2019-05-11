package br.com.cezarcruz.lojaweb.gateways.rest.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockResponse {

    public ProductResponse product;
    public Integer quantity;

}
