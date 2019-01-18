package br.com.cezarcruz.lojaweb.transformacao;

import br.com.cezarcruz.lojaweb.data.entidades.ProdutoEntidade;
import br.com.cezarcruz.lojaweb.data.model.response.ProdutoResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoParaProdutoResponse {

    private ProdutoParaProdutoResponse() {}

    public static ProdutoResponse para(final ProdutoEntidade produto) {
        return ProdutoResponse.builder()
                .id(produto.getId()).nome(produto.getNome())
                .descricao(produto.getDescricao())
                .preco(produto.getPreco())
                .quantidade(produto.getEstoque().getQuantidade())
                .build();
    }

    public static List<ProdutoResponse> para(final List<ProdutoEntidade> produtos) {
        return produtos.stream()
                .map(ProdutoParaProdutoResponse::para)
                .collect(Collectors.toList());
    }

}
