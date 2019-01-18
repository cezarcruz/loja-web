package br.com.cezarcruz.lojaweb.data.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IncluiVendedorRequest {
    private String nome;
    private String cpf;
}
