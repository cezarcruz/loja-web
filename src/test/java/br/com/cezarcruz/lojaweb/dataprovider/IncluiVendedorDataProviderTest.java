package br.com.cezarcruz.lojaweb.dataprovider;

import br.com.cezarcruz.lojaweb.data.model.Vendedor;
import br.com.cezarcruz.lojaweb.data.model.request.IncluiVendedorRequest;
import br.com.cezarcruz.lojaweb.data.repositorios.VendedorRepository;
import br.com.cezarcruz.lojaweb.gateways.IncluiVendedorGateway;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IncluiVendedorDataProviderTest {

    @Autowired
    private IncluiVendedorGateway incluiVendedorGateway;

    @MockBean
    private VendedorRepository vendedorRepository;

    @Test
    public void testaIncluiVendedor() {
        given(vendedorRepository.save(any())).willThrow(new RuntimeException());

        final Vendedor vendedor = incluiVendedorGateway.salva(new IncluiVendedorRequest());

        assertNull(vendedor);
    }

}
