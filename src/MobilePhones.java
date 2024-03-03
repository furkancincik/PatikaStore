import java.util.TreeSet;

public class MobilePhones implements Comparable<MobilePhones>{
    private int id;
    private String brand;
    private String name;
    private double price;
    private int stock;
    private double discountRate;
    private int ram;
    private int storage;
    private double screenSize;
    private double cameraMegapixel;
    private int baterrycapacity;
    private String color;


    //constructor
    public MobilePhones(int id, String brand, String name, double price, int stock, double discountRate, int ram, int storage, double screenSize, double cameraMegapixel, int baterrycapacity, String color) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.discountRate = discountRate;
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
        this.cameraMegapixel = cameraMegapixel;
        this.baterrycapacity = baterrycapacity;
        this.color = color;

    }


    @Override
    public int compareTo(MobilePhones otherMobilePhone) {
        return Integer.compare(this.id,otherMobilePhone.id);
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

    public double getCameraMegapixel() {
        return cameraMegapixel;
    }

    public int getBaterrycapacity() {
        return baterrycapacity;
    }

    public String getColor() {
        return color;
    }

}
