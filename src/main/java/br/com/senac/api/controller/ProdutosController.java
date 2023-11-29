package br.com.senac.api.controller;

import br.com.senac.api.DTO.ProdutosRequest;
import br.com.senac.api.DTO.ProdutosResponse;
import br.com.senac.api.Mappers.ProdutosMapper;
import br.com.senac.api.entidades.Produtos;
import br.com.senac.api.repositorios.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
    @Autowired
    private ProdutosRepository produtosRepository;

    @GetMapping("/")
    @CrossOrigin
    public ResponseEntity<List<ProdutosResponse>> carregarProdutos() {
        List<Produtos> retorno = produtosRepository.findAll();

        List<ProdutosResponse> out = retorno.stream().map(ProdutosMapper:: produtosToProdutosResponse).toList();
        return ResponseEntity.ok().body(out);
    }

    @PostMapping("/")
    @CrossOrigin
    public ResponseEntity<ProdutosResponse> criarProduto(@RequestBody ProdutosRequest produto) {
        Produtos envio = ProdutosMapper.produtosRequestToProdutos(produto);
        Produtos retorno = produtosRepository.save(envio);

        return ResponseEntity.status(HttpStatus.CREATED).body(ProdutosMapper.produtosToProdutosResponse(retorno));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtosRepository.deleteById(id);

        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<ProdutosResponse> atualizarProduto(@PathVariable Long id, @RequestBody ProdutosRequest produto) {
        Produtos retorno = produtosRepository.findById(id).map(record -> {
            record.setNome(produto.getNome());
            record.setCodigoEAN(produto.getCodigoEAN());
            record.setDescricao(produto.getDescricao());
            return produtosRepository.save(record);
        }).get();

        return ResponseEntity.ok(ProdutosMapper.produtosToProdutosResponse(retorno));
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<ProdutosResponse> carregarProdutosById(@PathVariable Long id) {
        Produtos retorno = produtosRepository.findById(id).get();

        return ResponseEntity.ok(ProdutosMapper.produtosToProdutosResponse(retorno));
    }
}
