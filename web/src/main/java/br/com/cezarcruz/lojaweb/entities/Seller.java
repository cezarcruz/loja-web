package br.com.cezarcruz.lojaweb.entities;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Seller {

    private String document;
    private String name;
}
