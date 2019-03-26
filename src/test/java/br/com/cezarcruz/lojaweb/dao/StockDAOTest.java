package br.com.cezarcruz.lojaweb.dao;

import br.com.cezarcruz.lojaweb.entities.Product;
import br.com.cezarcruz.lojaweb.entities.Stock;
import br.com.cezarcruz.lojaweb.exceptions.ProductNotExistException;
import br.com.cezarcruz.lojaweb.fixtures.ProductFixture;
import br.com.cezarcruz.lojaweb.gateways.database.converters.ProductToProductEntity;
import br.com.cezarcruz.lojaweb.gateways.database.dao.ProductDAO;
import br.com.cezarcruz.lojaweb.gateways.database.dao.StockDAO;
import br.com.cezarcruz.lojaweb.gateways.database.repositories.ProductRepository;
import br.com.cezarcruz.lojaweb.gateways.database.repositories.StockRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StockDAOTest {

    @InjectMocks
    private StockDAO stockDAO;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockRepository stockRepository;

    @Autowired
    private ProductDAO productDAO;

    @Test(expected = ProductNotExistException.class)
    public void shouldThrowWhenProductNotExist() {

        final Product product = ProductFixture.defaultValuesWithId();

        when(productRepository.findById(any()))
                .thenReturn(Optional.empty());

        stockDAO.save(Stock.builder()
                .quantity(1)
                .product(product)
                .build());
    }

    @Test
    @Ignore
    public void shouldIncrementStockOfExistentProduct() {
        final Product product = ProductFixture.defaultValuesWithId();
        final Product productSaved = productDAO.save(product);

        when(productRepository.findById(any()))
                .thenReturn(Optional.of(ProductToProductEntity.from(productSaved)));

        final Stock stock = stockDAO.save(Stock.builder().quantity(1).product(productSaved).build());

        assertNotNull(stock);
        assertEquals(product.getName(), stock.getProduct().getName());
        assertNotNull(stock.getId());
        assertEquals(productSaved.getId(), stock.getProduct().getId());
        assertEquals(Integer.valueOf(1), stock.getQuantity());
    }

}
