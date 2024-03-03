import java.util.Scanner;
import java.util.TreeSet;

public class StoreRun {
    private BrandManagement brandManagement = new BrandManagement(); // BrandManagement nesnesi oluşturuldu
    private Scanner inp = new Scanner(System.in);





    //Markaları Goruntuleme
    public void printBrands(){
        TreeSet<Brand> brands = brandManagement.getBrands();//brand nesnesinden markalar alındı
        System.out.println("---Markalar---");
        for (Brand brand : brands){
            System.out.println("- Name: " + brand.getName());
        }


    }


    //Marka ekleme
    public void addBrand(){

    }


    //Uurun ekleme
    public void addProduct(){

    }

    //Urun silme
    public void removeProduct(){

    }



}
