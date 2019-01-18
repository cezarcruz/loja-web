package br.com.cezarcruz.lojaweb.data.model.request;

import br.com.cezarcruz.lojaweb.data.enums.TipoPagamento;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class VendaRequest {
    private List<ProdutoQuantidadeRequest> produtoQuantidade = new ArrayList<>();
    private Double valorTotal;
    private Long vendedor;
    private TipoPagamento tipoPagamento;
}
