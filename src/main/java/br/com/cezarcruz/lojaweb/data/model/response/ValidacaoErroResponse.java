package br.com.cezarcruz.lojaweb.data.model.response;

import lombok.Data;

import java.util.List;

@Data
public class ValidacaoErroResponse {
    private String nome;
    private String mensagem;
    private List<DetalheResponse> detalhes;
}
