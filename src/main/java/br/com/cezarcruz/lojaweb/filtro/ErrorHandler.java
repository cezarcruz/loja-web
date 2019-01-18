package br.com.cezarcruz.lojaweb.filtro;

import br.com.cezarcruz.lojaweb.data.enums.TipoErro;
import br.com.cezarcruz.lojaweb.data.model.response.ValidacaoErroResponse;
import br.com.cezarcruz.lojaweb.excecao.ValidacaoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<Object> handleValidacaoException(final ValidacaoException ex) {
        log.error("erro ao realizar validacao", ex);

        final ValidacaoErroResponse validacaoErroResponse = new ValidacaoErroResponse();
        validacaoErroResponse.setNome(TipoErro.VALIDACAO.getInfo());

        return new ResponseEntity<>(validacaoErroResponse, HttpStatus.BAD_REQUEST);
    }
}
