package com.estagio.estudos.BlinksFoodAPI.domain.entity.repository;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository <Estado,Long> {
}
