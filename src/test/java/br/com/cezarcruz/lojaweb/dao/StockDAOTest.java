package br.com.cezarcruz.lojaweb.dao;

import br.com.cezarcruz.lojaweb.entities.Product;
import br.com.cezarcruz.lojaweb.entities.Stock;
import br.com.cezarcruz.lojaweb.exceptions.ProductNotExistException;
import br.com.cezarcruz.lojaweb.fixtures.ProductFixture;
import br.com.cezarcruz.lojaweb.gateways.database.dao.ProductDAO;
import br.com.cezarcruz.lojaweb.gateways.database.dao.StockDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StockDAOTest {

    @Autowired
    private StockDAO stockDAO;

    @Autowired
    private ProductDAO productDAO;

    @Test(expected = ProductNotExistException.class)
    public void shouldIncludeNewProductInStockWithId() {

        final Product product = ProductFixture.defaultValuesWithId();

        stockDAO.save(Stock.builder()
                .quantity(1)
                .product(product)
                .build());
    }

    @Test
    public void shouldIncrementStockOfExistentProduct() {
        final Product product = ProductFixture.defaultValuesWithId();
        final Product productSaved = productDAO.save(product);

        final Stock stock = stockDAO.save(Stock.builder().quantity(1).product(productSaved).build());


        assertNotNull(stock);
        assertEquals(product.getName(), stock.getProduct().getName());
        assertNotNull(stock.getId());
        assertEquals(productSaved.getId(), stock.getProduct().getId());
        assertEquals(Integer.valueOf(1), stock.getQuantity());
    }

}
