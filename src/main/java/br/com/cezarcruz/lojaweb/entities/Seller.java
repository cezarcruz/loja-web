package br.com.cezarcruz.lojaweb.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
public class Seller {

    private String document;
    private String name;
}
