package br.com.cezarcruz.lojaweb.transformacao;

import br.com.cezarcruz.lojaweb.data.entidades.VendaEntidade;
import br.com.cezarcruz.lojaweb.data.model.response.VendaResponse;

import java.util.stream.Collectors;

public class VendaParaVendaResponse {

    private VendaParaVendaResponse() {}

    public static VendaResponse para(final VendaEntidade venda) {
        return VendaResponse.builder()
                .dataVenda(venda.getDataVenda())
                .id(venda.getId())
                .valorTotal(venda.getValorTotal())
                .vendedor(venda.getVendedor())
                .produtos(venda
                        .getProdutos()
                        .stream()
                        .map(ProdutoParaProdutoResponse::para)
                        .collect(Collectors.toList()))
                .tipoPagamento(venda.getTipoPagamento())
                .build();
    }

}
