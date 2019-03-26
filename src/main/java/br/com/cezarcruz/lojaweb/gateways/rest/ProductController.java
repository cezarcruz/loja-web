package br.com.cezarcruz.lojaweb.gateways.rest;

import br.com.cezarcruz.lojaweb.entities.Product;
import br.com.cezarcruz.lojaweb.entities.Stock;
import br.com.cezarcruz.lojaweb.gateways.rest.converters.IncludeStockRequestToStock;
import br.com.cezarcruz.lojaweb.gateways.rest.converters.StockToStockResponse;
import br.com.cezarcruz.lojaweb.gateways.rest.request.IncludeProductRequest;
import br.com.cezarcruz.lojaweb.gateways.rest.request.IncludeStockRequest;
import br.com.cezarcruz.lojaweb.gateways.rest.response.ProductResponse;
import br.com.cezarcruz.lojaweb.gateways.rest.converters.IncludeProductRequestToProduct;
import br.com.cezarcruz.lojaweb.gateways.rest.converters.ProductToProductResponse;
import br.com.cezarcruz.lojaweb.gateways.rest.response.StockResponse;
import br.com.cezarcruz.lojaweb.usecases.CreateProduct;
import br.com.cezarcruz.lojaweb.usecases.IncludeInStock;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private CreateProduct createProduct;
    private IncludeInStock includeInStock;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody IncludeProductRequest productRequest) {

        final Product product = IncludeProductRequestToProduct.from(productRequest);
        final Product savedProduct = createProduct.execute(product);

        final ProductResponse productResponse = ProductToProductResponse.from(savedProduct);

        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);

    }

    @PostMapping("/{productId}/stock")
    public ResponseEntity<StockResponse> includeInStock(@PathVariable final Long productId,
                                                        @RequestBody IncludeStockRequest includeStockRequest) {

        final Stock stock = IncludeStockRequestToStock.from(productId, includeStockRequest);

        final Stock stockUpdated = includeInStock.execute(stock);

        final StockResponse stockResponse = StockToStockResponse.from(stockUpdated);

        return ResponseEntity.ok(stockResponse);

    }

}
