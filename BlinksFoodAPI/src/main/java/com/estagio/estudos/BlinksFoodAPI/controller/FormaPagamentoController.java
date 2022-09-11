package com.estagio.estudos.BlinksFoodAPI.controller;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.FormaPagamento;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.service.CadastroFormaPagamentoService;
import com.estagio.estudos.BlinksFoodAPI.dto.FormaPagamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/formasdepagamentos")
public class FormaPagamentoController {
    @Autowired
    private CadastroFormaPagamentoService cadastroFormaPagamentoService;
    @GetMapping
    public List<FormaPagamentoDTO> todos() {
        return cadastroFormaPagamentoService.listAllFormasPamentos();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FormaPagamentoDTO adicionar(@RequestBody FormaPagamentoDTO formaPagamentoDTO) {
        return cadastroFormaPagamentoService.addFormaspagamentos(formaPagamentoDTO);
    }
    @GetMapping(value = "/{formasdepagamentosid}")
    public FormaPagamentoDTO getById(@PathVariable("formasdepagamentosid") Long id) {
        return cadastroFormaPagamentoService.findFormasPagamentosbyId(id);
    }
    @DeleteMapping(value = "/{formasdepagamentosid}")
    public FormaPagamentoDTO deletar(@PathVariable("formasdepagamentosid") Long id, @RequestBody FormaPagamentoDTO formaPagamentoDTO) {
       return cadastroFormaPagamentoService.deleteFormaPagamentoByid(id,formaPagamentoDTO);
    }
    @PutMapping(value = "/{formasdepagamentosid}")
    public FormaPagamentoDTO atualizar(@RequestBody FormaPagamentoDTO formaPagamentoDTO, @PathVariable(value = "formasdepagamentosid") Long id) {
        return cadastroFormaPagamentoService.updateFormasPagamentosbyId(id,formaPagamentoDTO);
    }
}