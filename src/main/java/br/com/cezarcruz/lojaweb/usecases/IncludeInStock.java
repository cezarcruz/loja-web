package br.com.cezarcruz.lojaweb.usecases;

import br.com.cezarcruz.lojaweb.entities.Stock;
import br.com.cezarcruz.lojaweb.gateways.database.dao.StockDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IncludeInStock {

    private StockDAO stockDAO;

    public Stock execute(final Stock stock) {
        return stockDAO.save(stock);
    }

}
