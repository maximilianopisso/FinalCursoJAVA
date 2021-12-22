package com.example.newmovieapi.repository;

import java.util.List;



import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.newmovieapi.model.Pelicula;

public interface MovieRepository extends JpaRepository<Pelicula, Integer>{

	@Query ("SELECT p FROM Pelicula p WHERE p.title LIKE %:title%")
	List<Pelicula> findByTitle(@Param("title") String title);

	
	@Query ("SELECT p FROM Pelicula p ORDER BY p.rate DESC")
	List<Pelicula> filterPopular(PageRequest pageRequest);

	@Query ("SELECT p FROM Pelicula p WHERE p.classified LIKE %:classified%")
	List<Pelicula> filterClassified(@Param("classified") String classified);


}
