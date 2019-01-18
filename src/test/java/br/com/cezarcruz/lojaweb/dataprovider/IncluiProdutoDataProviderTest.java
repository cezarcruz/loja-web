package br.com.cezarcruz.lojaweb.dataprovider;

import br.com.cezarcruz.lojaweb.data.model.request.IncluiProdutoRequest;
import br.com.cezarcruz.lojaweb.data.model.response.ProdutoResponse;
import br.com.cezarcruz.lojaweb.data.repositorios.ProdutoRepository;
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
public class IncluiProdutoDataProviderTest {

    @Autowired
    private IncluiProdutoDataProvider incluiProdutoDataProvider;

    @MockBean
    private ProdutoRepository produtoRepository;

    @Test
    public void testaIncluiProdutoErro() {

        given(produtoRepository.save(any()))
                .willThrow(new RuntimeException("erro ao salvar"));

        final ProdutoResponse produtoSalvo
                = incluiProdutoDataProvider.salva(new IncluiProdutoRequest());

        assertNull(produtoSalvo);
    }

}
