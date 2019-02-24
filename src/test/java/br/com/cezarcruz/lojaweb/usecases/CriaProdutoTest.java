package br.com.cezarcruz.lojaweb.usecases;

import br.com.cezarcruz.lojaweb.entidade.Produto;
import br.com.cezarcruz.lojaweb.fixtures.ProdutoFixture;
import br.com.cezarcruz.lojaweb.gateway.database.dao.ProdutoDAO;
import br.com.cezarcruz.lojaweb.usercases.CriaProduto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CriaProdutoTest {


    @InjectMocks
    public CriaProduto criaProduto;

    @Mock
    private ProdutoDAO produtoDAO;

    @Test
    public void deveCriarUmProduto() {

        final Produto produtoParaSalvar = ProdutoFixture.valoresPadrao();

        when(produtoDAO.salvar(any())).thenReturn(produtoParaSalvar.toBuilder().id(1L).build());

        final Produto produtoSalvo
                = criaProduto.executa(produtoParaSalvar);

        assertNotNull(produtoSalvo);
        assertEquals(Long.valueOf(1L), produtoSalvo.getId());
        assertEquals(produtoParaSalvar.getNome(), produtoSalvo.getNome());
        assertEquals(produtoParaSalvar.getPreco(), produtoSalvo.getPreco());

    }

}
