package com.estagio.estudos.BlinksFoodAPI.domain.entity.repository;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutosRepository extends JpaRepository <Produtos,Long> {
    @Query(nativeQuery = true,value = "SELECT id, " +
            "ativo_produto, " +
            "descricao_produto, " +
            "nome_produto, preco_produto " +
            "FROM tbl_produtos " +
            "WHERE ativo_produto = true")
    List<Produtos> findByAtivoContaining(Boolean ativo);
    @Query(nativeQuery = true,value = "SELECT id, " +
            "ativo_produto, " +
            "descricao_produto," +
            " nome_produto, " +
            "preco_produto" +
            " FROM tbl_produtos " +
            "WHERE ativo_produto = false")
    List <Produtos>findByDesativadoContaining(Boolean ativo);
}
