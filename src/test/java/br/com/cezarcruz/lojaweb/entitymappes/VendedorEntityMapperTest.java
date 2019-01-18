package br.com.cezarcruz.lojaweb.entitymappes;

import br.com.cezarcruz.lojaweb.transformacao.VendedorEntityMapper;
import br.com.cezarcruz.lojaweb.data.entidades.VendedorEntidade;
import br.com.cezarcruz.lojaweb.data.model.Vendedor;
import br.com.cezarcruz.lojaweb.data.model.request.IncluiVendedorRequest;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class VendedorEntityMapperTest {

    @Test
    public void testaVendedorEntityMapperValido() {
        final VendedorEntidade goku
                = VendedorEntityMapper.fromRequest(IncluiVendedorRequest.builder().nome("Goku").build());

        assertNotNull(goku);
        assertEquals("Goku", goku.getNome());
        assertNull(goku.getId());

        assertNull(VendedorEntityMapper.fromEntidade(null));
        assertNull(VendedorEntityMapper.fromRequest(null));

        final Vendedor gokuVendedor
                = VendedorEntityMapper.fromEntidade(VendedorEntidade.builder().nome("Goku").id(1L).build());

        assertNotNull(gokuVendedor);
        assertEquals("Goku", gokuVendedor.getNome());
        assertEquals(1L, gokuVendedor.getId().longValue());
    }

}
