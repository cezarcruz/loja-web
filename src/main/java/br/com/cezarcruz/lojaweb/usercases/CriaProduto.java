package br.com.cezarcruz.lojaweb.usercases;

import br.com.cezarcruz.lojaweb.entidade.Produto;
import br.com.cezarcruz.lojaweb.gateway.database.dao.ProdutoDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriaProduto {

    private ProdutoDAO produtoDAO;

    public Produto executa(final Produto produto) {
        return produtoDAO.salvar(produto);
    }

}
