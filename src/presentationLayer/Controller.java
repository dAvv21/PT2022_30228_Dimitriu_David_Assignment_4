package presentationLayer;

import businessLayer.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private LoginView loginView;
    private AdminMenuView adminMenuView;
    private ClientView clientView;
    private EmployeeView employeeView;
    private CreateProductView createProductView;
    private DeleteProductView deleteProductView;
    private EditProductView editProductView;
    private DeliveryService deliveryService;
    private ReportsView reportsView;
    private FilterView filterView;
    private JTable productsTable;

    public Controller(LoginView loginView, AdminMenuView adminMenuView, ClientView clientView, EmployeeView employeeView, CreateProductView createProductView, EditProductView editProductView, DeleteProductView deleteProductView, DeliveryService deliveryService, JTable productsTable) {
        this.loginView = loginView;
        this.adminMenuView = adminMenuView;
        this.clientView = clientView;
        this.employeeView = employeeView;
        this.createProductView = createProductView;
        this.editProductView = editProductView;
        this.deleteProductView = deleteProductView;
        this.deliveryService = deliveryService;
        this.productsTable = productsTable;
        reportsView = new ReportsView();
        filterView = new FilterView();


        this.loginView.loginBtn(new LoginToInterface());
        //edit products
        this.createProductView.createProductBtn(new CreateProduct());
        this.deleteProductView.deleteProductBtn(new DeleteProduct());
        this.editProductView.editProductBtn(new EditProduct());
        this.adminMenuView.viewAllProductBtn(new ViewAllProducts());
        this.adminMenuView.createMenuBtn(new CreateMenu());
        this.clientView.displayMeniuBtn(new DisplayMenu());
        //create order
        clientView.filterProducts(new GetToFilters());
        filterView.filterBtn(new FilterProducts());
        //repo
        this.reportsView.selectGenerateTimeIntervalReport(new GenerateTineIntervalReport());
        this.reportsView.generatePopularProductsBtn(new ProductsOrderedMore());
        this.reportsView.generateClientsReportBtn(new MoreXTimesGreaterYValue());
        this.reportsView.generateProdOrderedSpecificDayBtn(new ProductsOrderedInSpecificDay());
        this.clientView.createOrder(new CreateOrder());
        //navigation
        this.adminMenuView.BackToLoginBtn(new BackToLogin());
        this.clientView.BackToLoginBtn(new BackToLogin());
        this.employeeView.BackToLoginBtn(new BackToLogin());
        this.reportsView.getBackToAdminMeniuView(new BackToAdminMeniuView());
        this.filterView.BackToClientCiew(new BackToClientView());
        this.adminMenuView.selectReportsView(new SelectReportView());
        this.adminMenuView.selectDeleteBtn(new GetToDeleteProductView());
        this.adminMenuView.selectAddBtn(new GetToCreateProductView());
        this.adminMenuView.selectEditBtn(new GetToEditProductView());
        this.adminMenuView.importBtn(new ImportCSV());
    }

    class GenerateTineIntervalReport implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Time start = Time.valueOf(reportsView.getStartTxt());
            Time end = Time.valueOf(reportsView.getEndTxt());
            try {
                deliveryService.generateOrdersInIntervalReport(start, end, "Report1");
                JOptionPane.showMessageDialog(null, "Report generated");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Start time and end time format is hh:mm:ss!");
            }
        }
    }

    class ProductsOrderedMore implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int value = Integer.parseInt(reportsView.getNumOfOrdersTxt());
            try {
                deliveryService.generatePopularProductsReport(value, "Report2");
                JOptionPane.showMessageDialog(null, "Report generated!");

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    class MoreXTimesGreaterYValue implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int x = Integer.parseInt(reportsView.getXTimesTxt());
            int y = Integer.parseInt(reportsView.getOrderValueGreaterTxt());

            deliveryService.generateRegularClientsReport(x, y, "Report3");
            JOptionPane.showMessageDialog(null, "Report generated!");

        }
    }

    class ProductsOrderedInSpecificDay implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Date date = Date.valueOf(reportsView.getSpecificDayTxt());
                deliveryService.generateProductsOfDayReport(date, "Report4");
                JOptionPane.showMessageDialog(null, "Report generated!");


            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Please respect the date format : yyyy-mm-dd!");
            }
        }
    }


    class FilterProducts implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String keyWord = filterView.getKeywordTxt();
            double minRating = Double.parseDouble(filterView.getRatingMinTxt());
            double maxRating = Double.parseDouble(filterView.getRatingMaxTxt());
            int minPrice = Integer.parseInt(filterView.getPriceMinTxt());
            int maxPrice = Integer.parseInt(filterView.getPriceMaxTxt());
            int minCalories = Integer.parseInt(filterView.getCaloriesMinTxt());
            int maxCalories = Integer.parseInt(filterView.getCaloriesMaxTxt());
            int minProtein = Integer.parseInt(filterView.getProteinMinTxt());
            int maxProtein = Integer.parseInt(filterView.getProteinMaxTxt());
            int minFat = Integer.parseInt(filterView.getFattMinTxt());
            int maxFat = Integer.parseInt(filterView.getFatMaxTxt());
            int minSodium = Integer.parseInt(filterView.getSodiumMinTxt());
            int maxSodium = Integer.parseInt(filterView.getSodiumMaxTxt());

            if (!keyWord.equals("") && minRating != 0.0 && maxRating != 0.0 && minCalories != 0 && maxCalories != 0 && minPrice != 0 && maxPrice != 0 && minFat != 0 && maxFat != 0 && minSodium != 0 && maxSodium != 0) {
                List<MenuItem> menuItems = deliveryService.searchProductBy(keyWord, minRating, maxRating, minPrice, maxPrice, minCalories, maxCalories, minProtein, maxProtein, minFat, maxFat, minSodium, maxSodium);
                deliveryService.setMenuItems((ArrayList<MenuItem>) menuItems);
                JTable table = deliveryService.createTable((ArrayList<MenuItem>) menuItems);
                System.out.println("--------------------------------------");
                for (MenuItem item : menuItems) {
                    System.out.println(item.getName());
                }
                System.out.println("--------------------------------------");
                clientView.setMeniuTable(table);
                clientView.showProductsTable(table);

                filterView.setVisible(false);
                clientView.setVisible(true);
            } else {
                System.out.println("No item find!");
            }
        }
    }

    class ViewAllProducts implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            productsTable = deliveryService.createTable(deliveryService.getMenuItems());
            for (MenuItem menuItem : deliveryService.getMenuItems()) { //NU PRINTEAZA NIMIC
                System.out.println(menuItem.getName() + menuItem.getRating());
            }
            adminMenuView.showProductsTable(productsTable);
            adminMenuView.setProductsTable(productsTable);

        }
    }

    class DisplayMenu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            deliveryService.readProductsFromCSV("src/products.csv");
            deliveryService.setMenuItems(deliveryService.getMenuItems());

            productsTable = deliveryService.createTable(deliveryService.getMenuItems());
            clientView.showProductsTable(productsTable);
            //clientView.setMeniuTable(productsTable);

        }
    }

    class GetToFilters implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.setVisible(false);
            filterView.setVisible(true);
        }
    }

    class CreateOrder implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int[] rows = clientView.getMeniuTable().getSelectedRows();
            JTable table = clientView.getMeniuTable();
            List<MenuItem> menuItemList = new ArrayList<>();


            for (int row : rows) {
                String productName = table.getModel().getValueAt(row, 0).toString();
                double rating = Double.parseDouble(table.getModel().getValueAt(row, 1).toString());
                int calories = Integer.parseInt(table.getModel().getValueAt(row, 2).toString());
                int proteins = Integer.parseInt(table.getModel().getValueAt(row, 3).toString());
                int fat = Integer.parseInt(table.getModel().getValueAt(row, 4).toString());
                int sodium = Integer.parseInt(table.getModel().getValueAt(row, 5).toString());
                int price = Integer.parseInt(table.getModel().getValueAt(row, 6).toString());

                menuItemList.add(new BaseProduct(productName, rating, calories, proteins, fat, sodium, price));
            }

            int orderId = deliveryService.getMap().size() + 1;

            Order o = new Order(orderId, clientView.getClient().getIdUser());

            adminMenuView.showProductsTable(productsTable);
            try {
                deliveryService.placeOrder(o, menuItemList);
                JOptionPane.showMessageDialog(null, "The orders was placed.Worker notified!");

            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error while placing the order!");

            }

        }
    }


    class ImportCSV implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                deliveryService.readProductsFromCSV("src/products.csv");
                JOptionPane.showMessageDialog(null, "Products imported!");
                deliveryService.setMenuItems(deliveryService.getMenuItems());

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error!");
            }
        }
    }

    class LoginToInterface implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            String username = loginView.getUsernameField();
            String password = loginView.getPwdPassword();

            List<User> user = deliveryService.getUsers().stream().filter(x -> x.getUsername().compareTo(username) == 0).filter(x -> x.getPassword().compareTo(password) == 0).collect(Collectors.toList());
            clientView.setClient(user.get(0));
            if (user.get(0).getType() == 0) {
                //e administrator
                adminMenuView.setVisible(true);
            } else if (user.get(0).getType() == 1) {
                //angajat
                clientView.setVisible(true);
            } else if (user.get(0).getType() == 2) {
                //client
                employeeView.setVisible(true);
            }


        }
    }

    //back buttons
    class BackToLogin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            employeeView.setVisible(false);
            clientView.setVisible(false);
            employeeView.setVisible(false);
            loginView.setVisible(true);

        }
    }

    class BackToClientView implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            filterView.setVisible(false);
            clientView.setVisible(true);
        }
    }

    class BackToAdminMeniuView implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            reportsView.setVisible(false);
            adminMenuView.setVisible(true);
        }
    }

    class SelectReportView implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            adminMenuView.setVisible(false);
            reportsView.setVisible(true);
        }
    }

    class GetToCreateProductView implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            adminMenuView.setVisible(false);
            createProductView.setVisible(true);
        }
    }

    class GetToEditProductView implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            adminMenuView.setVisible(false);
            editProductView.setVisible(true);
        }
    }
    //navigations button


    class CreateProduct implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = createProductView.getNameTxt();
            double rating = Double.parseDouble(createProductView.getRatingTxt());
            int calories = Integer.parseInt(createProductView.getCaloriesTxt());
            int protein = Integer.parseInt(createProductView.getProteinTxt());
            int fat = Integer.parseInt(createProductView.getFatTxt());
            int sodium = Integer.parseInt(createProductView.getSodiumTxt());
            int price = Integer.parseInt(createProductView.getPriceTxt());

            deliveryService.addProduct(new BaseProduct(name, rating, calories, protein, fat, sodium, price));
            createProductView.setVisible(false);
            adminMenuView.setVisible(true);

        }
    }

    class EditProduct implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = editProductView.getNameTxt();
            double rating = Double.parseDouble(editProductView.getRatingTxt());
            int calories = Integer.parseInt(editProductView.getCaloriesTxt());
            int protein = Integer.parseInt(editProductView.getProteinTxt());
            int fat = Integer.parseInt(editProductView.getFatTxt());
            int sodium = Integer.parseInt(editProductView.getSodiumTxt());
            int price = Integer.parseInt(editProductView.getPriceTxt());

            if (deliveryService.validProduct(name)) {
                deliveryService.editItemFromMenu(name, rating, calories, protein, fat, sodium, price);
                editProductView.setVisible(false);
                adminMenuView.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR! The product isn't in meniu!");
            }
        }
    }

    class GetToDeleteProductView implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            adminMenuView.setVisible(false);
            deleteProductView.setVisible(true);
        }
    }

    class DeleteProduct implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = deleteProductView.getNameTxt();
            if (deliveryService.validProduct(name)) {
                deliveryService.deleteProduct(name);
                deleteProductView.setVisible(false);
                adminMenuView.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR! The product isn't in meniu!");
            }
        }
    }

    class CreateMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int[] rows = adminMenuView.getProductsTable().getSelectedRows();
            JTable table = adminMenuView.getProductsTable();
            List<MenuItem> menuItemList = new ArrayList<>();


            for (int row : rows) {
                String productName = table.getModel().getValueAt(row, 0).toString();
                double rating = Double.parseDouble(table.getModel().getValueAt(row, 1).toString());
                int calories = Integer.parseInt(table.getModel().getValueAt(row, 2).toString());
                int proteins = Integer.parseInt(table.getModel().getValueAt(row, 3).toString());
                int fat = Integer.parseInt(table.getModel().getValueAt(row, 4).toString());
                int sodium = Integer.parseInt(table.getModel().getValueAt(row, 5).toString());
                int price = Integer.parseInt(table.getModel().getValueAt(row, 6).toString());

                menuItemList.add(new BaseProduct(productName, rating, calories, proteins, fat, sodium, price));
            }
            String menuName = adminMenuView.getMenuNameTxt();
            deliveryService.addCompositeProduct(menuItemList, menuName);
            adminMenuView.showProductsTable(productsTable);

        }
    }

    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        AdminMenuView adminMenuView = new AdminMenuView();
        ClientView clientView = new ClientView();
        EmployeeView employeeView = new EmployeeView();
        DeliveryService deliveryService = new DeliveryService();
        JTable productsTable = new JTable();
        CreateProductView createProductView = new CreateProductView();
        EditProductView editProductView = new EditProductView();
        DeleteProductView deleteProductView = new DeleteProductView();

        Controller controller = new Controller(loginView, adminMenuView, clientView, employeeView, createProductView, editProductView, deleteProductView, deliveryService, productsTable);
        EmployeeController employeeController = new EmployeeController(employeeView, deliveryService);
    }
}
