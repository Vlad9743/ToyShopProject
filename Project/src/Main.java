public class Main {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop(10);
        toyShop.basicToyShopGenerator();
        System.out.println(toyShop.ToyListToString());
        toyShop.setLotteryQueue();
        System.out.println(toyShop.LotteryQueueToString());
    }
}
