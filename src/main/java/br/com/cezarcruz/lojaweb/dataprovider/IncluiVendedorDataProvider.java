package br.com.cezarcruz.lojaweb.dataprovider;

import br.com.cezarcruz.lojaweb.transformacao.VendedorEntityMapper;
import br.com.cezarcruz.lojaweb.data.entidades.VendedorEntidade;
import br.com.cezarcruz.lojaweb.data.model.Vendedor;
import br.com.cezarcruz.lojaweb.data.model.request.IncluiVendedorRequest;
import br.com.cezarcruz.lojaweb.data.repositorios.VendedorRepository;
import br.com.cezarcruz.lojaweb.gateways.IncluiVendedorGateway;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class IncluiVendedorDataProvider implements IncluiVendedorGateway {

    private VendedorRepository vendedorRepository;

    public IncluiVendedorDataProvider(final VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @Override
    public Vendedor salva(final IncluiVendedorRequest vendedorRequest) {


        final VendedorEntidade vendedor = VendedorEntityMapper.fromRequest(vendedorRequest);

        try {
            final VendedorEntidade vendedorSalvo = vendedorRepository.save(vendedor);
            return VendedorEntityMapper.fromEntidade(vendedorSalvo);
        } catch (final Exception e) {
            log.error("erro ao salvar o vendedor", e);
        }

        return null;
    }
}
