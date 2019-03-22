package br.com.cezarcruz.lojaweb.dao;

import br.com.cezarcruz.lojaweb.entities.Product;
import br.com.cezarcruz.lojaweb.fixtures.ProductFixture;
import br.com.cezarcruz.lojaweb.gateways.database.dao.ProductDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDAOTest {

    @Autowired
    private ProductDAO productDAO;

    @Test
    public void shouldSalveNewProduct() {
        final Product productToSave = ProductFixture.defaultValues();

        final Product productSaved = productDAO.save(productToSave);

        assertNotNull(productSaved);
        assertNotNull(productSaved.getId());
        assertEquals(productToSave.getName(), productSaved.getName());
        assertEquals(productToSave.getPrice(), productSaved.getPrice());
    }
}
