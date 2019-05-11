package br.com.cezarcruz.lojaweb.gateways.rest.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncludeStockRequest {
    private Integer quantity;
}
