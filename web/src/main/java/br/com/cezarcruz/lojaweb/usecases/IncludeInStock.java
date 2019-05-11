package br.com.cezarcruz.lojaweb.usecases;

import br.com.cezarcruz.lojaweb.entities.Stock;
import br.com.cezarcruz.lojaweb.exceptions.ProductNotExistException;
import br.com.cezarcruz.lojaweb.gateways.database.dao.ProductDAO;
import br.com.cezarcruz.lojaweb.gateways.database.dao.StockDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class IncludeInStock {

    private StockDAO stockDAO;
    private ProductDAO productDAO;

    public Stock execute(final Stock stock) {

        productDAO.findById(stock.getProduct().getId())
                    .orElseThrow((Supplier<RuntimeException>) ProductNotExistException::new);

        return stockDAO.save(stock);
    }

}
