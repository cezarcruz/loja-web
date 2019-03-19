package br.com.cezarcruz.lojaweb.usecases;

import br.com.cezarcruz.lojaweb.entities.Product;
import br.com.cezarcruz.lojaweb.gateways.database.dao.ProductDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateProduct {

    private ProductDAO productDAO;

    public Product execute(final Product product) {
        return productDAO.save(product);
    }

}
