package br.com.cezarcruz.lojaweb.casodeuso;

import br.com.cezarcruz.lojaweb.casodeuso.produtos.IncluiProduto;
import br.com.cezarcruz.lojaweb.data.model.request.IncluiProdutoRequest;
import br.com.cezarcruz.lojaweb.data.model.response.ProdutoResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestaIncluiProduto {

    @Autowired
    private IncluiProduto incluiProduto;

    @Test
    public void incluiProduto() {
        final IncluiProdutoRequest incluiProdutoRequest = new IncluiProdutoRequest();
        incluiProdutoRequest.setNome("Agua");
        incluiProdutoRequest.setPreco(5D);
        incluiProdutoRequest.setDescricao("Agua Limpa");
        incluiProdutoRequest.setQuantidade(50);
        final ProdutoResponse produto = incluiProduto.executa(incluiProdutoRequest);

        assertNotNull(produto);
        assertEquals(50, produto.getQuantidade().intValue());
        assertEquals(new Double(5D), produto.getPreco());
        assertEquals("Agua", produto.getNome());
        assertEquals(50, produto.getQuantidade().intValue());
        assertEquals("Agua Limpa", produto.getDescricao());
    }

}
