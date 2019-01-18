package br.com.cezarcruz.lojaweb.casodeuso.vendedores;

import br.com.cezarcruz.lojaweb.data.model.Vendedor;
import br.com.cezarcruz.lojaweb.data.model.request.IncluiVendedorRequest;
import br.com.cezarcruz.lojaweb.gateways.IncluiVendedorGateway;
import org.springframework.stereotype.Service;

@Service
public class IncluiVendedor {

    private IncluiVendedorGateway incluiVendedorGateway;

    public IncluiVendedor(final IncluiVendedorGateway incluiVendedorGateway) {
        this.incluiVendedorGateway = incluiVendedorGateway;
    }

    public Vendedor executa(final IncluiVendedorRequest vendedorRequest) {
        return incluiVendedorGateway.salva(vendedorRequest);
    }

}
