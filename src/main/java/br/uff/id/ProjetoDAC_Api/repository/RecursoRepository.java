/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.id.ProjetoDAC_Api.repository;

import br.uff.id.ProjetoDAC_Api.model.Recurso;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author Luiz Alberto Junior
 */
@RepositoryRestResource(collectionResourceRel = "recurso", path = "recursos")
@Transactional
public interface RecursoRepository extends CrudRepository<Recurso, Long>{  
    
    @Query("SELECT rec FROM Recurso rec LEFT JOIN rec.colecao col WHERE col IS NULL OR col.id = :id ")
    List<Recurso> findRecursosSemColecao(@Param("id") Long id);
}
