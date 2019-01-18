package br.com.cezarcruz.lojaweb.data.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoQuantidadeRequest {
    private Long produto;
    private Integer quantidade;
}
