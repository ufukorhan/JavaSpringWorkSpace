import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.print("Lütfen bir isim giriniz: ");
//        String playerName = input.nextLine();
        Player player = new Player("Ufuk");
        System.out.println("Sayın " + player.getName() + " bu karanlık ve sisli adaya hoşgeldiniz !!");
        System.out.println("Lütfen bir karakter seçiniz !");
        System.out.println("----------------------------------------------------------------------------------");
        player.selectChar();

        Location location = null;

        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("########### Bölgeler ###########");
            System.out.println();
            System.out.println("1 - Güvenli Ev --> Burada düşman yok güvenli bir ev");
            System.out.println("2 - Eşya Dükkanı --> Silah veya Zırh satın alabilirsiniz !");
            System.out.println("3 - Mağara --> Ödül <Yemek>, dikkatli ol karşına zombi çıkabilir !");
            System.out.println("4 - Orman --> Ödül <Odun>, dikkatli ol karşına vampir çıkabilir !");
            System.out.println("5 - Nehir --> Ödül <Su>, dikkatli ol karşına ayı çıkabilir !");
            System.out.println("0 - Çıkış Yap --> Oyunu sonlandır.");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz !");
            }
            if (location == null) {
                System.out.println("Oyun sonlandırıldı !");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER !");
                break;
            }
        }
    }
}
