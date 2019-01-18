package br.com.cezarcruz.lojaweb.casodeuso;

import br.com.cezarcruz.lojaweb.casodeuso.produtos.IncluiProduto;
import br.com.cezarcruz.lojaweb.casodeuso.vendas.RealizaVenda;
import br.com.cezarcruz.lojaweb.casodeuso.vendedores.IncluiVendedor;
import br.com.cezarcruz.lojaweb.data.enums.TipoPagamento;
import br.com.cezarcruz.lojaweb.data.model.Vendedor;
import br.com.cezarcruz.lojaweb.data.model.request.IncluiProdutoRequest;
import br.com.cezarcruz.lojaweb.data.model.request.IncluiVendedorRequest;
import br.com.cezarcruz.lojaweb.data.model.request.ProdutoQuantidadeRequest;
import br.com.cezarcruz.lojaweb.data.model.request.VendaRequest;
import br.com.cezarcruz.lojaweb.data.model.response.ProdutoResponse;
import br.com.cezarcruz.lojaweb.data.model.response.VendaResponse;
import br.com.cezarcruz.lojaweb.excecao.ValidacaoException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestaRealizaVenda {

    @Autowired
    private IncluiVendedor incluiVendedor;

    @Autowired
    private IncluiProduto incluiProduto;

    @Autowired
    private RealizaVenda realizaVenda;

    private Vendedor vendedorSalvo;
    private ProdutoResponse produtoSalvo;
    private ProdutoResponse produtoSalvo2;

    @Before
    public void antes() {
        final IncluiVendedorRequest vendedorRequest
                = IncluiVendedorRequest.builder().nome("Vejeta").build();

        IncluiProdutoRequest produto = new IncluiProdutoRequest();
        produto.setDescricao("Agua potavio");
        produto.setNome("Agua");
        produto.setPreco(5D);
        produto.setQuantidade(50);

        produtoSalvo = incluiProduto.executa(produto);
        produtoSalvo2 = incluiProduto.executa(produto);
        vendedorSalvo = incluiVendedor.executa(vendedorRequest);
    }

    @Test
    public void realizaVenda() {

        final VendaRequest vendaRequest = new VendaRequest();
        vendaRequest.setVendedor(vendedorSalvo.getId());
        final ArrayList<ProdutoQuantidadeRequest> produtoQuantidade = new ArrayList<>();
        produtoQuantidade.add(new ProdutoQuantidadeRequest(produtoSalvo.getId(), 10));
        produtoQuantidade.add(new ProdutoQuantidadeRequest(produtoSalvo2.getId(), 10));
        vendaRequest.setProdutoQuantidade(produtoQuantidade);
        vendaRequest.setTipoPagamento(TipoPagamento.DINHEIRO);
        final VendaResponse vendaRealizada = realizaVenda.executa(vendaRequest);

        assertNotNull(vendaRealizada);
        assertEquals(100D, vendaRealizada.getValorTotal(), 0);
        assertEquals(2, vendaRealizada.getProdutos().size());
        assertNotNull(vendaRealizada.getId());
        assertNotNull(vendaRealizada.getVendedor());
        assertNotNull(vendaRealizada.getDataVenda());
        assertEquals(TipoPagamento.DINHEIRO, vendaRealizada.getTipoPagamento());

        vendaRequest.setValorTotal(10d);
        final VendaResponse novaVenda = realizaVenda.executa(vendaRequest);
        assertEquals(10d, novaVenda.getValorTotal(), 0);

        vendaRequest.setValorTotal(0d);
        final VendaResponse vendaZeroValorTotal = realizaVenda.executa(vendaRequest);
        assertEquals(100D, vendaZeroValorTotal.getValorTotal(), 0);

    }

    @Test(expected = ValidacaoException.class)
    public void naoDeveRelizarVendaProdutoInvalido() {
        final VendaRequest vendaRequest = new VendaRequest();
        final ArrayList<ProdutoQuantidadeRequest> produtoQuantidade = new ArrayList<>();
        produtoQuantidade.add(new ProdutoQuantidadeRequest(10L, 10));
        vendaRequest.setProdutoQuantidade(produtoQuantidade);
        vendaRequest.setVendedor(vendedorSalvo.getId());
        realizaVenda.executa(vendaRequest);
    }

    @Test(expected = ValidacaoException.class)
    public void naoRealizaVendaSemEstoque() {
        final VendaRequest venda = new VendaRequest();
        final ArrayList<ProdutoQuantidadeRequest> produtoQuantidade = new ArrayList<>();
        produtoQuantidade.add(new ProdutoQuantidadeRequest(produtoSalvo.getId(), 1000));
        venda.setProdutoQuantidade(produtoQuantidade);
        venda.setVendedor(vendedorSalvo.getId());
        realizaVenda.executa(venda);
    }

    @Test(expected = ValidacaoException.class)
    public void testaProdutoQuantidadeVazio() {
        final VendaRequest venda = new VendaRequest();
        final ArrayList<ProdutoQuantidadeRequest> produtoQuantidade = new ArrayList<>();
        venda.setProdutoQuantidade(produtoQuantidade);
        venda.setVendedor(vendedorSalvo.getId());
        realizaVenda.executa(venda);
    }
}
