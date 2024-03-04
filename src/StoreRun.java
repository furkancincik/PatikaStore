import java.util.Scanner;
import java.util.TreeSet;

public class StoreRun {
    private BrandManagement brandManagement = new BrandManagement(); // BrandManagement nesnesi oluşturuldu
    private ProductManagement productManagement = new ProductManagement(); // ProductManagement nesnesi olusturuldu
    private Scanner inp = new Scanner(System.in);


    //Markaları Goruntuleme
    public void printBrands() {
        TreeSet<Brand> brands = brandManagement.getBrands();//brand nesnesinden markalar alındı
        System.out.println("---Markalar---");
        for (Brand brand : brands) {
            System.out.println("- Name: " + brand.getName());
        }


    }


    //Telefonları Goruntuleme
    public void printPhones() {
        TreeSet<MobilePhones> mobilePhones = productManagement.getMobilePhonelist();
        System.out.println("---Telefonlar---");
        for (MobilePhones m : mobilePhones) {
            System.out.println("  ID: " + m.getId() + "| Name: " + m.getName());
        }

    }


    //Marka ekleme
    public void addBrand() {

    }


    //Uurun ekleme
    public void addMobilePhone() {


    }

    //Urun silme
    public void removeProduct() {

    }

    //Urun Arama  searchTelefonByID
    public void searchPhoneByID(int searchPhoneById) {
        for (MobilePhones phones : productManagement.getMobilePhonelist()) {
            if (phones.getId() == searchPhoneById) {
                System.out.println("Telefon Mevcut.");
                System.out.println("Stok : " + phones.getStock());
                System.out.println();
            }
        }
    }


    //Urun Arama  searchLaptopByID
    public void searchLaptopByID(int searchLaptopById) {
        for (Laptops laptops : productManagement.getLaptopLists()){
            if (laptops.getId() == searchLaptopById){
                System.out.println("Laptop Mevcut.");
                System.out.println("Stok : " + laptops.getStock());
                System.out.println();


            }
        }



    }


}
