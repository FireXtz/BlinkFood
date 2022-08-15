package com.estagio.estudos.BlinksFoodAPI.controller;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.Cozinha;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.repository.CozinhaRepository;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.service.CadastroCozinhaService;
import com.estagio.estudos.BlinksFoodAPI.dto.CozinhaDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value ="/cozinhas")
public class CozinhaController {
    @Autowired
    private CadastroCozinhaService cadastroCozinhaService;
    @Autowired
    private CozinhaRepository cozinhaRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CozinhaDTO adicionar( @RequestBody CozinhaDTO cozinhaDTO){
        BeanUtils.copyProperties(cozinhaDTO, "id");
        return cadastroCozinhaService.adicionar(cozinhaDTO);

    }
    @GetMapping
    public List <CozinhaDTO>listAll (){
        return cadastroCozinhaService.listAll();
    }
    @GetMapping("/por-nome")
    public List <Cozinha> findByNome(@RequestParam(("nome"))String nome,Long id){
        return cozinhaRepository.findByNomeContaining(nome);

    }
    @GetMapping("/unique-char-name")
    public Optional<Cozinha> findByUniqueChar(@RequestParam("nome")String nome){
        return cozinhaRepository.findCharByNome(nome);
    }
    @GetMapping(value = "/{cozinhasId}")
    public ResponseEntity<Cozinha> findByid(@PathVariable ("cozinhasId") Long id) {
       return cadastroCozinhaService.findById(id);

    }
    @PutMapping("/{cozinhasId}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable ("cozinhasId")Long id, @RequestBody Cozinha cozinha){
     return cadastroCozinhaService.updateCozinhaById(cozinha,id);
    }
    @DeleteMapping("/{cozinhasId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deletar(@PathVariable ("cozinhasId") Long id){
        return cadastroCozinhaService.deleteById(id);

    }
}
