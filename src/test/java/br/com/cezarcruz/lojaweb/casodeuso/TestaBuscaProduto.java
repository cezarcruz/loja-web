package br.com.cezarcruz.lojaweb.casodeuso;

import br.com.cezarcruz.lojaweb.casodeuso.produtos.BuscaProduto;
import br.com.cezarcruz.lojaweb.casodeuso.produtos.IncluiProduto;
import br.com.cezarcruz.lojaweb.data.model.request.IncluiProdutoRequest;
import br.com.cezarcruz.lojaweb.data.model.request.PaginacaoRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TestaBuscaProduto {

    @Autowired
    private IncluiProduto incluiProduto;

    @Autowired
    private BuscaProduto buscaProduto;

    @Test
    public void buscaUmProduto() {
        final IncluiProdutoRequest incluiProdutoRequest = new IncluiProdutoRequest();
        incluiProdutoRequest.setDescricao("Produtinho");
        incluiProdutoRequest.setNome("ProdutoEntidade");
        incluiProdutoRequest.setPreco(10D);
        incluiProdutoRequest.setQuantidade(100);
        incluiProduto.executa(incluiProdutoRequest);

        final var produtoResponses
                = buscaProduto.buscaTodos(PaginacaoRequest.builder().pagina(0).tamanho(100).build());

        assertNotNull(produtoResponses.getData());
        assertEquals(1, produtoResponses.getData().size());
    }

    @Test
    public void buscaUmProdutoComFiltro() {
        final IncluiProdutoRequest incluiProdutoRequest = new IncluiProdutoRequest();
        incluiProdutoRequest.setDescricao("Produtinho");
        incluiProdutoRequest.setNome("ProdutoEntidade");
        incluiProdutoRequest.setPreco(10D);
        incluiProdutoRequest.setQuantidade(100);
        incluiProduto.executa(incluiProdutoRequest);

        final var produtoResponses
                = buscaProduto.buscaTodos(PaginacaoRequest.builder().pagina(0).tamanho(100).build(), "PRODU");

        assertNotNull(produtoResponses.getData());
        assertEquals(1, produtoResponses.getData().size());

        final var produtoResponses2
                = buscaProduto.buscaTodos(PaginacaoRequest.builder().pagina(0).tamanho(100).build(), "proDutoEntidadE");

        assertNotNull(produtoResponses2.getData());
        assertEquals(1, produtoResponses2.getData().size());

        final var produtoResponses3
                = buscaProduto.buscaTodos(PaginacaoRequest.builder().pagina(0).tamanho(100).build(), "navio");

        assertNotNull(produtoResponses3.getData());
        assertEquals(0, produtoResponses3.getData().size());

        final var produtoResponses4
                = buscaProduto.buscaTodos(PaginacaoRequest.builder().pagina(0).tamanho(100).build(), "");

        assertNotNull(produtoResponses4.getData());
        assertEquals(1, produtoResponses4.getData().size());
    }

}
