/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.id.ProjetoDAC_Api.repository;

import br.uff.id.ProjetoDAC_Api.model.Curso;
import java.util.Calendar;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Luiz Alberto Junior
 */
@RepositoryRestResource(collectionResourceRel = "curso", path = "cursos")
public interface CursoRepository extends CrudRepository<Curso, Long>{
    
    @Query("SELECT c FROM Curso c WHERE c.inicio >= :inicio AND c.fim <= :fim")
    List<Curso> findByEventosEntreDatas(@Param("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Calendar inicio,@Param("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Calendar fim);

}
