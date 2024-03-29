import com.sun.source.tree.Tree;

import java.util.TreeSet;

public class Laptops implements Comparable<Laptops> {
    private int id;
    private String brand;
    private String name;
    private double price;
    private int stock;
    private double discountRate;
    private int ram;
    private int storage;
    private double screenSize;



    //constructor
    public Laptops(int id, String brand, String name, double price, int stock, double discountRate, int ram, int storage, double screenSize) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.discountRate = discountRate;
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }


    @Override
    public int compareTo(Laptops otherLaptop) {
        return Integer.compare(this.id,otherLaptop.id);
    }

    //getter's
    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public double getScreenSize() {
        return screenSize;
    }
}
