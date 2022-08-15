package com.estagio.estudos.BlinksFoodAPI.domain.entity.repository;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long> {
}
