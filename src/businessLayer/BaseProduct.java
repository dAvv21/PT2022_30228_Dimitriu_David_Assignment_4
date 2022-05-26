package businessLayer;

import java.util.List;

public class BaseProduct extends MenuItem {


    public BaseProduct(String name, double rating, int calories, int protein,int fat, int sodium, int price) {
        super(name, rating, calories, protein, fat, sodium, price);
    }

    @Override
    public int computePrice(List<MenuItem> menuItemList) {
        return getPrice();
    }

    @Override
    public double computeRating(List<MenuItem> menuItemList) {
        return -1;
    }

    @Override
    public int computeCalories(List<MenuItem> menuItemList) {
        return -1;
    }

    @Override
    public int computeProtein(List<MenuItem> menuItemList) {
        return -1;
    }

    @Override
    public int computeFat(List<MenuItem> menuItemList) {
        return -1;
    }


    @Override
    public int computeSodium(List<MenuItem> menuItemList) {
        return -1;
    }

    @Override
    public void add(MenuItem product) {

    }

}
