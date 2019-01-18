package br.com.cezarcruz.lojaweb.web.rest;


import br.com.cezarcruz.lojaweb.casodeuso.vendas.BuscaVendas;
import br.com.cezarcruz.lojaweb.casodeuso.vendas.RealizaVenda;
import br.com.cezarcruz.lojaweb.data.model.request.VendaRequest;
import br.com.cezarcruz.lojaweb.data.model.response.VendaResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private RealizaVenda realizaVenda;
    private BuscaVendas buscaVendas;

    public VendaController(final RealizaVenda realizaVenda,
                           final BuscaVendas buscaVendas) {
        this.realizaVenda = realizaVenda;
        this.buscaVendas = buscaVendas;
    }

    @PostMapping
    public VendaResponse post(@RequestBody final VendaRequest entrada) {
        return realizaVenda.executa(entrada);
    }

    @GetMapping
    public List<VendaResponse> get() {
        return buscaVendas.executa();
    }

}
