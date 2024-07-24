package DesignBookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City,List<Movie>> moviesInCity;
    List<Movie> allMovies;

    public MovieController() {
        moviesInCity = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    //ADD movie to a particular city, make use of cityVsMovies map
    void addMovie(City city,Movie movie) {
        List<Movie> movies = moviesInCity.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        moviesInCity.put(city, movies);
    }
    Movie getMovieByName(String title) {
        for (Movie movie : allMovies) {
            if (movie.getTitle().equals(title)) {
                return movie;
            }
        }
        return null;
    }
    List<Movie> getMoviesByCity(City city) {
        return moviesInCity.getOrDefault(city, new ArrayList<>());
    }
    //REMOVE movie from a particular city, make use of cityVsMovies map

    //UPDATE movie of a particular city, make use of cityVsMovies map

    //CRUD operation based on Movie ID, make use of allMovies list

}
