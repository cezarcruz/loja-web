package br.com.cezarcruz.lojaweb.gateways.rest;

import br.com.cezarcruz.lojaweb.gateways.rest.converters.IncludeProductRequestToProduct;
import br.com.cezarcruz.lojaweb.gateways.rest.converters.IncludeStockRequestToStock;
import br.com.cezarcruz.lojaweb.gateways.rest.converters.ProductToProductResponse;
import br.com.cezarcruz.lojaweb.gateways.rest.converters.StockToStockResponse;
import br.com.cezarcruz.lojaweb.gateways.rest.request.IncludeProductRequest;
import br.com.cezarcruz.lojaweb.gateways.rest.request.IncludeStockRequest;
import br.com.cezarcruz.lojaweb.gateways.rest.response.ProductResponse;
import br.com.cezarcruz.lojaweb.gateways.rest.response.StockResponse;
import br.com.cezarcruz.lojaweb.usecases.CreateProduct;
import br.com.cezarcruz.lojaweb.usecases.IncludeInStock;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Api(value = "Products")
public class ProductController {

    private CreateProduct createProduct;
    private IncludeInStock includeInStock;

    @PostMapping
    @ApiOperation(value = "Creates a new Product")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Product created successfully"),
            @ApiResponse(code = 400, message = "API doesn't recognize sent parameters"),
            @ApiResponse(code = 412, message = "Product already exists"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    public ResponseEntity<ProductResponse> createProduct(@RequestBody IncludeProductRequest productRequest) {

        final var product = IncludeProductRequestToProduct.from(productRequest);
        final var savedProduct = createProduct.execute(product);

        final var productResponse = ProductToProductResponse.from(savedProduct);

        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);

    }

    @PostMapping("/{productId}/stock")
    public ResponseEntity<StockResponse> includeInStock(@PathVariable final Long productId,
                                                        @RequestBody IncludeStockRequest includeStockRequest) {

        final var stock = IncludeStockRequestToStock.from(productId, includeStockRequest);

        final var stockUpdated = includeInStock.execute(stock);

        final var stockResponse = StockToStockResponse.from(stockUpdated);

        return ResponseEntity.ok(stockResponse);

    }

}
