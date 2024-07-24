package DesignBookMyShow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    TheatreController theatreController;
    MovieController movieController;

    public BookMyShow() {
        this.theatreController = new TheatreController();
        this.movieController = new MovieController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();
        bookMyShow.createBooking(City.Kolkata,"Dune2");
        bookMyShow.createBooking(City.Kolkata,"Avengers");
    }
    public void initialize(){
        creatMovies();
        createTheatres();
    }

    public void createBooking(City userCity, String movieName){
        //1. search movie by my location
        List<Movie> movies = movieController.getMoviesByCity(userCity);
        Movie preferredMovie = null;
        //2. select the movie which you want to see. i want to see Dune2
        for(Movie movie : movies){
            if(movie.getTitle().equalsIgnoreCase(movieName))
                preferredMovie = movie;
        }
        //3. get all show of this movie in Kolkata location
        Map<Theatre,List<Show>> showWiseTheatres= theatreController.getTheatreShow(userCity,preferredMovie);
        //4. select the particular show user is interested in
        Map.Entry<Theatre,List<Show>> theatreShow = showWiseTheatres.entrySet().iterator().next();
        List<Show> shows = theatreShow.getValue();
        Show preferredShow = shows.getFirst();
        //5. select the seat
        int seatNumber = 30;
        List<Integer> bookedSeats = preferredShow.getBookedSeatIds();
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat seat : preferredShow.getScreen().getSeats()){
                if(seat.getSeatId() == seatNumber){
                    myBookedSeats.add(seat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(preferredShow);
        }
        else{
            System.out.println("This seat is already booked Try different Seats");
            return;
        }
        System.out.println("BOOKING SUCCESSFULL");

    }
    public void creatMovies(){
        Movie movie1 = new Movie(1,"Dune2",240);
        Movie movie2 = new Movie(2,"Avengers",240);
        movieController.addMovie(City.Kolkata,movie1);
        movieController.addMovie(City.Kolkata,movie2);
        movieController.addMovie(City.Bengalore,movie1);
        movieController.addMovie(City.Bengalore,movie2);
        movieController.allMovies.add(movie1);
        movieController.allMovies.add(movie2);
    }
    public void createTheatres(){
        Movie Dune2 = movieController.getMovieByName("Dune2");
        Movie Avengers = movieController.getMovieByName("Avengers");
        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheatreId(1);
        inoxTheatre.setScreens(createScreens());
        inoxTheatre.setCity(City.Kolkata);
        List<Show> inoxShowList = new ArrayList<>();
        Show inoxMorningShow = createShows(1, Dune2, inoxTheatre.getScreens().getFirst(),10);
        Show inoxNightShow = createShows(2,Avengers, inoxTheatre.getScreens().getFirst(),20);
        inoxShowList.add(inoxMorningShow);
        inoxShowList.add(inoxNightShow);
        inoxTheatre.setShows(inoxShowList);

        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheatreId(2);
        pvrTheatre.setScreens(createScreens());
        pvrTheatre.setCity(City.Bengalore);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3,Dune2, pvrTheatre.getScreens().get(0), 13);
        Show pvrEveningShow = createShows(4,Avengers, pvrTheatre.getScreens().get(0), 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShows(pvrShows);

        theatreController.addTheatre(inoxTheatre, City.Kolkata);
        theatreController.addTheatre(pvrTheatre, City.Bengalore);

    }
    public Show createShows(int showId, Movie movie, Screen screen, int showStartTime){
        Show show = new Show();
        show.setShowId(showId);
        show.setMovie(movie);
        show.setScreen(screen);
        show.setShowStartTime(showStartTime);
        return show;
    }
    public List<Screen> createScreens(){
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);
        return screens;
    }
    public List<Seat> createSeats(){
        //creating 100 seats for testing purpose, this can be generalised
        List<Seat> seats = new ArrayList<>();
        for(int i = 0 ; i < 40 ; i++){
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatType(SeatType.SILVER);
            seat.setPrice(100);
            seats.add(seat);
        }
        for(int i = 40; i < 80 ; i++){
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatType(SeatType.GOLD);
            seat.setPrice(200);
            seats.add(seat);
        }
        for(int i = 80; i < 100 ; i++){
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatType(SeatType.PLATINUM);
            seat.setPrice(400);
            seats.add(seat);
        }
        return seats;
    }
}
