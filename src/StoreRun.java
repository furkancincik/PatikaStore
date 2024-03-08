import com.sun.source.tree.Tree;

import java.util.ArrayList;
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
        int ID = -1;
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

            if (isUniqueID) {
                break;
            }
            break;
        }


        boolean isUniqueID = false;
        while (!isUniqueID) {
            isUniqueID = true;
            for (MobilePhones phone : productManagement.getMobilePhonelist()) {
                if (phone.getId() == ID) {
                    isUniqueID = true;
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

        while (true) {
            Iterator<Brand> itr = brandManagement.getBrands().iterator();
            while (itr.hasNext()) {
                Brand brand = itr.next();
                if (brand.getName().equals(phoneBrand)) {
                    System.out.println("Seçim başarılı, seçilen marka: " + brand.getName());
                    isContain = true;
                    break;
                }
            }

            if (isContain) {
                break;
            } else {
                System.out.println("Lütfen aşağıdaki markalardan birini seçin! ");
                for (Brand b : brandManagement.getBrands()) {
                    System.out.println("- " + b.getName());
                }
                System.out.println("Ürünün markasını seciniz:");
                phoneBrand = inp.nextLine();
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

        MobilePhones newPhone = new MobilePhones(ID, phoneBrand, model, price, stock, discount, ram, storage, screenSize, megapixel, battery, color);
        System.out.println("Telefon başarıyla veritabanına eklendi!");

        productManagement.addMobilePhones(newPhone);

        return productManagement.getMobilePhonelist();

    }


    //Laptop ekleme

    public TreeSet<Laptops> addLaptop() {
        System.out.println("Laptop Ekleme Menüsü");
        int ID = -1;
        boolean inAddLaptop = true;
        while (inAddLaptop) {
            System.out.println("Eklemek istediginiz laptop için benzersiz bir ID belirleyin(sıfırdan büyük bir tam sayı)");

            //girilen id kontrol ediliyor
            while (!inp.hasNextInt()) {
                System.out.println("Gecersiz giriş. Lutfen sıfırdan büyük bir tam sayı giriniz.");
                inp.next();
            }
            ID = inp.nextInt();
            inp.nextLine();
            if (ID <= 0) {
                System.out.println("Geçersiz ID. ID sıfırdan büyük bir tam sayı olmalıdır.");
                continue;
            }

            boolean isUniqueID = true;

            for (Laptops laptop : productManagement.getLaptopLists()) {
                if (laptop.getId() == ID) {
                    isUniqueID = false;
                    System.out.println("Bu ID'ye sahip bir laptop zaten var. Lütfen benzersiz bir ID girin:");
                    break;
                }
            }
            if (isUniqueID) {
                break;
            }
            break;
        }


        boolean isUnique = false;
        while (!isUnique) {
            isUnique = true;

            for (Laptops laptop : productManagement.getLaptopLists()) {
                if (laptop.getId() == ID) {
                    System.out.println("Bu ID'ye sahip bir laptop zaten var. Lütfen benzersiz bir ID girin:");
                    break;
                }
            }
        }


        System.out.println("Eklemek istediğiniz notebook markasını seçiniz! ");
        String laptopBrand = inp.nextLine();
        boolean isContain = false;

        while (true) {
            Iterator<Brand> itr = brandManagement.getBrands().iterator();
            while (itr.hasNext()) {
                Brand brand = itr.next();
                if (brand.getName().equals(laptopBrand)) {
                    System.out.println("Seçim başarılı, seçilen marka: " + brand.getName());
                    isContain = true;
                    break;
                }
            }

            if (isContain) {
                break;
            } else {
                System.out.println("Lütfen aşağıdaki markalardan birini seçin! ");
                for (Brand b : brandManagement.getBrands()) {
                    System.out.println("- " + b.getName());
                }
                System.out.println("Ürünün markasını seciniz:");
                laptopBrand = inp.nextLine();
                break;
            }
        }


        System.out.println("Eklemek istediğiniz laptop modelini giriniz: ");
        String model = inp.nextLine();

        System.out.println("Eklemek istediğiniz laptop ücretini giriniz: ");
        int price = inp.nextInt();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz laptop stok adedini giriniz: ");
        int stock = inp.nextInt();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz laptpo indirim oranını giriniz: ");
        double discountRate = inp.nextDouble();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz laptop RAM miktarını giriniz: ");
        int ram = inp.nextInt();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz laptop hafızasını belirleyin: ");
        int storage = inp.nextInt();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz laptop ekran boyutunu giriniz: ");
        double screenSize = inp.nextDouble();
        inp.nextLine(); // Yeni satır karakterini temizle

        Laptops newLaptop = new Laptops(ID, laptopBrand, model, price, stock, discountRate, ram, storage, screenSize);
        System.out.println("Notebook başarıyla veritabanına eklendi!");

        productManagement.addLaptops(newLaptop);


        return productManagement.getLaptopLists();
    }

    //Telefon silme metodu
    public TreeSet<MobilePhones> removePhone() {
        System.out.println("Telefon Silme Menüsü");
        System.out.println();
        int ID = -1;
        boolean inRemovePhone = true;
        while (inRemovePhone) {
            System.out.println("Silmek istediginiz telefonun ID sini giriniz(ID sıfırdan büyük bir tam sayı olmalıdır)");
            while (!inp.hasNextInt()) {
                System.out.println("Geçersiz giriş. Lutfen sıfırdan büyük bir tam sayı giriniz.");
                inp.next();
            }

            ID = inp.nextInt();
            inp.nextLine();
            if (ID <= 0) {
                System.out.println("Geçersiz ID. ID sıfırdan büyük bir tam sayı olmalıdır.");
                continue;
            }

            boolean found = false;
            Iterator<MobilePhones> itr = productManagement.getMobilePhonelist().iterator();
            while (itr.hasNext()) {
                MobilePhones phone = itr.next();
                if (phone.getId() == ID) {
                    System.out.println("Bu ID'ye sahip bir telefon bulundu.");
                    System.out.println(phone.getName() + " Bu telefon Silindi !");
                    itr.remove();
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Girdiginiz ID'ye ait bir telefon bulunamadı.");
                System.out.println("Lutfen listedeki telefonlardan birisini seçiniz.");
                for (MobilePhones p : productManagement.getMobilePhonelist()) {
                    System.out.println(p);
                }
            } else {
                break;//ID bulundu.
            }

        }

        return productManagement.getMobilePhonelist();
    }


    // Laptop silme metodu

    public TreeSet<Laptops> removeLaptop() {
        System.out.println("Notebook Silme Menüsü");
        System.out.println();
        int ID = -1;
        boolean isRemoveLaptop = true;
        while (isRemoveLaptop) {
            System.out.println("Silmek istediginiz notebookun ID sini giriniz(ID sıfırdan büyük bir tam sayı olmalıdır)");
            while (!inp.hasNextInt()) {
                System.out.println("Geçersiz giriş. Lutfen sıfırdan büyük bir tam sayı giriniz.");
                inp.next();
            }
            ID = inp.nextInt();
            inp.nextLine();

            if (ID <= 0) {
                System.out.println("Geçersiz ID. ID sıfırdan büyük bir tam sayı olmalıdır.");
                continue;
            }

            boolean found = false;
            Iterator<Laptops> itr = productManagement.getLaptopLists().iterator();
            while (itr.hasNext()) {
                Laptops laptop = itr.next();
                if (laptop.getId() == ID) {
                    System.out.println("Bu ID'ye sahip bir telefon bulundu.");
                    System.out.println(laptop.getName() + " Bu Notebook silindi !");
                    itr.remove();
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Girdiginiz ID'ye ait bir telefon bulunamadı.");
                System.out.println("Lutfen listedeki telefonlardan birisini seçiniz.");
                for (Laptops l : productManagement.getLaptopLists()) {
                    System.out.println(l);
                }
            } else {
                break;//Bulunmuş oldu
            }

        }

        return productManagement.getLaptopLists();
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


    //Filtreleme Telefon
    public void filterMobilePhoneByBrand(String brand) {
        ArrayList<MobilePhones> sameBrandPhones = new ArrayList<>();
        boolean found = false;

        for (MobilePhones p : productManagement.getMobilePhonelist()) {
            if (p.getBrand().equalsIgnoreCase(brand)) {
                sameBrandPhones.add(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Aradığınız markada telefon bulunamadı !");
            System.out.println("Ana menüye dönülüyor...");
            System.out.println();
            return;
        }

        System.out.println("Tebrikler, aradığınız markada olan telefonlar bulundu:");
        System.out.println(" Bilgiler :");
        System.out.println(" ----------------------------------------------------------------------------------------------------------------|");
        System.out.println(" | ID | Ürün Adı                | Fiyat    | Marka    | Depolama   | Ekran   | Kamera | Batarya | RAM  | Renk    |");
        System.out.println(" ----------------------------------------------------------------------------------------------------------------|");

        for (MobilePhones p2 : sameBrandPhones) {
            System.out.printf(" | %-2s| %-24s| %-9s| %-9s| %-11s| %-8s| %-7s| %-9s| %-5s| %-8s|\n", p2.getId(), p2.getName(), p2.getPrice(), p2.getBrand(), p2.getStorage(), p2.getScreenSize(), p2.getCameraMegapixel(), p2.getBaterrycapacity(), p2.getRam(), p2.getColor());
            System.out.println("--------------------------------------------------------------------------------------------------------------");

        }
    }


    //Filtreleme Laptop

    public void filterLaptopByBrand(String brand) {
        ArrayList<Laptops> sameBrandLaptop = new ArrayList<>();
        boolean found = false;

        for (Laptops l : productManagement.getLaptopLists()) {
            if (l.getBrand().equalsIgnoreCase(brand)) {
                sameBrandLaptop.add(l);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Aradığınız markada laptop bulunamadı !");
            System.out.println("Ana menüye dönülüyor...");
            System.out.println();
            return;
        }

        System.out.println("Tebrikler aradığınız marka olan laptoplar bulundu");
        System.out.println(" Bilgiler :");
        System.out.println(" ----------------------------------------------------------------------------------------------------------------|");
        System.out.println(" | ID | Ürün Adı                | Fiyat    | Marka    | Depolama   | Ekran   | RAM                               |");
        System.out.println(" ----------------------------------------------------------------------------------------------------------------|");

        for (Laptops l2 : sameBrandLaptop) {
            System.out.printf(" | %-2s| %-24s| %-9s| %-9s| %-11s| %-8s| %-7s|\n", l2.getId(), l2.getName(), l2.getPrice(), l2.getBrand(), l2.getStorage(), l2.getScreenSize(), l2.getRam());
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        }
    }


    // URUN FILTRELEME MARKA METODU

    public void filterProductByBrandName() {
        productManagement.getLaptopLists();
        productManagement.getMobilePhonelist();

        boolean check = true;

        while (check) {
            System.out.println("Filtreleme işlemi (1) / Çıkış (0)");
            int choice = inp.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Ana Menüye Dönülüyor");
                    check = false;
                    break;
                case 1:
                    System.out.println("Filtreleme yapmak istediginiz urun kategorisini seciniz :");
                    System.out.println("1- Telefonlar");
                    System.out.println("2- Laptoplar");
                    System.out.println("0- Ana ekran");
                    int secim = inp.nextInt();
                    switch (secim) {
                        case 0:
                            System.out.println("Ana Menüye Dönülüyor");
                            break;
                        case 1:
                            System.out.print("Filtrelemek istediginiz telefon markası:");
                            String phoneBrandName = inp.next();
                            filterMobilePhoneByBrand(phoneBrandName);
                            break;
                        case 2:
                            System.out.print("Filtrelemek istediginiz Notebook markası:");
                            String laptopBrandName = inp.next();
                            filterLaptopByBrand(laptopBrandName);
                            break;
                        default:
                            System.out.println("Geçersiz bir giriş yaptınız.");
                    }
            }

        }


    }


    // telefon FILTRELEME  ID
    public void filterPhoneByID(int id1, int id2) {
        ArrayList<MobilePhones> phoneListByID = new ArrayList<>();
        boolean found = false;


        for (MobilePhones p : productManagement.getMobilePhonelist()) {
            if (id1 <= p.getId() && p.getId() <= id2) {
                phoneListByID.add(p);
                found = true;
            }
        }


        if (!found) {
            System.out.println("Aradığınız markada telefon bulunamadı !");
            System.out.println("Ana menüye dönülüyor...");
            System.out.println();
            return;
        }

        System.out.println("Tebrikler, aradığınız markada olan telefonlar bulundu:");
        System.out.println(" Bilgiler :");
        System.out.println(" ----------------------------------------------------------------------------------------------------------------|");
        System.out.println(" | ID | Ürün Adı                | Fiyat    | Marka    | Depolama   | Ekran   | Kamera | Batarya | RAM  | Renk    |");
        System.out.println(" ----------------------------------------------------------------------------------------------------------------|");

        for (MobilePhones p2 : phoneListByID) {
            System.out.printf(" | %-2s| %-24s| %-9s| %-9s| %-11s| %-8s| %-7s| %-9s| %-5s| %-8s|\n", p2.getId(), p2.getName(), p2.getPrice(), p2.getBrand(), p2.getStorage(), p2.getScreenSize(), p2.getCameraMegapixel(), p2.getBaterrycapacity(), p2.getRam(), p2.getColor());
            System.out.println("--------------------------------------------------------------------------------------------------------------");

        }
    }


    // laptop FILTRELEME  ID

    public void filterNotebookByID(int id1, int id2) {
        ArrayList<Laptops> laptopListByID = new ArrayList<>();
        boolean found = false;


        for (Laptops l : productManagement.getLaptopLists()) {
            if (id1 <= l.getId() && l.getId() <= id2) {
                laptopListByID.add(l);
                found = true;
            }
        }


        if (!found) {
            System.out.println("Aradığınız markada laptop bulunamadı !");
            System.out.println("Ana menüye dönülüyor...");
            System.out.println();
            return;
        }


        System.out.println("Tebrikler aradığınız marka olan laptoplar bulundu");
        System.out.println(" Bilgiler :");
        System.out.println(" ----------------------------------------------------------------------------------------------------------------|");
        System.out.println(" | ID | Ürün Adı                | Fiyat    | Marka    | Depolama   | Ekran   | RAM                               |");
        System.out.println(" ----------------------------------------------------------------------------------------------------------------|");


        for (Laptops l2 : laptopListByID) {
            System.out.printf(" | %-2s| %-24s| %-9s| %-9s| %-11s| %-8s| %-7s|\n", l2.getId(), l2.getName(), l2.getPrice(), l2.getBrand(), l2.getStorage(), l2.getScreenSize(), l2.getRam());
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        }
    }


    //ID Filter Metot

    public void filterProductByID() {
        productManagement.getMobilePhonelist();
        productManagement.getLaptopLists();

        boolean check = true;

        while (check) {
            System.out.println("Filtreleme işlemi (1) / Çıkış (0)");
            int choice = inp.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Çıkış yapılıyor");
                    check = false;
                    break;
                case 1:
                    System.out.println("Filtreleme yapmak istediginiz urun kategorisini seciniz :");
                    System.out.println("1- Telefonlar");
                    System.out.println("2- Laptoplar");
                    System.out.println("0- Ana ekran");
                    int secim = inp.nextInt();
                    switch (secim) {
                        case 0:
                            System.out.println("Ana Menüye Dönülüyor ");
                            break;
                        case 1:
                            System.out.println("Telefon Filtreleme Menüsü (ID)");
                            System.out.println();
                            System.out.print("Filtrelemek icin aralık giriniz - ID1 (alt sınır):");
                            int phoneFilterID1 = inp.nextInt();
                            System.out.print("Filtrelemek icin aralık giriniz - ID2 (üst sınır):");
                            int phoneBrandID2 = inp.nextInt();
                            filterPhoneByID(phoneFilterID1, phoneBrandID2);
                            break;
                        case 2:
                            System.out.println("Laptop Filtreleme Menüsü (ID)");
                            System.out.println();
                            System.out.print("Filtrelemek icin aralık giriniz - ID1 (alt sınır):");
                            int laptopFilterID1 = inp.nextInt();
                            System.out.print("Filtrelemek icin aralık giriniz - ID2 (üst sınır):");
                            int laptopFilterID2 = inp.nextInt();
                            filterNotebookByID(laptopFilterID1, laptopFilterID2);
                            break;
                        default:
                            System.out.println("Geçersiz Giriş Yaptınız !");
                    }
            }
        }


    }


}
