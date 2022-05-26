package presentationLayer;

import businessLayer.DeliveryService;
import businessLayer.Order;

import java.time.format.DateTimeFormatter;

public class EmployeeController implements Observer{
    EmployeeView employeeView;
    DeliveryService deliveryService;

    public EmployeeController(EmployeeView employeeView, DeliveryService deliveryService) {
        this.employeeView = employeeView;
        this.deliveryService = deliveryService;
        this.deliveryService.addObserver(this);
    }

    public EmployeeController() {
    }

    @Override
    public void update(Order order) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String s = "";

        for(Order o : deliveryService.getMap().keySet()){
            s = "Order id :   " + o.getOrderId() + "Client id :   " + o.getClientId() + "Order date :   " + dtf.format(order.getOrderDate());
        }
        employeeView.setTextArea(s);

    }
}
