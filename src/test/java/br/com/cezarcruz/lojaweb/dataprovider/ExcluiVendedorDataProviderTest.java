package br.com.cezarcruz.lojaweb.dataprovider;

import br.com.cezarcruz.lojaweb.data.entidades.VendedorEntidade;
import br.com.cezarcruz.lojaweb.data.repositorios.VendedorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcluiVendedorDataProviderTest {

    @Autowired
    private ExcluiVendedorDataProvider excluiVendedorDataProvider;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Test
    @Transactional
    public void testaExclusaoVendedor() {
        final VendedorEntidade vendedor
                = vendedorRepository.save(VendedorEntidade.builder().nome("Vendedor").build());

        assertNotNull(vendedor);

        excluiVendedorDataProvider.apaga(vendedor.getId());

        Optional<VendedorEntidade> vendedorApagado
                = vendedorRepository.findById(vendedor.getId());

        assertFalse(vendedorApagado.isPresent());
    }

}
