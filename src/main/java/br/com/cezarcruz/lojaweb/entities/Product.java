package br.com.cezarcruz.lojaweb.entities;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder(toBuilder = true)
public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
}
