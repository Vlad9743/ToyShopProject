import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ToyShop toyShop = new ToyShop(10);
        toyShop.basicToyShopGenerator();
        System.out.println(toyShop.ToyListToString());
        toyShop.setLotteryQueue();


        while (toyShop.getCurrentLotteryQueueSize() > 0) {
            System.out.println(toyShop.LotteryQueueToString());
            System.out.println("Хотите получить приз? (y/n)");
            Scanner scanner = new Scanner(System.in);
            String chose = scanner.nextLine();
            if (chose.equals("y")) {
                System.out.println(toyShop.givePrize());
            } else System.out.println("Ну, и ладно.");
        }
    }
}
