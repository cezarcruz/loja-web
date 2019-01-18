package br.com.cezarcruz.lojaweb.data.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoResponse {
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidade;
}
