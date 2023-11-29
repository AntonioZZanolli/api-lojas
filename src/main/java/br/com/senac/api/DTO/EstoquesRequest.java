package br.com.senac.api.DTO;

import br.com.senac.api.entidades.Lojas;
import br.com.senac.api.entidades.Produtos;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;

public class EstoquesRequest {
    private LojasRequest loja;

    private ProdutosRequest produto;

    private Long quantidade;

    public LojasRequest getLoja() {
        return loja;
    }

    public void setLoja(LojasRequest loja) {
        this.loja = loja;
    }

    public ProdutosRequest getProduto() {
        return produto;
    }

    public void setProduto(ProdutosRequest produto) {
        this.produto = produto;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
