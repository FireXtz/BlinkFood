package com.estagio.estudos.BlinksFoodAPI.domain.entity.repository;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.Cozinha;
import com.estagio.estudos.BlinksFoodAPI.dto.CozinhaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha,Long>  {
    List <Cozinha> findByNomeContaining(String nome);
    Optional<Cozinha> findCharByNome (String nome);

}
