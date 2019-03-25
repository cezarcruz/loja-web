package br.com.cezarcruz.lojaweb.entities;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Stock {

    private Long id;
    private Product product;
    private Integer quantity;

}
