package com.estagio.estudos.BlinksFoodAPI.domain.entity.service;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.ItemPedido;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {
    @Autowired
    private ItemPedidoRepository pedidoRepository;

    public List <ItemPedido> listAll(){
        return pedidoRepository.findAll();
    }
    public ItemPedido add_Items_Pedidos(ItemPedido itemPedido){
        return pedidoRepository.save(itemPedido);
    }
    public ResponseEntity <ItemPedido> find_Items_by_id(Long id){
        return pedidoRepository.findById(id)
                .map(itemPedido -> ResponseEntity.ok().body(itemPedido))
                .orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity <ItemPedido> updateItemsPedido(ItemPedido itemPedido, Long id){
        return  pedidoRepository.findById(id)
                .map(updatePedidos ->{
                    updatePedidos.setObservacao(itemPedido.getObservacao());
                    updatePedidos.setQuantidade(itemPedido.getQuantidade());
                    updatePedidos.setPrecoTotal(itemPedido.getPrecoTotal());
                    updatePedidos.setPrecoUnitario(itemPedido.getPrecoUnitario());
                    updatePedidos.setStatusPedido(itemPedido.getStatusPedido());
                    ItemPedido updated = pedidoRepository.save(updatePedidos);
                    return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity <Object> deleteByid(Long id){
        return pedidoRepository.findById(id)
                .map(deleItemPedido -> {
                    pedidoRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
