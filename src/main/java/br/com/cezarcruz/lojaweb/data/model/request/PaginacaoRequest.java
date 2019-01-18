package br.com.cezarcruz.lojaweb.data.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;

@Data
@AllArgsConstructor
@Builder
public class PaginacaoRequest {
    private Integer pagina;
    private Integer tamanho;

    public PageRequest toPageRequest() {
        return PageRequest.of(pagina, tamanho);
    }
}
