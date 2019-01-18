package br.com.cezarcruz.lojaweb.casodeuso.vendedores;

import br.com.cezarcruz.lojaweb.gateways.ExcluiVendedorGateway;
import org.springframework.stereotype.Service;

@Service
public class RemoveVendedor {

    private ExcluiVendedorGateway excluiVendedorGateway;

    public RemoveVendedor(final ExcluiVendedorGateway excluiVendedorGateway) {
        this.excluiVendedorGateway = excluiVendedorGateway;
    }

    public void executa(final Long id) {
        excluiVendedorGateway.apaga(id);
    }

}
