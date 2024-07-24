package ObserverPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class IphoneObservable implements StocksObservable{
    List<NotificationAlertObserver> observerList = new ArrayList<>();
    int stockCount;
    @Override
    public void addObserver(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(NotificationAlertObserver observer : observerList){
            observer.update();
        }
    }

    @Override
    public void setStock(int newstock) {
        if(stockCount == 0){
            notifyObservers();
        }
        stockCount += newstock;
    }

    @Override
    public int getStock() {
        return stockCount;
    }
}
