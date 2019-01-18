package br.com.cezarcruz.lojaweb.data.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespostaPaginavel {
    private Long tamanho;
    private List<Object> data;
}
