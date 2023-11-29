package br.com.senac.api.Mappers;

import br.com.senac.api.DTO.LojasRequest;
import br.com.senac.api.DTO.LojasResponse;
import br.com.senac.api.entidades.Lojas;

public class LojasMapper {
    public static Lojas lojasRequestToLojas(LojasRequest loja) {
     Lojas out = new Lojas();
     out.setNome(loja.getNome());
     out.setCnpj(loja.getCnpj());
     out.setResponsavel(loja.getResponsavel());
     out.setId(loja.getId());

     return out;
    }

    public static LojasResponse lojasToLojasResponse(Lojas loja) {
    LojasResponse out = new LojasResponse();

    out.setNome(loja.getNome());
    out.setCnpj(loja.getCnpj());
    out.setResponsavel(loja.getResponsavel());

    out.setId(loja.getId());

    return out;
    }
}
