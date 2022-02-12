/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.id.ProjetoDAC_Api.repository;

import br.uff.id.ProjetoDAC_Api.model.Recurso;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author Luiz Alberto Junior
 */
@RepositoryRestResource(collectionResourceRel = "recurso", path = "recursos")
public interface RecursoRepository extends CrudRepository<Recurso, Long>{  
    
//    @Query("SELECT rec FROM Recurso rec LEFT JOIN Colecao col on rec.colecao = col WHERE rec.colecao IS NULL")
//    List<Recurso> findRecursosSemColecao();
    
      //select e from Employee e where not exists (select 1 from User u where u.employee = e)
    @Query("SELECT rec FROM Recurso rec WHERE NOT EXISTS (SELECT 1 FROM Colecao col WHERE col.recursos = rec)")
    List<Recurso> findRecursosSemColecao();
}
