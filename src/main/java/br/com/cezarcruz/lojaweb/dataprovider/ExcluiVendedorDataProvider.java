package br.com.cezarcruz.lojaweb.dataprovider;

import br.com.cezarcruz.lojaweb.data.repositorios.VendedorRepository;
import br.com.cezarcruz.lojaweb.gateways.ExcluiVendedorGateway;
import org.springframework.stereotype.Service;

@Service
public class ExcluiVendedorDataProvider implements ExcluiVendedorGateway {

    private VendedorRepository vendedorRepository;

    public ExcluiVendedorDataProvider(final VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @Override
    public void apaga(final Long id) {
        vendedorRepository.deleteById(id);
    }
}
