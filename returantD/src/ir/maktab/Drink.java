package ir.maktab;

public class Drink {
    private int     id ;
    private String  price ;
    private String  name ;
    private boolean available ;

    public Drink(int id, String price, String name, boolean available) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
