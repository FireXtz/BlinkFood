package com.estagio.estudos.BlinksFoodAPI.domain.entity.repository;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository <Produtos,Long> {
}
