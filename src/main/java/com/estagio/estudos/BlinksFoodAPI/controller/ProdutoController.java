package com.estagio.estudos.BlinksFoodAPI.controller;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.Produtos;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.service.CadastroProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private CadastroProdutosService cadastroProdutosService;
    @GetMapping
    public List <Produtos> listAll(){
        return cadastroProdutosService.listAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produtos saveProduct(@RequestBody Produtos produtos){
        return cadastroProdutosService.saveProduct(produtos);
    }
    @GetMapping("/{produtosid}")
    public ResponseEntity<Produtos> getByid(@PathVariable("produtosid")Long id){
        return cadastroProdutosService.findByid(id);
    }
    @PutMapping("/{produtosid}")
    public ResponseEntity <Produtos> updateProdutos(@PathVariable("produtosid") Long id, @RequestBody Produtos produtos) {
        return cadastroProdutosService.updateProdutos(id, produtos);
    }
    @DeleteMapping("/{produtosid}")
    public ResponseEntity <Object> deleteByid(@PathVariable("produtosid") Long id){
        return cadastroProdutosService.deleteByid(id);
    }
}
