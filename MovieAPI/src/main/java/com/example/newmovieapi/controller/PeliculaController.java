package com.example.newmovieapi.controller;
import com.example.newmovieapi.model.Pelicula;
import com.example.newmovieapi.service.ServiciosPelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("desafio4/APImovies")
@RestController

public class PeliculaController {

    private final ServiciosPelicula movieService;

    @Autowired
    public PeliculaController(ServiciosPelicula servicioPelicula) {
        this.movieService = servicioPelicula;
    }
    
    
    @GetMapping("/")
    public String hello() {
    	return movieService.saludo();
    }
   
    @GetMapping("/peliculas")
    public List<Pelicula> getMovies(){
        return movieService.getMovies();
    }

    @PostMapping("/addpelicula")
    public Pelicula createMovie(@RequestBody Pelicula movie){
        return movieService.createMovie(movie);
    }

    @DeleteMapping("/deletepelicula/{id}")
    public void deleteMovie(@PathVariable Integer id){
         movieService.deleteMovie(id);
    }
    
    @PutMapping("/updatepelicula/{id}")
    public Pelicula updateMovie (@RequestBody Pelicula movie, @PathVariable Integer id) throws Exception{
        	  return movieService.updateMovie(movie, id);        
    }

    @GetMapping ("/findByTitle/{title}") 
    public List<Pelicula> findByTitle(@PathVariable String title) {
    	return movieService.findByTitle(title);
    }
    
    @GetMapping("/findById/{id}")
    public Optional<Pelicula> findId(@PathVariable Integer id) {
    return movieService.findId(id);
    }
    
    @GetMapping ("/filter/popular") 
	public List<Pelicula> filterPopular() {
	return movieService.filterPopular();
	}
    
    @GetMapping ("/listadoPorClasificacion/{classified}") 
   	public List<Pelicula> filterClassified(@PathVariable String classified) {
   	return movieService.filterClassified(classified);
   	}
	   
}
