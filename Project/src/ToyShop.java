import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyShop {
    private List<Toy> toyList;
    private int lotteryQueueSize;
    private List<Toy> lotteryQueue;

    public ToyShop(int lotteryQueueSize){
        this.lotteryQueueSize = lotteryQueueSize;
        toyList = new ArrayList<>();
        lotteryQueue = new ArrayList<>(this.lotteryQueueSize);
    }



    public String ToyListToString(){
        String output = "В магазине есть следующие игрушки: \n";
        for (Toy item : toyList) {
            output += "ID: " + item.getId() + "\n";
            output += "Название: " + item.getName() + "\n";
            output += "Количество: " + item.getQuantity() + "\n";
            output += "Вес в лотерее: " + item.getFrequency() + "\n";
            output += "---------------------------------------\n";
        }
        return output;
    }

    public String LotteryQueueToString(){
        String output = "";
        for (Toy item : lotteryQueue){
            output += item.getName() + " | ";
        }
        return output;
    }
    public void addToy(Toy toy){
        toyList.add(toy);
    }

    public List<Toy> getToyList(){ return toyList;}

    public Toy getToy(int i){
        return getToyList().get(i);
    }

    public void basicToyShopGenerator(){
        Toy toy0 = new Toy(0,"Пусто", 50, 50);
        Toy toy1 = new Toy(1,"Петрушка", 5, 10);
        Toy toy2 = new Toy(2,"Карабас-Барабас", 7, 35);
        Toy toy3 = new Toy(3,"Тортилла", 2, 5);

        toyList.add(toy0);
        toyList.add(toy1);
        toyList.add(toy2);
        toyList.add(toy3);
    }

    public Toy findById(int id){
        for (Toy item : toyList){
            if (id == item.getId()){
                return item;
            }
        }
        return null;
    }

    public void setLotteryQueue(){
        class Interval {
            Toy toy;
            int lowerBorder;
            int upperBorder;

            Interval(Toy toy, int lowerBorder, int upperBorder){
                this.toy = toy;
                this.lowerBorder = lowerBorder;
                this.upperBorder = upperBorder;
            }
        }
        List<Interval> intervals = new ArrayList<>();
        Interval firstInterval = new Interval(getToy(0), 0, getToy(0).getFrequency());
        intervals.add(firstInterval);
        int tempBorder = getToy(0).getFrequency();
        for (int i = 1; i < toyList.size(); i++){
            Interval tempInterval = new Interval(getToy(i), tempBorder, tempBorder + getToy(i).getFrequency());
            intervals.add(tempInterval);
            tempBorder += getToy(i).getFrequency();
        }
        int totalFrequency = 0;
        for (Toy item : toyList){
            totalFrequency += item.getFrequency();
        }

        Random random1 = new Random();
        for (int k = 0; k < lotteryQueueSize; k++){
            System.out.println(k);

            int randomDrop = random1.nextInt(totalFrequency)+1;
            System.out.println(randomDrop);
                for (Interval item1 : intervals){
                    if (randomDrop >= item1.lowerBorder && randomDrop <= item1.upperBorder){
                        lotteryQueue.add(item1.toy);
                        System.out.println(k);
                    }
                }

        }
    }
}
