package br.com.cezarcruz.lojaweb.gateways.rest;

import br.com.cezarcruz.lojaweb.entities.Seller;
import br.com.cezarcruz.lojaweb.gateways.rest.converters.IncludeSellerToSeller;
import br.com.cezarcruz.lojaweb.gateways.rest.converters.SellerToSellerResponse;
import br.com.cezarcruz.lojaweb.gateways.rest.request.CreateSellerRequest;
import br.com.cezarcruz.lojaweb.gateways.rest.response.SellerResponse;
import br.com.cezarcruz.lojaweb.usecases.CreateSeller;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sellers")
@AllArgsConstructor
public class SellerController {

    private CreateSeller createSeller;

    @PostMapping
    public ResponseEntity<SellerResponse> createSeller(@RequestBody final CreateSellerRequest sellerRequest) {

        final var seller = IncludeSellerToSeller.from(sellerRequest);

        final var savedSeller = createSeller.execute(seller);

        final var sellerResponse = SellerToSellerResponse.from(savedSeller);

        return ResponseEntity.status(HttpStatus.CREATED).body(sellerResponse);
    }

}
