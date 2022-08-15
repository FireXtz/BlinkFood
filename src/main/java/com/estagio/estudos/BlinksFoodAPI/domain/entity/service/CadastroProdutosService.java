package com.estagio.estudos.BlinksFoodAPI.domain.entity.service;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.Produtos;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CadastroProdutosService {
    @Autowired
    private ProdutosRepository produtosRepository;

    public List <Produtos> listAll(){
        return produtosRepository.findAll();
    }
    public Produtos saveProduct(Produtos produtos){
        return produtosRepository.save(produtos);
    }
    public ResponseEntity <Produtos> findByid(Long id){
        return produtosRepository.findById(id)
                .map(produtos -> ResponseEntity.ok().body(produtos))
                .orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity <Produtos> updateProdutos(Long id, Produtos produtos){
        return produtosRepository.findById(id)
                .map(produtosUpdate -> {
                    produtosUpdate.setAtivo(produtosUpdate.getAtivo());
                    produtosUpdate.setDescricao(produtosUpdate.getDescricao());
                    produtosUpdate.setAtivo(produtosUpdate.getAtivo());
                    Produtos produtos_save = produtosRepository.save(produtosUpdate);
                    return ResponseEntity.ok().body(produtos_save);
                }).orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity <Object> deleteByid(Long id){
        return produtosRepository.findById(id)
                .map(deleteByid-> {
                    produtosRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
