package br.com.cezarcruz.lojaweb.usecases;

import br.com.cezarcruz.lojaweb.entities.Seller;
import br.com.cezarcruz.lojaweb.gateways.database.dao.SellerDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateSeller {

    private SellerDAO sellerDAO;

    public Seller execute(final Seller seller) {
        return sellerDAO.save(seller);
    }

}
