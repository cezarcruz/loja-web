package br.com.cezarcruz.lojaweb.web.rest;

import br.com.cezarcruz.lojaweb.casodeuso.produtos.BuscaProduto;
import br.com.cezarcruz.lojaweb.casodeuso.produtos.IncluiProduto;
import br.com.cezarcruz.lojaweb.casodeuso.produtos.RemoveProduto;
import br.com.cezarcruz.lojaweb.data.model.request.IncluiProdutoRequest;
import br.com.cezarcruz.lojaweb.data.model.request.PaginacaoRequest;
import br.com.cezarcruz.lojaweb.data.model.response.ProdutoResponse;
import br.com.cezarcruz.lojaweb.data.model.response.RespostaPaginavel;
import br.com.cezarcruz.lojaweb.excecao.ValidacaoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private IncluiProduto incluiProduto;
    private BuscaProduto buscaProduto;
    private RemoveProduto removeProduto;

    public ProdutoController(final IncluiProduto incluiProduto,
                             final BuscaProduto buscaProduto,
                             final RemoveProduto removeProduto) {
        this.incluiProduto = incluiProduto;
        this.buscaProduto = buscaProduto;
        this.removeProduto = removeProduto;
    }

    @PostMapping
    public ProdutoResponse post(@Valid @RequestBody final IncluiProdutoRequest incluiProdutoRequest,
                                final BindingResult bindingResult) {
        log.debug("incluiProdutoRequest = {}", incluiProdutoRequest);

        if (bindingResult.hasErrors()) {
            throw new ValidacaoException("Dados invalidos");
        }

        return incluiProduto.executa(incluiProdutoRequest);
    }

    @GetMapping("/{pagina}/{quantidade}")
    public RespostaPaginavel get(@PathVariable final Integer pagina,
                                 @PathVariable final Integer quantidade) {
        log.debug("buscando todos os produtos");
        return buscaProduto.buscaTodos(PaginacaoRequest.builder().pagina(pagina).tamanho(quantidade).build());

    }

    @GetMapping("/{pagina}/{quantidade}/{filtro}")
    public RespostaPaginavel get(@PathVariable final Integer pagina,
                                 @PathVariable final Integer quantidade,
                                 @PathVariable final String filtro) {

        log.debug("buscando todos os produtos");
        return buscaProduto.buscaTodos(PaginacaoRequest.builder().pagina(pagina).tamanho(quantidade).build(), filtro);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long id) {
        removeProduto.executa(id);
    }

}
