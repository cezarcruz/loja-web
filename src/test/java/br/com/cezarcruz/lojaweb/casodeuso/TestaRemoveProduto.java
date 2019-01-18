package br.com.cezarcruz.lojaweb.casodeuso;

import br.com.cezarcruz.lojaweb.casodeuso.produtos.RemoveProduto;
import br.com.cezarcruz.lojaweb.data.repositorios.ProdutoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestaRemoveProduto {

    @MockBean
    private ProdutoRepository produtoRepository;

    @Autowired
    private RemoveProduto removeProduto;

    @Test
    public void excluiProduto() {
        doNothing().when(produtoRepository).deleteById(anyLong());

        removeProduto.executa(1L);
    }
}
