package businessLayer;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order{
    private int idOrder;
    private int clientId;
    private LocalDateTime orderDate;
   // private int table;

    public Order(int orderID, int clientID) {
        this.idOrder = orderID;
        this.clientId = clientID;
        this.orderDate = LocalDateTime.now();
    }

    public int hashCode() {
        return Objects.hash(idOrder);
    }


    public int getOrderId() {
        return idOrder;
    }

    public void setId(int id) {
        this.idOrder = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
