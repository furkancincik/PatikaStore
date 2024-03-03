import java.util.Scanner;
import java.util.TreeSet;

public class ProductManagement {
    private TreeSet<Laptops> laptops = new TreeSet<>();
    private TreeSet<MobilePhones> mobilePhones = new TreeSet<>();
    private Scanner inp = new Scanner(System.in);


    //mevcut laptoplar
    public TreeSet<Laptops> getLaptopLists() {
        laptops.add(new Laptops(1, "Huawei  ", "Matebook 14", 7000.0, 15, 12, 16, 512, 14.0));
        laptops.add(new Laptops(2, "Lenovo  ", "V14 IGL", 3699.0, 21, 11, 8, 1024, 14.0));
        laptops.add(new Laptops(3, "Asus    ", "Tuf Gaming", 8199.0, 10, 3, 32, 2048, 15.6));
        laptops.add(new Laptops(4, "Apple   ", "Macbook pro", 9999.0, 6, 2, 8, 512, 13.0));
        laptops.add(new Laptops(5, "Hp      ", "Pavilion Gaming", 8766.0, 4, 12, 16, 1024, 17.0));
        laptops.add(new Laptops(6, "Huawei  ", "Matebook 13", 6000.0, 25, 11, 16, 512, 14.0));
        laptops.add(new Laptops(7, "Monster ", "Abra A7", 17000.0, 5, 6, 64, 2048, 17.0));
        laptops.add(new Laptops(8, "Monster ", "Abra Semruk 7", 23000.0, 5, 3, 128, 2048, 17.0));
        return laptops;
    }

    //Mevcut telefonlar.
    public TreeSet<MobilePhones> getMobilePhonelist() {
        mobilePhones.add(new MobilePhones(1, "Samsung", "GALAXY A51", 3199.0, 100, 30, 6, 128, 6.5, 32, 4000, "Siyah"));
        mobilePhones.add(new MobilePhones(2, "Apple  ", "IPhone 11", 7379.0, 90, 10, 6, 64, 6.1, 5, 3046, "Mavi"));
        mobilePhones.add(new MobilePhones(3, "Xiaomi ", "Redmi Note 10 Pro", 4012.0, 200, 10, 12, 128, 6.5, 35, 4000, "Beyaz"));
        mobilePhones.add(new MobilePhones(4, "Huawei ", "P22", 3099.0, 60, 10, 8, 128, 5.5, 16, 3700, "Beyaz"));
        mobilePhones.add(new MobilePhones(5, "Huawei ", "Mate 90", 15000.0, 100, 20, 12, 256, 6.6, 128, 8000, "Siyah"));
        mobilePhones.add(new MobilePhones(6, "Nokia  ", "Lumia 1020", 5199.0, 25, 5, 12, 128, 5.5, 32, 3000, "Sari"));
        return mobilePhones;
    }

    public void addLaptops(Laptops laptop) {
        laptops.add(laptop);
    }

    public void addMobilePhones(MobilePhones mobilePhone) {
        mobilePhones.add(mobilePhone);
    }

}
