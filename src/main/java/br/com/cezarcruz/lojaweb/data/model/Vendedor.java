package br.com.cezarcruz.lojaweb.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vendedor {
    private Long id;
    private String nome;
    private String cpf;
}
