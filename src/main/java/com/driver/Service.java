package com.driver;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service

public class Service {
    @Autowired
    Repository repository;
    public void addMovie(Movie movie) {

        repository.addMovie(movie);
    }

    public void addDirector(Director director) {

        repository.addDirector(director);
    }

    public void addMovieDirectorPair(String movie, String director) {

        repository.addMovieDirectorPair(movie,director);
    }

    public Movie getMovieByName(String movie) {
        return repository.getMovieByName(movie);
    }

    public Director getDirectorByName(String director) {
        return repository.getDirectorByName(director);
    }

    public List<String> getMoviesByDirectorName(String director) {
        return repository.getMoviesByDirectorName(director);
    }

    public List<String> findAllMovies() {

        return repository.findAllMovies();
    }

    public void deleteDirectorByName(String name) {
         repository.deleteDirectorByName(name);
    }

    public void deleteAllDirectors() {
        repository.deleteAllDirectors();
    }
}
