package businessLayer;


import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem{


    private List<MenuItem> itemList = new ArrayList<>();

    public CompositeProduct(String name){
        super(name,0,0,0,0,0,0);
    }

    @Override
    public int computePrice(List<MenuItem> menuItemList) {
        int totalPrice = 0;
        for(MenuItem item : menuItemList){
            totalPrice += item.getPrice();
        }
        super.setPrice(totalPrice);
        return totalPrice;
    }

    @Override
    public double computeRating(List<MenuItem> menuItemList) {
        double t=0;
        for (MenuItem menuItem : menuItemList) {
            t += menuItem.getRating();
        }
        t /= menuItemList.size();
        super.setRating(t);
        return t;
    }

    @Override
    public int computeCalories(List<MenuItem> menuItemList) {
        int totalCalories = 0;
        for(MenuItem item : menuItemList){
            totalCalories += item.getCalories();
        }
        super.setCalories(totalCalories);
        return totalCalories;
    }

    @Override
    public int computeProtein(List<MenuItem> menuItemList) {
        int totalProtein = 0;
        for(MenuItem item : menuItemList){
            totalProtein += item.getProtein();
        }
        super.setProtein(totalProtein);
        return totalProtein;
    }

    @Override
    public int computeFat(List<MenuItem> menuItemList) {
        int totalFat = 0;
        for(MenuItem item : menuItemList){
            totalFat += item.getProtein();
        }
        super.setFat(totalFat);
        return totalFat;
    }

    @Override
    public int computeSodium(List<MenuItem> menuItemList) {
        int totalSodium = 0;
        for(MenuItem item : menuItemList){
            totalSodium += item.getSodium();
        }
        super.setSodium(totalSodium);
        return totalSodium;
    }

    @Override
    public void add(MenuItem product) {
        itemList.add(product);
    }


}
