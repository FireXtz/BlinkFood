package com.estagio.estudos.BlinksFoodAPI.domain.entity.service;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.Pedido;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.exceptions.PedidosException;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;
    public List <Pedido> listPedidos(){
        return  pedidoRepository.findAll();
    }
    public Pedido savePedidos(@RequestBody Pedido pedido){
        return pedidoRepository.save(pedido);
    }
    public Pedido findByid(Long id){
        return pedidoRepository.findById(id)
                .orElseThrow(()-> new PedidosException(id));
    }
    public ResponseEntity <Pedido> updateByid(Long id, Pedido pedido){
        return pedidoRepository.findById(id)
                .map(updatePedido -> {
                    updatePedido.setCodigo(updatePedido.getCodigo());
                    updatePedido.setDataConfirmacao(updatePedido.getDataConfirmacao());
                    updatePedido.setDataEntrega(updatePedido.getDataEntrega());
                    updatePedido.setSub_total(updatePedido.getSub_total());
                    updatePedido.setTaxaFrete(updatePedido.getTaxaFrete());
                    Pedido updated = pedidoRepository.save(pedido);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
    public void deleteByid(Long id){
         pedidoRepository.deleteById(id);
    }
}
