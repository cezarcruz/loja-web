package br.com.cezarcruz.lojaweb.gateways.rest.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SellerResponse {

    @ApiModelProperty(value = "Seller Full Name")
    private String name;

    @ApiModelProperty(value = "Seller Document")
    private String document;

}
