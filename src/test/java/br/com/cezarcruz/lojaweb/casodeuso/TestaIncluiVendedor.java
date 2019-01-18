package br.com.cezarcruz.lojaweb.casodeuso;

import br.com.cezarcruz.lojaweb.casodeuso.vendedores.IncluiVendedor;
import br.com.cezarcruz.lojaweb.data.model.Vendedor;
import br.com.cezarcruz.lojaweb.data.model.request.IncluiVendedorRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestaIncluiVendedor {

    @Autowired
    private IncluiVendedor incluiVendedor;

    @Test
    public void deveIncluirUmVendedor() {
        final IncluiVendedorRequest vendedorRequest
                = IncluiVendedorRequest.builder().nome("Vejeta").build();
        final Vendedor vendedorSalva = incluiVendedor.executa(vendedorRequest);

        assertNotNull(vendedorSalva.getId());
        assertEquals("Vejeta", vendedorSalva.getNome());

    }

}
