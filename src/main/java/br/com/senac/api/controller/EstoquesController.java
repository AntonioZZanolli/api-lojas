package br.com.senac.api.controller;

import br.com.senac.api.DTO.EstoquesRequest;
import br.com.senac.api.DTO.EstoquesResponse;
import br.com.senac.api.Mappers.EstoquesMapper;
import br.com.senac.api.entidades.Estoques;
import br.com.senac.api.repositorios.EstoquesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estoques")
public class EstoquesController {
    @Autowired
    private EstoquesRepository estoquesRepository;

    @GetMapping("/")
    @CrossOrigin
    public ResponseEntity<List<Estoques>> carregarEstoques() {
        List<Estoques> retorno = estoquesRepository.findAll();

        List<EstoquesResponse> out = retorno.stream().map(EstoquesMapper :: estoquesToEstoquesResponse).toList();

        return ResponseEntity.ok().body(retorno);
    }

    @PostMapping("/")
    @CrossOrigin
    public ResponseEntity<EstoquesResponse> criarEstoque(@RequestBody EstoquesRequest estoque) {
        Estoques envio = EstoquesMapper.estoquesRequestToEstoques(estoque);
        Estoques retorno = estoquesRepository.save(envio);

        return ResponseEntity.status(HttpStatus.CREATED).body(EstoquesMapper.estoquesToEstoquesResponse(retorno));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        estoquesRepository.deleteById(id);

        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<EstoquesResponse> atualizarEstoque(@PathVariable Long id, @RequestBody EstoquesRequest estoque) {
        Estoques retorno = estoquesRepository.findById(id).map(record -> {
            record.setQuantidade(estoque.getQuantidade());
            return estoquesRepository.save(record);
        }).get();

        return ResponseEntity.ok(EstoquesMapper.estoquesToEstoquesResponse(retorno));
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<EstoquesResponse> carregarEstoquesById(@PathVariable Long id) {
        Estoques retorno = estoquesRepository.findById(id).get();

        return ResponseEntity.ok(EstoquesMapper.estoquesToEstoquesResponse(retorno));
    }
}
