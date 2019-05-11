package br.com.cezarcruz.lojaweb.exceptions;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class StandardError {

    private Integer code;
    private String message;

}
