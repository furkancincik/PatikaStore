import java.util.Iterator;
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

    //Laptopları görüntüleme
    public void printLaptops() {
        TreeSet<Laptops> laptops = productManagement.getLaptopLists();
        System.out.println("---Laptoplar---");
        for (Laptops l : laptops) {
            System.out.println("  ID: " + l.getId() + "| Name: " + l.getName());
        }
    }


    //Telefon ekleme
    public TreeSet<MobilePhones> addMobilePhone() {
        System.out.println("Telefon Ekleme Menüsü");
        int ID=-1;
        boolean inAddPhone = true;
        while (inAddPhone) {
            System.out.println("Eklemek istediğiniz telefon için benzersiz bir ID belirleyin (sıfırdan büyük bir tam sayı): ");
            while (!inp.hasNextInt()) {
                System.out.println("Geçersiz giriş. Lütfen sıfırdan büyük bir tam sayı girin:");
                inp.next();
            }
            ID = inp.nextInt();
            inp.nextLine();
            if (ID <= 0) {
                System.out.println("Geçersiz ID. ID sıfırdan büyük bir tam sayı olmalıdır.");
                continue;
            }

            boolean isUniqueID = true;
            for (MobilePhones phone : productManagement.getMobilePhonelist()) {
                if (phone.getId() == ID) {
                    isUniqueID = false;
                    System.out.println("Bu ID'ye sahip bir telefon zaten var. Lütfen benzersiz bir ID girin:");
                    break;
                }
            }

            if (isUniqueID){
                break;
            }
            break;
        }



        boolean isUniqueID= false;
        while (!isUniqueID){
            isUniqueID=true;
            for (MobilePhones phone : productManagement.getMobilePhonelist()){
                if (phone.getId() == ID){
                    isUniqueID=false;
                    System.out.println("Bu ID'ye sahip bir telefon zaten var. Lütfen benzersiz bir ID girin:");
                    ID = inp.nextInt();
                    inp.nextLine();
                    break;
                }
            }
        }

        System.out.println("Eklemek istediğiniz telefonun markasını seçiniz! ");
        String phoneBrand = inp.nextLine();
        boolean isContain = false;

        while (true){
            Iterator<Brand> itr = brandManagement.getBrands().iterator();
            while (itr.hasNext()){
                Brand brand = itr.next();
                if (brand.getName().equals(phoneBrand)){
                    System.out.println("Seçim başarılı, seçilen marka: " + brand.getName());
                    isContain = true;
                    break;
                }
            }

            if (isContain){
                break;
            }else {
                System.out.println("Lütfen aşağıdaki markalardan birini seçin! ");
                for (Brand b: brandManagement.getBrands()){
                    System.out.println("- " + b.getName());
                }
                System.out.println("Ürünün markasını seciniz:");
                phoneBrand=inp.nextLine();
                break;
            }
        }

        System.out.println("Eklemek istediğiniz telefonun modelini giriniz: ");
        String model = inp.nextLine();

        System.out.println("Eklemek istediğiniz telefonun ücretini giriniz: ");
        int price = inp.nextInt();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz telefonun stok adedini giriniz: ");
        int stock = inp.nextInt();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz telefonun indirim oranını giriniz: ");
        double discount = inp.nextDouble();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz telefonun RAM miktarını giriniz: ");
        int ram = inp.nextInt();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz telefonun hafızasını belirleyin: ");
        int storage = inp.nextInt();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz telefonun ekran boyutunu giriniz: ");
        double screenSize = inp.nextDouble();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz telefonun kamera megapikselini giriniz: ");
        double megapixel = inp.nextDouble();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz telefonun batarya kapasitesini giriniz: ");
        int battery = inp.nextInt();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz telefonun rengini giriniz: ");
        String color = inp.nextLine();

        MobilePhones mobilePhones = new MobilePhones(ID, phoneBrand, model, price, stock, discount, ram, storage, screenSize, megapixel, battery, color);
        System.out.println("Telefon başarıyla veritabanına eklendi!");

        return productManagement.getMobilePhonelist();

    }


    //Laptop ekleme
    public void addLaptop() {


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
        for (Laptops laptops : productManagement.getLaptopLists()) {
            if (laptops.getId() == searchLaptopById) {
                System.out.println("Laptop Mevcut.");
                System.out.println("Stok : " + laptops.getStock());
                System.out.println();


            }
        }


    }


}
