package br.com.senac.api.Mappers;

import br.com.senac.api.DTO.ProdutosRequest;
import br.com.senac.api.DTO.ProdutosResponse;
import br.com.senac.api.entidades.Produtos;

public class ProdutosMapper {
    public static Produtos produtosRequestToProdutos(ProdutosRequest produto) {
        Produtos out = new Produtos();
        out.setNome(produto.getNome());
        out.setCodigoEAN(produto.getCodigoEAN());
        out.setDescricao(produto.getDescricao());
        out.setId(produto.getId());

        return out;
    }

    public static ProdutosResponse produtosToProdutosResponse(Produtos produto) {
        ProdutosResponse out = new ProdutosResponse();

        out.setNome(produto.getNome());
        out.setCodigoEAN(produto.getCodigoEAN());
        out.setDescricao(produto.getDescricao());

        out.setId(produto.getId());

        return out;
    }
}
