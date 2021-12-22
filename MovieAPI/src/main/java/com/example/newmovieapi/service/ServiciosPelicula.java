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
		return 	 "<h1>Bienvenido a mi API de Peliculas<h1>" 
				+ "<br>"
				+ "<hr>"
				+"<h2>Obtener Listado de Peliculas<h2>"
				+ "<h4>Metodo GET  url: http://localhost:8080/ProyectoFinal/APImovies/peliculas<h4>"
				+ "<hr>"
				+ "<h2>Agregar una Pelicula<h2>"
				+ "<h4>Metodo POST  url: http://localhost:8080/ProyectoFinal/APImovies/addPelicula<h4>"
				+ "<hr>"
				+ "<h2>Borrar una Pelicula<h2>"
				+ "<h4>Metodo DELETE  url: http://localhost:8080/ProyectoFinal/APImovies/deletePelicula/{id}<h4>"
				+ "<p>{id} = es el identificador de la pelicula que se quiere borrar</p>"
				+ "<hr>"
				+ "<h2>Actualizar Peliculas<h2>"
				+ "<h4>Metodo PUT url: http://localhost:8080/ProyectoFinal/APImovies/updatePelicula/{id}<h4>"
				+ "<p>{id} = es el identificador de la pelicula que se quiere actulizar</p>"
				+ "<hr>"
				+ "<h2>Buscar Pelicula por Titulo<h2>"
				+ "<h4>Metodo PUT url: http://localhost:8080/ProyectoFinal/APImovies/findByTitle/{title}<h4>"
				+ "<p>{title} = es el nombre del titulo a buscar</p>"
				+ "<hr>"
				+ "<h2>Buscar Pelicula por Id<h2>"
				+ "<h4>Metodo GET url: http://localhost:8080/ProyectoFinal/APImovies/findById/{id}<h4>"
				+ "<p>{id} = es el identificador de la pelicula que a buscar</p>"
				+ "<hr>"
				+ "<h2>Top 3 - Peliculas Populares<h2>"
				+ "<h4>Metodo GET url: http://localhost:8080/ProyectoFinal/APImovies/filter/popular<h4>"
				+ "<hr>"
				+ "<h2>Filtrado de Peliculas por Clasificacion<h2>"
				+ "<h4>Metodo GET url: http://localhost:8080/ProyectoFinal/APImovies/listadoPorClasificacion/{classified}<h4>"
				+ "<p>{classified} =  clasificacion a buscar</p>"
				
	
	;
	}

	public List<Pelicula> getMovies() {
		return movieRepository.findAll();
	}

	public Pelicula createMovie(Pelicula pelicula) {
		return movieRepository.save(pelicula);

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



