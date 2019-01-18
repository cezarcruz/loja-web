package br.com.cezarcruz.lojaweb.web.rest;

import br.com.cezarcruz.lojaweb.casodeuso.vendedores.BuscaVendedor;
import br.com.cezarcruz.lojaweb.casodeuso.vendedores.IncluiVendedor;
import br.com.cezarcruz.lojaweb.casodeuso.vendedores.RemoveVendedor;
import br.com.cezarcruz.lojaweb.data.entidades.VendedorEntidade;
import br.com.cezarcruz.lojaweb.data.model.Vendedor;
import br.com.cezarcruz.lojaweb.data.model.request.IncluiVendedorRequest;
import br.com.cezarcruz.lojaweb.data.model.request.PaginacaoRequest;
import br.com.cezarcruz.lojaweb.data.model.response.RespostaPaginavel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    private IncluiVendedor incluiVendedor;
    private BuscaVendedor buscaVendedor;
    private RemoveVendedor removeVendedor;

    public VendedorController(final IncluiVendedor incluiVendedor,
                              final BuscaVendedor buscaVendedor,
                              final RemoveVendedor removeVendedor) {
        this.incluiVendedor = incluiVendedor;
        this.buscaVendedor = buscaVendedor;
        this.removeVendedor = removeVendedor;
    }

    @PostMapping
    public ResponseEntity<Vendedor> post(@RequestBody final IncluiVendedorRequest entrada) {

        final Vendedor vendedorSalvo = incluiVendedor.executa(entrada);

        if (vendedorSalvo == null) {
            return ResponseEntity.unprocessableEntity().build();
        }

        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vendedorSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(vendedorSalvo);

    }

    @GetMapping("/{pagina}/{quantidade}")
    public RespostaPaginavel get(@PathVariable final Integer pagina,
                                 @PathVariable final Integer quantidade) {
        return buscaVendedor.buscaTodos(PaginacaoRequest.builder().pagina(pagina).tamanho(quantidade).build());
    }

    @GetMapping("/{pagina}/{quantidade}/{filtro}")
    public RespostaPaginavel get(@PathVariable final Integer pagina,
                                 @PathVariable final Integer quantidade,
                                 @PathVariable final String filtro) {

        return buscaVendedor.buscaTodos(PaginacaoRequest.builder().pagina(pagina).tamanho(quantidade).build(), filtro);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
        removeVendedor.executa(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorEntidade> get(@PathVariable final Long id) {
        final VendedorEntidade vendedor = buscaVendedor.obtem(id).orElse(null);

        if (vendedor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vendedor);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<VendedorEntidade>> get(@PathVariable final String nome) {
        final List<VendedorEntidade> vendedores = buscaVendedor.porNome(nome);

        if (vendedores.isEmpty()) {
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vendedores);
    }

}
