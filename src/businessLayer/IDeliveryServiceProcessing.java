package businessLayer;

import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface IDeliveryServiceProcessing {
     void addProduct(MenuItem product);

     void deleteProduct(String name);

     void editItemFromMenu(String name,double rating,int calories,int protein,int fat,int sodium,int price);

     List<MenuItem> readProductsFromCSV(String fileName);

     void placeOrder(Order order, List<MenuItem> menuItemList) throws IOException;

     void generateBill(Order order, List<MenuItem> menuItemList) throws IOException;


     void generateOrdersInIntervalReport(Time startTime, Time endTime, String fileName) throws IOException;

     void generatePopularProductsReport(int numberOfTimes, String fileName) throws IOException;

     void generateRegularClientsReport(int numberOfTimes, double minValue, String fileName);

     void generateProductsOfDayReport(Date orderDate, String fileName) throws IOException;


}
