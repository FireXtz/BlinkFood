package com.estagio.estudos.BlinksFoodAPI.controller;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.Cidade;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.service.CadastroCidadeService;
import com.estagio.estudos.BlinksFoodAPI.dto.CidadeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/cidades")
@CrossOrigin("http://localhost:4200")
public class CidadeController {
    @Autowired
    private CadastroCidadeService cadastroCidadeService;

    @GetMapping
    public List <CidadeDTO> listAll(){
        return cadastroCidadeService.listAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CidadeDTO adicionar(@RequestBody CidadeDTO cidadeDTO){
        return  cadastroCidadeService.addCidade(cidadeDTO);
    }
    @GetMapping(value = "/{cidadesId}")
    public CidadeDTO findById(@PathVariable("cidadesId") Long id){
        return cadastroCidadeService.findByid(id);
    }
    @PutMapping("/{cidadesId}")
    public CidadeDTO atualizar(@RequestBody CidadeDTO cidadeDTO,@PathVariable("cidadesId") Long id){
        return cadastroCidadeService.updateById(id,cidadeDTO);
    }
    @DeleteMapping("/{cidadesId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deletar(@PathVariable("cidadesId")Long id){
       return cadastroCidadeService.deleteById(id);
    }
}


