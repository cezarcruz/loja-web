package br.com.cezarcruz.lojaweb.data.model.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class IncluiProdutoRequest {

    @NotNull
    private String nome;

    @NotNull
    private String descricao;

    @NotNull
    @Min(0)
    private Integer quantidade;

    @NotNull
    @Min(0)
    private Double preco;
}
