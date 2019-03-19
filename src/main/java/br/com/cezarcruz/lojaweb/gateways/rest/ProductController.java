package br.com.cezarcruz.lojaweb.gateways.rest;

import br.com.cezarcruz.lojaweb.entities.Product;
import br.com.cezarcruz.lojaweb.gateways.rest.request.IncludeProductRequest;
import br.com.cezarcruz.lojaweb.gateways.rest.response.ProductResponse;
import br.com.cezarcruz.lojaweb.gateways.rest.converters.IncludeProductRequestToProduct;
import br.com.cezarcruz.lojaweb.gateways.rest.converters.ProductToProductResponse;
import br.com.cezarcruz.lojaweb.usecases.CreateProduct;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private CreateProduct createProduct;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody IncludeProductRequest productRequest) {

        final Product product = IncludeProductRequestToProduct.from(productRequest);
        final Product savedProduct = createProduct.execute(product);

        final ProductResponse productResponse = ProductToProductResponse.from(savedProduct);

        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);

    }

}
