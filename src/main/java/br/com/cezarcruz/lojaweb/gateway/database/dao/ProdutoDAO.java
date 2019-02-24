package br.com.cezarcruz.lojaweb.gateway.database.dao;

import br.com.cezarcruz.lojaweb.entidade.Produto;
import br.com.cezarcruz.lojaweb.gateway.database.conversor.ProdutoToProdutoEntity;
import br.com.cezarcruz.lojaweb.gateway.database.entidade.ProdutoEntity;
import br.com.cezarcruz.lojaweb.gateway.database.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutoDAO {

    private ProdutoRepository produtoRepository;

    public Produto salvar(final Produto produto) {

        final ProdutoEntity produtoEntity = ProdutoToProdutoEntity.de(produto);
        final ProdutoEntity produtoSalvo = produtoRepository.save(produtoEntity);
        return produto.toBuilder().id(produtoSalvo.getId()).build();

    }
}
