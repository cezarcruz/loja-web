package br.com.cezarcruz.lojaweb.gateways;

import br.com.cezarcruz.lojaweb.data.model.Vendedor;
import br.com.cezarcruz.lojaweb.data.model.request.IncluiVendedorRequest;

public interface IncluiVendedorGateway {
    Vendedor salva(final IncluiVendedorRequest vendedor);
}
