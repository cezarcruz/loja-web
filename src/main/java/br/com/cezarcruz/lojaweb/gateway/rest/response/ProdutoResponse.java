package br.com.cezarcruz.lojaweb.gateway.rest.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
public class ProdutoResponse {

    private Long id;
    private String nome;
    private BigDecimal valor;

}
