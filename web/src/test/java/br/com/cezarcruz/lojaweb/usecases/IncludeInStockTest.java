package br.com.cezarcruz.lojaweb.usecases;

import br.com.cezarcruz.lojaweb.entities.Stock;
import br.com.cezarcruz.lojaweb.exceptions.ProductNotExistException;
import br.com.cezarcruz.lojaweb.fixtures.ProductFixture;
import br.com.cezarcruz.lojaweb.fixtures.StockFixture;
import br.com.cezarcruz.lojaweb.gateways.database.dao.ProductDAO;
import br.com.cezarcruz.lojaweb.gateways.database.dao.StockDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IncludeInStockTest {

    @InjectMocks
    private IncludeInStock includeInStock;

    @Mock
    private StockDAO stockDAO;

    @Mock
    private ProductDAO productDAO;

    @Test(expected = ProductNotExistException.class)
    public void shouldThrowWhenProductNotExist() {
        when(productDAO.findById(anyLong()))
                .thenReturn(Optional.empty());

        includeInStock.execute(StockFixture.withDefaultValues());

    }

    @Test
    public void shouldIncludeStockInExistingProduct() {
        when(productDAO.findById(null))
                .thenReturn(Optional.of(ProductFixture.defaultValuesWithId()));

        final Stock stock = StockFixture.withDefaultValues();

        when(stockDAO.save(any()))
                .thenReturn(stock);

        final Stock execute = includeInStock.execute(stock);

        assertNotNull(execute);
        assertEquals(stock.getQuantity(), execute.getQuantity());
        assertEquals(stock.getProduct().getName(), execute.getProduct().getName());

    }

}
