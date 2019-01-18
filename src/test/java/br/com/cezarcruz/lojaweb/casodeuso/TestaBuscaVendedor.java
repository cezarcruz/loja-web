package br.com.cezarcruz.lojaweb.casodeuso;

import br.com.cezarcruz.lojaweb.casodeuso.vendedores.BuscaVendedor;
import br.com.cezarcruz.lojaweb.data.entidades.VendedorEntidade;
import br.com.cezarcruz.lojaweb.data.repositorios.VendedorRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestaBuscaVendedor {

    @Autowired
    private BuscaVendedor buscaVendedor;

    @MockBean
    private VendedorRepository vendedorRepository;

    @Test
    public void buscaVendedorPorNome() {
        BDDMockito.when(this.vendedorRepository.findAllByNomeIgnoreCase("goku"))
                .thenReturn(List.of(VendedorEntidade.builder().nome("Goku").id(1L).build()));

        final List<VendedorEntidade> goku = this.buscaVendedor.porNome("goku");

        Assert.assertNotNull(goku);
        Assert.assertEquals(1, goku.size());
        Assert.assertEquals("Goku", goku.get(0).getNome());
        Assert.assertEquals(1L, goku.get(0).getId().longValue());
    }
}
