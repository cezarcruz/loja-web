package br.com.cezarcruz.lojaweb.entidade;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder(toBuilder = true)
public class Produto {
    private String nome;
    private BigDecimal preco;
}
