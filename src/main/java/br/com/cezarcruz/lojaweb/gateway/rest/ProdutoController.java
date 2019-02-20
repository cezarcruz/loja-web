package br.com.cezarcruz.lojaweb.gateway.rest;

import br.com.cezarcruz.lojaweb.gateway.rest.request.IncluiProdutoRequest;
import br.com.cezarcruz.lojaweb.gateway.rest.response.ProdutoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @PostMapping
    public ResponseEntity<ProdutoResponse> criaProduto(@RequestBody IncluiProdutoRequest produtoRequest) {

        final ProdutoResponse produto = ProdutoResponse.builder()
                .nome(produtoRequest.getNome())
                .valor(produtoRequest.getValor())
                .id(Calendar.getInstance().getTimeInMillis())
                .build();

        return ResponseEntity.ok(produto);
    }

}
