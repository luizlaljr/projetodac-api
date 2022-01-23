/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.id.ProjetoDAC_Api.repository;

import br.uff.id.ProjetoDAC_Api.model.Autor;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author Luiz Alberto Junior
 */
@RepositoryRestResource(collectionResourceRel = "autor", path = "autores")
public interface AutorRepository extends CrudRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE a.sobrenome LIKE CONCAT('%',:sobrenome,'%')")
    List<Autor> findBySobrenome(@Param("sobrenome") String sobrenome);

}
