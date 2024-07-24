package DesignBookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> theatreMap;
    List<Theatre> theatreList;

    public TheatreController() {
        theatreMap = new HashMap<>();
        theatreList = new ArrayList<>();
    }

    void addTheatre(Theatre theatre, City city) {
        List<Theatre> theatreList = theatreMap.getOrDefault(city, new ArrayList<>());
        theatreList.add(theatre);
        theatreMap.put(city, theatreList);
    }

    Map<Theatre,List<Show>> getTheatreShow(City city, Movie movie) {
        //get all the theater of this city
        Map<Theatre,List<Show>> theatreShow = new HashMap<>();
        List<Theatre> theatreList = theatreMap.getOrDefault(city, new ArrayList<>());
        //filter the theatres which run this movie
        for(Theatre theatre : theatreList) {
            List<Show> movieShows = new ArrayList<>();
            List<Show> showList = theatre.getShows();
            for(Show show : showList) {
                if(show.movie.getMovieId() == movie.getMovieId()) {
                    movieShows.add(show);
                }
            }
            if(!movieShows.isEmpty())
                theatreShow.put(theatre, movieShows);
        }
        return theatreShow;
    }
}
