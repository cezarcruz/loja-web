package br.com.cezarcruz.lojaweb.casodeuso.estoque;

import br.com.cezarcruz.lojaweb.data.repositorios.EstoqueRepository;
import org.springframework.stereotype.Service;

@Service
public class ContemEstoque {

    private EstoqueRepository estoqueRepository;

    public ContemEstoque(final EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    public Boolean executa(final Long produtoId, final Integer quantidade) {
        final var produto
                = estoqueRepository.findByProdutoId(produtoId);
        return produto.filter(p -> p.getQuantidade() >= quantidade).isPresent();
    }

}
