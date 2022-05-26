package businessLayer;

import presentationLayer.Observer;

public interface Observable {
    void notifyObservers(Order order);
    void addObserver(Observer o);
}
