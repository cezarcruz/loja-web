package br.com.cezarcruz.lojaweb.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder(toBuilder = true)
public class Product {

    private Long id;
    private String name;
    private BigDecimal price;

}
