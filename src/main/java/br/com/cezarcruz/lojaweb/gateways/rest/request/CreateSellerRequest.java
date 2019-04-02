package br.com.cezarcruz.lojaweb.gateways.rest.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
@ApiModel(value = "CreateSellerRequest", description = "Create seller requests")
public class CreateSellerRequest {

    @ApiModelProperty(value = "Seller Full Name", required = true)
    private String name;

    @ApiModelProperty(value = "Seller Document", required = true)
    private String document;
}

