package br.com.cezarcruz.lojaweb.casodeuso.vendedores;

import br.com.cezarcruz.lojaweb.data.entidades.VendedorEntidade;
import br.com.cezarcruz.lojaweb.data.model.request.PaginacaoRequest;
import br.com.cezarcruz.lojaweb.data.model.response.RespostaPaginavel;
import br.com.cezarcruz.lojaweb.data.repositorios.VendedorRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuscaVendedor {

    private VendedorRepository vendedorRepository;

    public BuscaVendedor(final VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    public List<VendedorEntidade> executa() {
        return vendedorRepository.findAll();
    }

    public RespostaPaginavel buscaTodos(final PaginacaoRequest paginacao) {

        final Page<VendedorEntidade> produtosPaginados = vendedorRepository.findAll(paginacao.toPageRequest());

        var produtos = produtosPaginados
                .stream()
                .collect(Collectors.toList());

        return RespostaPaginavel.builder()
                .data(Collections.unmodifiableList(produtos))
                .tamanho(produtosPaginados.getTotalElements())
                .build();
    }

    public Optional<VendedorEntidade> obtem(final Long id) {
        return vendedorRepository.findById(id);
    }

    public RespostaPaginavel buscaTodos(final PaginacaoRequest paginacao,
                                        final String filtro) {
        final var produtosPaginados = vendedorRepository.findByNomeContaining(paginacao.toPageRequest(), filtro);

        return RespostaPaginavel.builder()
                .data(Collections.unmodifiableList(produtosPaginados.getContent()))
                .tamanho(produtosPaginados.getTotalElements())
                .build();
    }

    public List<VendedorEntidade> porNome(final String nome) {
        return vendedorRepository.findAllByNomeIgnoreCase(nome);
    }
}
