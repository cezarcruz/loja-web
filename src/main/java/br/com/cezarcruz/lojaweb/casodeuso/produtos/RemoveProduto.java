package br.com.cezarcruz.lojaweb.casodeuso.produtos;

import br.com.cezarcruz.lojaweb.data.repositorios.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoveProduto {

    private ProdutoRepository produtoRepository;

    public RemoveProduto(final ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void executa(final Long id) {
        produtoRepository.deleteById(id);
    }
}
