package br.com.cezarcruz.lojaweb.gateways.rest;

import br.com.cezarcruz.lojaweb.gateways.rest.converters.IncludeSellerToSeller;
import br.com.cezarcruz.lojaweb.gateways.rest.converters.SellerToSellerResponse;
import br.com.cezarcruz.lojaweb.gateways.rest.request.CreateSellerRequest;
import br.com.cezarcruz.lojaweb.gateways.rest.response.SellerResponse;
import br.com.cezarcruz.lojaweb.usecases.CreateSeller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/sellers")
@Api(value = "Sellers")
public class SellerController {

    private CreateSeller createSeller;

    @ApiOperation(value = "Creates a new Seller")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Seller created successfully"),
            @ApiResponse(code = 400, message = "API doesn't recognize sent parameters"),
            @ApiResponse(code = 412, message = "Seller already exists"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    @PostMapping
    public ResponseEntity<SellerResponse> createSeller(@RequestBody final CreateSellerRequest sellerRequest) {

        final var seller = IncludeSellerToSeller.from(sellerRequest);

        final var savedSeller = createSeller.execute(seller);

        final var sellerResponse = SellerToSellerResponse.from(savedSeller);

        return ResponseEntity.status(HttpStatus.CREATED).body(sellerResponse);
    }

}
