package CarRentalSystem;

public class Bill {
    Reservation reservation;
    double totalBillAmount;
    boolean isBillPaid;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.totalBillAmount = getTotalBillAmount();
        this.isBillPaid = false;
    }

    public double getTotalBillAmount() {
        // compute the bill accordingly
        return 100.0;
    }
}
