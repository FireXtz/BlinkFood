package com.estagio.estudos.BlinksFoodAPI.domain.entity.repository;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Long> {
}
