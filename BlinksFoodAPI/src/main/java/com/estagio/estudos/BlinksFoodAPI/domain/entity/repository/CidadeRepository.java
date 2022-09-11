package com.estagio.estudos.BlinksFoodAPI.domain.entity.repository;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("http://localhost:4200")
public interface CidadeRepository extends JpaRepository<Cidade,Long> {
}
