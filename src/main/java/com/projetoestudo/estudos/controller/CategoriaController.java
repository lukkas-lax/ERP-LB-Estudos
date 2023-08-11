package com.projetoestudo.estudos.controller;

import com.projetoestudo.estudos.model.Categoria;
import com.projetoestudo.estudos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> getAllCategorias(@RequestParam(required = false) String nome) {
        try{
            List<Categoria> categorias = new ArrayList<Categoria>();
            if (nome == null)
                categoriaRepository.findAll().forEach(categorias::add);
            else
                categoriaRepository.findByNomeContaining(nome).forEach(categorias::add);

            if(categorias.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(categorias, HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/categorias")
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        try {
            Categoria _categoria= categoriaRepository.save(new Categoria(categoria.getNome(), categoria.getDescricao()));
            return new ResponseEntity<>(_categoria, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
