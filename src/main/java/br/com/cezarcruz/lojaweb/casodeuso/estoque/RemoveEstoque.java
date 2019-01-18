package br.com.cezarcruz.lojaweb.casodeuso.estoque;

import br.com.cezarcruz.lojaweb.data.repositorios.EstoqueRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoveEstoque {

    private EstoqueRepository estoqueRepository;

    public RemoveEstoque(final EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    public void executa(final Long produtoId,
                        final Integer quantidade) {

        estoqueRepository.findByProdutoId(produtoId)
                .ifPresent(estoque ->  {
                    estoque.setQuantidade(estoque.getQuantidade() - quantidade);
                    estoqueRepository.save(estoque);
                });
    }

}
