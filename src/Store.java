import java.util.Scanner;

public class Store {


    public void printStore(){
        StoreRun storeRun = new StoreRun(); // StoreRun nesnesi oluşturuldu

        boolean inStore=true;

        while (inStore) {

            System.out.println("----------------------------------------------------------");
            System.out.println("| Mağza Yönetim Paneline Hoşgeldiniz                     |");
            System.out.println("----------------------------------------------------------");
            System.out.println("| 1 | Ürünleri Listele                                   |");
            System.out.println("| 2 | Marka Listele                                      |");
            System.out.println("| 3 | Marka Ekle                                         |");
            System.out.println("| 4 | Ürün Ara                                           |");
            System.out.println("| 5 | Ürün Ekle                                          |");
            System.out.println("| 6 | Ürün Sil                                           |");
            System.out.println("| 7 | Filtreleme Yap                                     |");
            System.out.println("| 0 | Çıkış                                              |");
            System.out.println("----------------------------------------------------------");
            System.out.print("Yapmak istediğiniz işlemi seçin: ");

            Scanner inp = new Scanner(System.in);
            int choice = inp.nextInt();

            switch (choice){
                case 0:
                    System.out.println("\nÇıkış Yapılıyor.");
                    inStore=false;
                    break;
                case 1:
                    System.out.println("\n----------------------------------------------------------");
                    System.out.println("| Ürünler Listeleniyor                                    |");
                    System.out.println("----------------------------------------------------------");
                    break;
                case 2:
                    System.out.println("\n----------------------------------------------------------");
                    System.out.println("| Markalar Listeleniyor                                    |");
                    System.out.println("----------------------------------------------------------");
                    storeRun.printBrands();
                    break;
                case 3:
                    System.out.println("\n----------------------------------------------------------");
                    System.out.println("| Marka Ekleniyor                                        |");
                    System.out.println("----------------------------------------------------------");

                    break;
                case 4:
                    System.out.println("\n----------------------------------------------------------");
                    System.out.println("| Ürün Aranıyor                                          |");
                    System.out.println("----------------------------------------------------------");
                    break;
                case 5:
                    System.out.println("\n----------------------------------------------------------");
                    System.out.println("| Ürün Ekleniyor                                         |");
                    System.out.println("----------------------------------------------------------");
                    break;
                case 6:
                    System.out.println("\n----------------------------------------------------------");
                    System.out.println("| Ürün Siliniyor                                         |");
                    System.out.println("----------------------------------------------------------");
                    break;
                case 7:
                    System.out.println("\n----------------------------------------------------------");
                    System.out.println("| Ürünler Markaya Göre Filtreleniyor                     |");
                    System.out.println("----------------------------------------------------------");
                    break;
                default:
                    System.out.println("Geçersiz işlem seçeneği! Lütfen tekrar deneyin.");
            }


        }





    }
}
