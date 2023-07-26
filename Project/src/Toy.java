public class Toy {
    private Integer id;
    private String name;
    private Integer quantity;
    private Integer frequency;

    public Toy(Integer id, String name, Integer quantity, Integer frequency){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public String toString(){
        return "id = '" + id + '\'' +
                ", name = '" + name + '\'' +
                ", quantity = '" + quantity + '\'' +
                ", frequency = '" + frequency + '\'';
    }

    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Integer getQuantity(){
        return quantity;
    }
    public Integer getFrequency(){
        return frequency;
    }

    public void setFrequency(Integer frequency){this.frequency = frequency;}
}
