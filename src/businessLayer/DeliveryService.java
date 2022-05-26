package businessLayer;

import presentationLayer.Observer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeliveryService implements IDeliveryServiceProcessing, Observable {

    private Map<Order, List<MenuItem>> hashMap;
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private List<User> users;
    private List<Observer> observers;

    public DeliveryService() {
        this.hashMap = new HashMap<>();
        users = readUsersFromCSV("src/clients.csv");
        observers = new ArrayList<Observer>();
    }

    public List<MenuItem> searchProductBy(String keyword, double minRating, double maxRating, int minPrice, int maxPrice, int minCalories, int maxCalories, int minProtein, int maxProtein, int minFat, int maxFat, int minSodium, int maxSodium) {

        List<MenuItem> items;
        items = menuItems.stream().filter(filter -> filter.getName().toLowerCase().contains(keyword)).collect(Collectors.toList());
        items.stream().filter(filter -> filter.getRating() >= minRating).collect(Collectors.toList());
        items.stream().filter(filter -> filter.getRating() <= maxRating).collect(Collectors.toList());
        items.stream().filter(filter -> filter.getPrice() <= maxPrice).collect(Collectors.toList());
        items.stream().filter(filter -> filter.getPrice() >= minPrice).collect(Collectors.toList());
        items.stream().filter(filter -> filter.getCalories() >= minCalories).collect(Collectors.toList());
        items.stream().filter(filter -> filter.getCalories() <= maxCalories).collect(Collectors.toList());
        items.stream().filter(filter -> filter.getProtein() >= minProtein).collect(Collectors.toList());
        items.stream().filter(filter -> filter.getProtein() <= maxProtein).collect(Collectors.toList());
        items.stream().filter(filter -> filter.getFat() >= minFat).collect(Collectors.toList());
        items.stream().filter(filter -> filter.getFat() <= maxFat).collect(Collectors.toList());
        items.stream().filter(filter -> filter.getSodium() >= minSodium).collect(Collectors.toList());
        items.stream().filter(filter -> filter.getSodium() <= maxSodium).collect(Collectors.toList());

        return items;

    }

    public List<User> getUsers() {
        return users;
    }


    public boolean validProduct(String name) {
        for (MenuItem item : menuItems) {
            if (name.equals(item.getName()))
                return true;
        }
        return false;
    }

    public MenuItem searchByName(String name) {
        for (MenuItem item : menuItems) {
            if (name.equals(item.getName()))
                return item;
        }
        return null;
    }

    @Override
    public void deleteProduct(String name) {
        menuItems.removeIf(item -> name.equals(item.getName()));
    }

    public void editItemFromMenu(String name, double rating, int calories, int protein, int fat, int sodium, int price) {
        MenuItem item = searchByName(name);
        item.setRating(rating);
        item.setCalories(calories);
        item.setProtein(protein);
        item.setFat(fat);
        item.setSodium(sodium);
        item.setPrice(price);
    }

    public void addCompositeProduct(List<MenuItem> itemList, String menuItemName) {
        MenuItem menuItem = new CompositeProduct(menuItemName);

        menuItem.setRating(menuItem.computeRating(itemList));
        menuItem.setCalories(menuItem.computeCalories(itemList));
        menuItem.setProtein(menuItem.computeProtein(itemList));
        menuItem.setFat(menuItem.computeFat(itemList));
        menuItem.setSodium(menuItem.computeSodium(itemList));
        menuItem.setPrice(menuItem.computePrice(itemList));

        menuItems.add(menuItem);

    }


    public List<MenuItem> readProductsFromCSV(String fileName) {
        String separator = ",";
        ArrayList<MenuItem> menuItems1 = new ArrayList<>();
        Stream<String> lines = null;
        try {
            lines = Files.lines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert lines != null;
        List<List<String>> items = lines.map(line -> Arrays.asList(line.split(separator))).collect(Collectors.toList());
        items.remove(0); //remove la numele coloanelor

        items.forEach(value -> {
            MenuItem item = new BaseProduct(value.get(0), (Double.parseDouble(value.get(1))), (Integer.parseInt(value.get(2))), (Integer.parseInt(value.get(3))), (Integer.parseInt(value.get(4))), (Integer.parseInt(value.get(5))), (Integer.parseInt(value.get(6))));
            try {
                menuItems1.add(item);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        menuItems = menuItems1;
        return menuItems1;
    }

    public List<User> readUsersFromCSV(String fileName) {
        String separator = ",";
        ArrayList<User> usersList = new ArrayList<>();
        Stream<String> lines = null;
        try {
            lines = Files.lines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert lines != null;
        List<List<String>> userss = lines.map(line -> Arrays.asList(line.split(separator))).collect(Collectors.toList());
        userss.remove(0); //remove la numele coloanelor

        userss.forEach(value -> {
            User user = new User(Integer.parseInt(value.get(0)), value.get(1), value.get(2), Integer.parseInt(value.get(3)));
            try {
                usersList.add(user);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        users = usersList;
        return usersList;
    }

    @Override
    public void placeOrder(Order order, List<MenuItem> menuItemList) throws IOException {
        generateBill(order, menuItemList);
        this.hashMap.put(order, menuItemList);
        //setChanged();
        notifyObservers(order);
        assert (new File("Order " + order.getOrderId() + ".txt").exists()) : true;

    }

    public Map<Order, List<MenuItem>> getMap() {
        return hashMap;
    }


    @Override
    public void generateBill(Order order, List<MenuItem> menuItemList) throws IOException {


    }


    @Override
    public void generateOrdersInIntervalReport(Time startTime, Time endTime, String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);

        List<Order> orderList = hashMap.keySet()
                .stream()
                .filter(x -> x.getOrderDate().getHour() > startTime.getHours() || x.getOrderDate().getHour() == startTime.getHours() && x.getOrderDate().getMinute() > startTime.getMinutes() || x.getOrderDate().getHour() == startTime.getHours() && x.getOrderDate().getMinute() == startTime.getMinutes() && x.getOrderDate().getSecond() >= startTime.getSeconds())
                .filter(x -> x.getOrderDate().getHour() < endTime.getHours() || x.getOrderDate().getHour() == endTime.getHours() && x.getOrderDate().getMinute() < endTime.getMinutes() || x.getOrderDate().getHour() == endTime.getHours() && x.getOrderDate().getMinute() == endTime.getMinutes() && x.getOrderDate().getSecond() <= endTime.getSeconds()).collect(Collectors.toList());

        for (Order order : orderList) {
            bw.write("Order id : " + order.getOrderId() + "Order date : " + order.getOrderDate().getDayOfMonth() + ":" + order.getOrderDate().getMonthValue() + ":" + order.getOrderDate().getYear() + "    Order time : " + order.getOrderDate().getHour() + "." + order.getOrderDate().getMinute() + "." + order.getOrderDate().getSecond() + "PRODUCTS: \n");
            List<MenuItem> menuItems = this.hashMap.get(order);
            int i = 1;
            double total = 0;
            for (MenuItem m : menuItems) {
                bw.write("             " + i + ") " + m.getName() + "   PRICE: " + m.getPrice() + "\n");
                total = total + m.getPrice();
                i++;
            }
            bw.write("\n" + "     TOTAL : " + total + "\n\n");
        }

        bw.close();
        fw.close();
        assert (new File(fileName).exists()) : true;
    }

    @Override
    public void generatePopularProductsReport(int numberOfTimes, String fileName) throws IOException {
        int i = 1;
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Products ordered more than " + numberOfTimes + " times:\n\n");

            Map<String, Integer> productFrequency = new HashMap<>();
            for(Order o : this.hashMap.keySet()){
                List<MenuItem> menuItems = this.hashMap.get(o);
                for(MenuItem m : menuItems){
                    productFrequency.computeIfPresent(m.getName(), (key, val) -> val + 1);
                    productFrequency.putIfAbsent(m.getName(), 1);
                }
            }

            for(String m : productFrequency.keySet()){
                if(productFrequency.get(m) > numberOfTimes){
                    bw.write(i + ") " + m + " x " + productFrequency.get(m) + "\n");
                    i++;
                }
            }

            bw.close();
            fw.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        assert (new File(fileName).exists()) : true;


    }

    @Override
    public void generateRegularClientsReport(int numberOfTimes, double minValue, String fileName) {
        int i = 1;
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("The clients that have ordered more than  " + numberOfTimes + " f times so far and the\n" +
                    "value of the order was higher than " + minValue + " RON:\n");

            Map<Integer, Integer> clientIdNumberOfOrders = new HashMap<>();
            for (Order o : this.hashMap.keySet()) {
                clientIdNumberOfOrders.computeIfPresent(o.getClientId(), (key, val) -> val + 1);
                clientIdNumberOfOrders.putIfAbsent(o.getClientId(), 1);
            }

            Set<Integer> clientPriceOfOrder = new HashSet<>();
            for (Order o : this.hashMap.keySet()) {
                List<MenuItem> menuItems = this.hashMap.get(o);
                double total = 0;
                for (MenuItem m : menuItems) {
                    total = total + m.getPrice();
                }
                if (total > minValue) {
                    clientPriceOfOrder.add(o.getClientId());
                } else {
                    clientPriceOfOrder.remove(o.getClientId());
                }
            }


            for (Integer id : clientIdNumberOfOrders.keySet()) {
                if (clientIdNumberOfOrders.get(id) > numberOfTimes) {
                    if (clientPriceOfOrder.contains(id)) {
                        bw.write(i + ") Client ID: " + id + "     || Number of orders:" + clientIdNumberOfOrders.get(id) + "\n");
                        i++;
                    }
                }
            }

            bw.close();
            fw.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        assert (new File(fileName).exists()) : true;
    }

    @Override
    public void generateProductsOfDayReport(Date orderDate, String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        int i = 0;
        bw.write("In date | " + orderDate + " | were ordered \n");

        List<Order> orders = this.hashMap.keySet().stream().filter(filter -> filter.getOrderDate().getDayOfMonth() == orderDate.getDate()).collect(Collectors.toList());

        Map<MenuItem, Integer> frevq = new HashMap<>();
        for (Order order : orders) {
            List<MenuItem> menuItems = this.hashMap.get(order);
            for (MenuItem item : menuItems) {
                frevq.computeIfPresent(item, (key, val) -> val + 1);
                frevq.putIfAbsent(item, 1);
            }
        }
        for (MenuItem item : frevq.keySet()) {
            bw.write(i + item.getName() + "ordered " + frevq.get(item) + "times\n");
            i++;
        }
       
        bw.close();
        fw.close();
        ;
    }


    public JTable createTable(ArrayList<MenuItem> list) {
        List<Object[]> objList = new ArrayList<>();
        for (MenuItem item : list) {
            objList.add(new Object[]{item.getName(), item.getRating(), item.getCalories(), item.getProtein(), item.getFat(), item.getSodium(), item.getPrice()});
        }
        DefaultTableModel tModel = new DefaultTableModel(objList.toArray(new Object[][]{}), new String[]{"Name", "Rating", "Calories", "Protein", "Fat", "Sodium:", "Price"});
        JTable table = new JTable(tModel);
        table.getTableHeader();
        System.out.println(table.getTableHeader());
        return table;
    }


    @Override
    public void addProduct(MenuItem product) {
        menuItems.add(product);
    }


    @Override
    public void notifyObservers(Order order) {

        for (Observer o : observers) {
            o.update(order);
        }

    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }


    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
