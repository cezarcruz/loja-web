package br.com.cezarcruz.lojaweb.usecases;

import br.com.cezarcruz.lojaweb.entities.Product;
import br.com.cezarcruz.lojaweb.fixtures.ProductFixture;
import br.com.cezarcruz.lojaweb.gateways.database.dao.ProductDAO;
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
public class CreateProductTest {


    @InjectMocks
    public CreateProduct createProduct;

    @Mock
    private ProductDAO productDAO;

    @Test
    public void shouldCreateNewProduct() {

        final Product productToSave = ProductFixture.defaultValues();

        when(productDAO.save(any())).thenReturn(productToSave.toBuilder().id(1L).build());

        final Product savedProduct
                = createProduct.execute(productToSave);

        assertNotNull(savedProduct);
        assertEquals(Long.valueOf(1L), savedProduct.getId());
        assertEquals(productToSave.getName(), savedProduct.getName());
        assertEquals(productToSave.getPrice(), savedProduct.getPrice());

    }

}
