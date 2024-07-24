package DesignBookMyShow;

public class Movie {
    int movieId;
    String title;
    int movieDuration;

    public Movie(int movieId, String title, int movieDuration) {
        this.movieId = movieId;
        this.title = title;
        this.movieDuration = movieDuration;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }
}
