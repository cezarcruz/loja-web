package br.com.cezarcruz.lojaweb.gateways.rest.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@ApiModel(value = "IncludeProductRequest", description = "Create product request")
public class IncludeProductRequest {

    @ApiModelProperty(value = "Product Name")
    private String name;

    @ApiModelProperty(value = "Product Price")
    private BigDecimal price;

}
