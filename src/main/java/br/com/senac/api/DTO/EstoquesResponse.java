package br.com.senac.api.DTO;

import br.com.senac.api.entidades.Lojas;
import br.com.senac.api.entidades.Produtos;

import java.util.List;

public class EstoquesResponse {
    private Long id;

    private Lojas loja;

    private Produtos produto;

    private Long quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lojas getLoja() {
        return loja;
    }

    public void setLoja(Lojas loja) {
        this.loja = loja;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
