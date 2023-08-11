package com.projetoestudo.estudos.repository;

import com.projetoestudo.estudos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByNomeContaining(String nome);

}
