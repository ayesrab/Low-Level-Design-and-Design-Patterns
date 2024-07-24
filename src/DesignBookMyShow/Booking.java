package DesignBookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    Show show;
    int bookingId;
    List<Seat> bookedSeats = new ArrayList<>();

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
}
