package br.com.cezarcruz.lojaweb.gateways.database.dao;

import br.com.cezarcruz.lojaweb.entities.Stock;
import br.com.cezarcruz.lojaweb.exceptions.ProductNotExistException;
import br.com.cezarcruz.lojaweb.gateways.database.converters.StockToStockEntity;
import br.com.cezarcruz.lojaweb.gateways.database.entities.ProductEntity;
import br.com.cezarcruz.lojaweb.gateways.database.entities.StockEntity;
import br.com.cezarcruz.lojaweb.gateways.database.repositories.ProductRepository;
import br.com.cezarcruz.lojaweb.gateways.database.repositories.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.function.Supplier;


@Service
@AllArgsConstructor
public class StockDAO {

    private StockRepository stockRepository;
    private ProductRepository productRepository;

    public Stock save(final Stock stock) {

        Assert.notNull(stock.getProduct(), "product cannot be null");
        Assert.notNull(stock.getProduct().getId(), "product must exist");

        final ProductEntity productEntity
                = productRepository.findById(stock.getProduct().getId())
                    .orElseThrow((Supplier<RuntimeException>) ProductNotExistException::new);

        final StockEntity stockEntity
                = StockToStockEntity.from(stock);

        final StockEntity withProduct
                = stockEntity.toBuilder().product(productEntity).build();

        final StockEntity save = stockRepository.save(withProduct);

        return StockToStockEntity.from(save);

    }

}
