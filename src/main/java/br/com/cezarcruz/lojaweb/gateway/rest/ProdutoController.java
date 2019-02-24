package br.com.cezarcruz.lojaweb.gateway.rest;

import br.com.cezarcruz.lojaweb.entidade.Produto;
import br.com.cezarcruz.lojaweb.gateway.rest.request.IncluiProdutoRequest;
import br.com.cezarcruz.lojaweb.gateway.rest.response.ProdutoResponse;
import br.com.cezarcruz.lojaweb.gateway.rest.transformacao.IncluirProdutoRequestParaProduto;
import br.com.cezarcruz.lojaweb.gateway.rest.transformacao.ProdutoToProdutoResponse;
import br.com.cezarcruz.lojaweb.usercases.CriaProduto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutoController {

    private CriaProduto criaProduto;

    @PostMapping
    public ResponseEntity<ProdutoResponse> criaProduto(@RequestBody IncluiProdutoRequest produtoRequest) {

        final Produto produto = IncluirProdutoRequestParaProduto.de(produtoRequest);
        final Produto produtoSalvo = criaProduto.executa(produto);

        final ProdutoResponse produtoResponse = ProdutoToProdutoResponse.de(produtoSalvo);

        return ResponseEntity.ok(produtoResponse);

    }

}
