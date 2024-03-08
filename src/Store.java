import java.util.Scanner;

public class Store {


    public void printStore(){
        StoreRun storeRun = new StoreRun(); // StoreRun nesnesi oluşturuldu

        boolean inStore=true;

        while (inStore) {

            System.out.println("----------------------------------------------------------");
            System.out.println("| Mağza Yönetim Paneline Hoşgeldiniz                     |");
            System.out.println("----------------------------------------------------------");
            System.out.println("| 1 | Notebook Islemleri                                 |");
            System.out.println("| 2 | Cep Telefonu Islemleri                             |");
            System.out.println("| 3 | Markaları Goruntule                                |");
            System.out.println("| 4 | Ürün Ara                                           |");
            System.out.println("| 5 | Filtreleme Yap                                     |");
            System.out.println("| 0 | Çıkış                                              |");
            System.out.println("----------------------------------------------------------");
            System.out.println();
            System.out.print("Yapmak istediğiniz işlemi seçin: ");

            Scanner inp = new Scanner(System.in);
            int choice = inp.nextInt();

            switch (choice){
                case 0:
                    System.out.println("\nÇıkış Yapılıyor.");
                    inStore=false;
                    break;
                case 1:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("| Notebook'ları görüntüle(1)                               |");
                    System.out.println("| Notebook eklemek icin  (2)                               |");
                    System.out.println("| Notebook silmek icin   (3)                               |");
                    System.out.println("| Ana Menüye Dön         (0)                               |");
                    System.out.println("------------------------------------------------------------");
                    System.out.println();
                    System.out.print("Yapmak istediğiniz işlemi seçin: ");
                    int choiceNotebook = inp.nextInt();
                    switch (choiceNotebook){
                        case 0:
                            System.out.println("Ana Menüye dönülüyor");
                            break;
                        case 1:
                            System.out.println("Notebookları görüntüleme");
                            storeRun.printLaptops();
                            break;
                        case 2:
                            System.out.println("notebook ekleme");
                            storeRun.addLaptop();
                            break;
                        case 3:
                            System.out.println("Notebook silme");
                            storeRun.removeLaptop();
                            break;
                        default:
                            System.out.println("Gecersiz giris yaptınız");

                    }

                    break;
                case 2:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("| Cep Telefonlarını Görüntüle (1)                          |");
                    System.out.println("| Cep Telefonu Ekle           (2)                          |");
                    System.out.println("| Cep Telefonu Sil            (3)                          |");
                    System.out.println("| Ana Menüye Dön              (0)                          |");
                    System.out.println("------------------------------------------------------------");
                    System.out.println();
                    System.out.print("Yapmak istediğiniz işlemi seçin: ");
                    int choicePhone = inp.nextInt();
                    switch (choicePhone){
                        case 0:
                            System.out.println("Ana Menüye dönülüyor");
                            break;
                        case 1:
                            System.out.println("Cep telefonu görüntüleme");
                            storeRun.printPhones();
                            break;
                        case 2:
                            System.out.println("cep telefonu ekleme");
                            storeRun.addMobilePhone();
                            break;
                        case 3:
                            System.out.println("cel telefonu silme");
                            storeRun.removePhone();
                            break;
                        default:
                            System.out.println("Gecersiz giris yaptınız");
                    }
                    break;
                case 3:
                    System.out.println("\n---------------------------------------------------------");
                    System.out.println("| Markalar Listeleniyor                                   |");
                    System.out.println("-----------------------------------------------------------");
                    storeRun.printBrands();

                    break;
                case 4:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("| Arama Islemi  --  Telefon icin(1) / Laptop icin(2)       |");
                    System.out.println("| IPTAL / CIKIS icin (0)                                   |");
                    System.out.println("------------------------------------------------------------");
                    System.out.print("Secim:");
                    int choiceSearch=inp.nextInt();
                    System.out.println();
                    switch (choiceSearch){
                        case 0:
                            System.out.println("Ana Menüye dönülüyor");
                            break;
                        case 1:
                            System.out.print("Aramak istediginiz telefon ID'sini giriniz:");
                            int searchPhoneById=inp.nextInt();
                            storeRun.searchPhoneByID(searchPhoneById);
                            break;
                        case 2:
                            System.out.print("Aramak istediginiz laptop ID'sini giriniz:");
                            int searchLaptopById=inp.nextInt();
                            storeRun.searchLaptopByID(searchLaptopById);
                            break;
                        default:
                            System.out.println("Geçersiz giriş yaptınız. Ana Menüye Dönülüyor.");
                    }
                    break;

                case 5:
                    System.out.println("\n----------------------------------------------------------");
                    System.out.println("| Markaya göre filtreleme(1) / ID ye göre filtreleme (2)   |");
                    System.out.println("| IPTAL / CIKIS icin (0)                                   |");
                    System.out.println("------------------------------------------------------------");
                    int choiceFilter = inp.nextInt();
                    switch (choiceFilter){
                        case 0:
                            System.out.println("Ana menüye dönülüyor.");
                            break;
                        case 1:
                            System.out.println("Markaya Göre Filtreleme Menüsü");
                            storeRun.filterProductByBrandName();
                        case 2:
                            System.out.println("ID'ye Göre Filtreleme Menüsü");
                            storeRun.filterProductByID();
                            break;
                        default:
                            System.out.println("Geçersiz giriş yaptınız.Ana Menüye Dönülüyor");
                    }
                    break;
                default:
                    System.out.println("Geçersiz işlem seçeneği! Lütfen tekrar deneyin.");
            }


        }





    }
}
