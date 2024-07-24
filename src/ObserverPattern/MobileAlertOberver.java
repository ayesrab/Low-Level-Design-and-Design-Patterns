package ObserverPattern;

public class MobileAlertOberver implements NotificationAlertObserver{
    String number;
    StocksObservable observable;

    MobileAlertOberver(String number, StocksObservable observable){
        this.number = number;
        this.observable = observable;
    }
    @Override
    public void update() {
        System.out.println("MobileAlertOberver for " + this.number);
    }
}
