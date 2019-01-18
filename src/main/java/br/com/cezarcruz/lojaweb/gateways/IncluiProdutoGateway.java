package br.com.cezarcruz.lojaweb.gateways;

import br.com.cezarcruz.lojaweb.data.model.request.IncluiProdutoRequest;
import br.com.cezarcruz.lojaweb.data.model.response.ProdutoResponse;

public interface IncluiProdutoGateway {
    ProdutoResponse salva(final IncluiProdutoRequest incluiProdutoRequest);
}
