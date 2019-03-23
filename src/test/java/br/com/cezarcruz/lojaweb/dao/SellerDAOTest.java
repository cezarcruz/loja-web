package br.com.cezarcruz.lojaweb.dao;

import br.com.cezarcruz.lojaweb.entities.Seller;
import br.com.cezarcruz.lojaweb.fixtures.SellerFixture;
import br.com.cezarcruz.lojaweb.gateways.database.dao.SellerDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerDAOTest {

    @Autowired
    private SellerDAO sellerDAO;

    @Test
    public void shouldCreateNewSeller() {
        final Seller sellerToSave = SellerFixture.withDefaultValues();
        final Seller savedSeller = sellerDAO.save(sellerToSave);

        assertNotNull(savedSeller);
        assertEquals(sellerToSave.getName(), savedSeller.getName());
        assertEquals(sellerToSave.getDocument(), savedSeller.getDocument());
    }

}
