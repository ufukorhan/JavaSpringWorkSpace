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
        player.selectChar();

        Location location = null;

        while (true){
            player.printInfo();
            System.out.println();
            System.out.println("########### Bölgeler ###########");
            System.out.println();
            System.out.println("1 - Güvenli Ev --> Burada düşman yok güvenli bir ev");
            System.out.println("2 - Mağaza --> Silah veya Zırh satın alabilirsiniz !");
            System.out.println("0 - Çıkış Yap --> Oyunu sonlandır.");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if (location == null){
                System.out.println("Oyun sonlandırıldı !");
                break;
            }
            if (!location.onLocation()){
                System.out.println("GAME OVER !");
                break;
            }
        }
    }
}
