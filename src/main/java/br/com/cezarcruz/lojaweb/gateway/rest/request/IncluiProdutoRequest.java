package br.com.cezarcruz.lojaweb.gateway.rest.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class IncluiProdutoRequest {

    private String nome;
    private BigDecimal valor;

}
