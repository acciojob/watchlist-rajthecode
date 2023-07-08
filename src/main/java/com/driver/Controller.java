package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping("movies")
@RestController
public class Controller {

    @Autowired
    Service service;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){

        service.addMovie(movie);

        return new ResponseEntity<>("New Movie Added Successfully", HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {

        service.addDirector(director);

        return new ResponseEntity<>("New Director Added Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie,@RequestParam String director){
        service.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("Movie Director Added Successfully",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
        public ResponseEntity<Movie> getMovieByName(@PathVariable String movie){

        Movie name = service.getMovieByName(movie);

        return new ResponseEntity<>(name,HttpStatus.CREATED);
        }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String director){

        Director directors = service.getDirectorByName(director);

        return new ResponseEntity<>(directors,HttpStatus.CREATED);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){

        List<String> names = service.getMoviesByDirectorName(director);

        return new ResponseEntity<>(names,HttpStatus.CREATED);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> names = service.findAllMovies();
        return new ResponseEntity<>(names,HttpStatus.CREATED);
    }
     @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String name){

        service.deleteDirectorByName(name);
        return new ResponseEntity<>(name+"Successfully Deleted",HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        service.deleteAllDirectors();
        return new ResponseEntity<>("Deleted",HttpStatus.CREATED);
    }
}
