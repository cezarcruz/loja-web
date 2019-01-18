package br.com.cezarcruz.lojaweb.casodeuso;

import br.com.cezarcruz.lojaweb.casodeuso.vendedores.IncluiVendedor;
import br.com.cezarcruz.lojaweb.casodeuso.vendedores.RemoveVendedor;
import br.com.cezarcruz.lojaweb.data.entidades.VendedorEntidade;
import br.com.cezarcruz.lojaweb.data.model.Vendedor;
import br.com.cezarcruz.lojaweb.data.model.request.IncluiVendedorRequest;
import br.com.cezarcruz.lojaweb.data.repositorios.VendedorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestaExcluirVendedor {

    @Autowired
    private IncluiVendedor incluiVendedor;

    @Autowired
    private RemoveVendedor removeVendedor;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Test
    public void deveExcluirUmVendedor() {
        final IncluiVendedorRequest vendedorRequest
                = IncluiVendedorRequest.builder().nome("Vejeta").build();
        final Vendedor vendedorSalvo = incluiVendedor.executa(vendedorRequest);

        assertNotNull(vendedorSalvo);

        removeVendedor.executa(vendedorSalvo.getId());

        final Optional<VendedorEntidade> vendedor
                = vendedorRepository.findById(vendedorSalvo.getId());

        assertFalse(vendedor.isPresent());

    }
}
