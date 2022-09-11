package com.estagio.estudos.BlinksFoodAPI.controller;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.Pedido;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    PedidoService pedidoService;
    @GetMapping
    public List <Pedido> listAll(){
        return pedidoService.listPedidos();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido save(@RequestBody Pedido pedido){
        return pedidoService.savePedidos(pedido);
    }
    @PutMapping(value = "/{pedidosid}")
    public ResponseEntity <Pedido> updatePedidos(@PathVariable (value = "pedidosid")  Long id ,@RequestBody Pedido pedido){
        return pedidoService.updateByid(id, pedido);
    }
    @GetMapping(value = "/{pedidosid}")
    public Pedido findPedidobyId(@PathVariable (value = "pedidosid") Long id){
        return  pedidoService.findByid(id);
    }

    @DeleteMapping(value = "/{pedidosid}")
    public void  deletePedidos(@PathVariable (value = "pedidosid") Long id){
        pedidoService.deleteByid(id);
    }



}
