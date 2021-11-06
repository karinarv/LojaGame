package br.com.game.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.game.model.Categoria;

@Repository

//Comunica com o Spring 
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	public List<Categoria> findAllByGeneroContainingIgnoreCase (String genero);
}
