package ObserverPattern;

public class EmailALertObserver implements NotificationAlertObserver{
    String email;
    StocksObservable observable;

    EmailALertObserver(String email,StocksObservable observable){
        this.email = email;
        this.observable = observable;
    }
    @Override
    public void update() {
        System.out.println("Email ALert Notification for " + this.email);
    }
}
