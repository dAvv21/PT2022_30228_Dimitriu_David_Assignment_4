package businessLayer;

import java.util.List;

public abstract class MenuItem {
    private String name;
    private double rating;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private int price;

    public MenuItem(String name, double rating, int calories, int protein,int fat, int sodium, int price) {
        this.name = name;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    public abstract int computePrice(List<MenuItem> menuItemList);
    public abstract double computeRating(List<MenuItem> menuItemList);
    public abstract int computeCalories(List<MenuItem> menuItemList);
    public abstract int computeProtein(List<MenuItem> menuItemList);
    public abstract int computeFat(List<MenuItem> menuItemList);
    public abstract int computeSodium(List<MenuItem> menuItemList);
    public abstract void add(MenuItem product);


    public MenuItem(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;

    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
