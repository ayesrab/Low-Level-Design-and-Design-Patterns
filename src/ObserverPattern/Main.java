package ObserverPattern;

public class Main {
    public static void main(String[] args) {
        StocksObservable iPhone = new IphoneObservable();

        NotificationAlertObserver observer1 = new EmailALertObserver("a@gmail.com",iPhone);
        NotificationAlertObserver observer2 = new EmailALertObserver("b@gmail.com",iPhone);
        NotificationAlertObserver observer3 = new MobileAlertOberver("12457",iPhone);

        iPhone.addObserver(observer1);
        iPhone.addObserver(observer2);
        iPhone.addObserver(observer3);

        iPhone.setStock(10);
        iPhone.setStock(0);
        iPhone.setStock(100);
    }
}
