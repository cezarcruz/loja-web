package br.com.cezarcruz.lojaweb.casodeuso.produtos;

import br.com.cezarcruz.lojaweb.data.model.request.IncluiProdutoRequest;
import br.com.cezarcruz.lojaweb.data.model.response.ProdutoResponse;
import br.com.cezarcruz.lojaweb.gateways.IncluiProdutoGateway;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class IncluiProduto {

    private IncluiProdutoGateway incluiProdutoGateway;

    public IncluiProduto(final IncluiProdutoGateway incluiProdutoGateway) {
        this.incluiProdutoGateway = incluiProdutoGateway;
    }

    @Transactional
    public ProdutoResponse executa(final IncluiProdutoRequest incluiProdutoRequest) {
        return incluiProdutoGateway.salva(incluiProdutoRequest);
    }
}
