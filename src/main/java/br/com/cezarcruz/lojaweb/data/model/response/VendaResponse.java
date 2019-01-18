package br.com.cezarcruz.lojaweb.data.model.response;

import br.com.cezarcruz.lojaweb.data.entidades.VendedorEntidade;
import br.com.cezarcruz.lojaweb.data.enums.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VendaResponse {
    private Long id;
    private Double valorTotal;
    private Date dataVenda;
    private VendedorEntidade vendedor;
    private List<ProdutoResponse> produtos;
    private TipoPagamento tipoPagamento;
}
