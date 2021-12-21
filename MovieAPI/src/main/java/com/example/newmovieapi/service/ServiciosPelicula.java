package com.example.newmovieapi.service;
import com.example.newmovieapi.model.Pelicula;
import com.example.newmovieapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosPelicula {

	// private List<Pelicula> movies;
	private final MovieRepository movieRepository;

	@Autowired
	public ServiciosPelicula(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public String saludo() {
		return "<h1>Bienvenido a mi API de Peliculas<h1>" + "<br>" + "<h2> Para obtener peliculas <h2>"
				+ "<h4>Metodo GET  url: http://localhost:8080/desafio4/APImovies/pelis<h4>"
				+ "<h2> Para Agregar peliculas <h2>"
				+ "<h4>Metodo POST  url: http://localhost:8080/desafio4/APImovies/addpelicula<h4>"
				+ "<h2> Para Borrar peliculas <h2>"
				+ "<h4>Metodo DELETE  url: http://localhost:8080/desafio4/APImovies/deletepelicula/{id}<h4>"
				+ "<h2> Para Actualizar peliculas<h2>"
				+ "<h4>Metodo PUT url: http://localhost:8080/desafio4/APImovies/updatepelicula/{id}<h4>";
	}

	public List<Pelicula> getMovies() {
		return movieRepository.findAll();
	}

	public Pelicula createMovie(Pelicula movie) {
		return movieRepository.save(movie);

	}

	public void deleteMovie(Integer id) {
		movieRepository.deleteById(id);
	}

	public Pelicula updateMovie(Pelicula peli, Integer id) throws Exception {
		try {
			Optional<Pelicula> peliUptade = movieRepository.findById(id);
			if (!peliUptade.isEmpty()){;
				return movieRepository.save(peli);
			}
		} catch (Exception e) {
			 throw new Exception(e.getMessage());
		}
		
		return null;
	}

	public List<Pelicula> findByTitle(String title) {
		 return movieRepository.findByTitle(title);
	}

	public Optional<Pelicula> findId(Integer id) {
		return movieRepository.findById(id);
		
	}

	public List<Pelicula> filterPopular() {
		return movieRepository.filterPopular(PageRequest.of(0,3));
	}

	public List<Pelicula> filterClassified(String classified) {
		return movieRepository.filterClassified(classified);
	}
}



