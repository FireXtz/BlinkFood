package com.estagio.estudos.BlinksFoodAPI.domain.entity.repository;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepository  extends JpaRepository <FormaPagamento, Long> {
}
