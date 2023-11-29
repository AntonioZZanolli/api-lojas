package br.com.senac.api.Mappers;

import br.com.senac.api.DTO.EstoquesRequest;
import br.com.senac.api.DTO.EstoquesResponse;
import br.com.senac.api.DTO.LojasResponse;
import br.com.senac.api.DTO.ProdutosResponse;
import br.com.senac.api.entidades.Estoques;
import br.com.senac.api.entidades.Lojas;
import br.com.senac.api.entidades.Produtos;

import java.util.List;

public class EstoquesMapper {
    public static Estoques estoquesRequestToEstoques(EstoquesRequest estoque) {
        Estoques out = new Estoques();

        out.setLoja(LojasMapper.lojasRequestToLojas(estoque.getLoja()));
        out.setProduto(ProdutosMapper.produtosRequestToProdutos(estoque.getProduto()));
        out.setQuantidade(estoque.getQuantidade());

        return out;
    }

    public static EstoquesResponse estoquesToEstoquesResponse(Estoques estoque) {
        EstoquesResponse out = new EstoquesResponse();

        out.setQuantidade(estoque.getQuantidade());
        out.setId(estoque.getId());
        out.setLoja(estoque.getLoja());
        out.setProduto(estoque.getProduto());

        return out;
    }
}
