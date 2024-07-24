package ObserverPattern;

import java.util.Observer;

public interface StocksObservable {
    public void addObserver(NotificationAlertObserver observer);
    public void removeObserver(NotificationAlertObserver observer);
    public void notifyObservers();
    public void setStock(int stock);
    public int getStock();
}
