package br.com.cezarcruz.lojaweb.gateways.rest.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
@ApiModel(value = "ProductResponse", description = "Product Response")
public class ProductResponse {

    @ApiModelProperty(value = "Product Identification Code")
    private Long id;

    @ApiModelProperty(value = "Product Name")
    private String name;

    @ApiModelProperty(value = "Product Price")
    private BigDecimal price;

}
