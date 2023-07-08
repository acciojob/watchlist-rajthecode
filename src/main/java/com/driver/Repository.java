package com.driver;

import java.util.*;
import java.util.List;
@org.springframework.stereotype.Repository
public class Repository {

    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMoviePairMap;

    public Repository() {
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.directorMoviePairMap = new HashMap<String, List<String>>();
    }

    public void addMovie(Movie movie) {

        movieMap.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {

        directorMap.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movie, String director) {

        if (movieMap.containsKey(movie) && directorMap.containsKey(director)) {
            List<String> stud = new ArrayList<String>();

            if (directorMoviePairMap.containsKey(director)) {
                stud = directorMoviePairMap.get(director);
            }
            stud.add(movie);
            directorMoviePairMap.put(director, stud);
        }
    }

    public Movie getMovieByName(String movie) {

        return movieMap.get(movie);
    }

    public Director getDirectorByName(String director) {

        return directorMap.get(director);
    }

    public List<String> getMoviesByDirectorName(String director) {

        List<String> contain = new ArrayList<String>();
        if (directorMoviePairMap.containsKey(director)) {
            contain = directorMoviePairMap.get(director);
        }
        return contain;
    }

    public List<String> findAllMovies() {

        List<String> movies = new ArrayList<>(movieMap.keySet());
        return movies;
    }

    public void deleteDirectorByName(String director) {

        List<String> con = new ArrayList<>();
        if (directorMoviePairMap.containsKey(director)) {

            con = directorMoviePairMap.get(director);

            for (String movie : con) {
                if (movieMap.containsKey(movie)) {
                    movieMap.remove(movie);
                }
            }
            if (directorMap.containsKey(director)) {
                directorMap.remove(director);
            }

            if (directorMoviePairMap.containsKey(director)) {
                directorMoviePairMap.remove(director);
            }
        }
    }

    public void deleteAllDirectors() {
        HashSet<String> movies = new HashSet<String>();

        for (String director : directorMoviePairMap.keySet()) {
            for (String movie : directorMoviePairMap.get(director)) {
                movies.add(movie);
            }
                if (directorMap.containsKey(director)) {
                    directorMap.remove(director);
                }
                directorMoviePairMap.remove(director);

                for(String movie : movies){
                   if(movieMap.containsKey(movie)){
                       movieMap.remove(movie);
                }
            }
        }
    }
}
