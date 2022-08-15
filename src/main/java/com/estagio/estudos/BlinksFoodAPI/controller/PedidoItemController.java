package com.estagio.estudos.BlinksFoodAPI.controller;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.ItemPedido;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/Items")
public class PedidoItemController {
    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public List <ItemPedido> listAll (){
        return itemPedidoService.listAll();
    }
    @GetMapping("/{Itemsid}")
    public ResponseEntity <ItemPedido> findByid(@PathVariable ("Itemsid") Long id){
        return itemPedidoService.find_Items_by_id(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemPedido savePedidos(@RequestBody ItemPedido itemPedido){
        return itemPedidoService.add_Items_Pedidos(itemPedido);
    }
    @PutMapping("{Itemsid}")
    public ResponseEntity <ItemPedido> updated(@PathVariable ("Itemsid")Long id,@RequestBody ItemPedido itemPedido){
        return itemPedidoService.updateItemsPedido(itemPedido,id);
    }
    @DeleteMapping("{Itemsid}")
    public ResponseEntity <Object>deleteById(@PathVariable ("Itemsid")Long id){
        return itemPedidoService.deleteByid(id);
    }

}
