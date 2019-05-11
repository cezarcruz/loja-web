package br.com.cezarcruz.lojaweb.usecases;

import br.com.cezarcruz.lojaweb.entities.Seller;
import br.com.cezarcruz.lojaweb.fixtures.SellerFixture;
import br.com.cezarcruz.lojaweb.gateways.database.dao.SellerDAO;
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
public class CreateSellerTest {

    @InjectMocks
    private CreateSeller createSeller;

    @Mock
    private SellerDAO sellerDAO;

    @Test
    public void shouldCreateSeller() {

        final Seller withDefaultValues = SellerFixture.withDefaultValues();
        when(sellerDAO.save(any()))
                .thenReturn(withDefaultValues);

        final Seller seller = createSeller.execute(withDefaultValues);

        assertNotNull(seller);

        assertEquals(withDefaultValues.getDocument(), seller.getDocument());
        assertEquals(withDefaultValues.getName(), seller.getName());
    }

}
