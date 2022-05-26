package presentationLayer;
import businessLayer.Order;

public interface Observer {
    void update(Order order);
}
