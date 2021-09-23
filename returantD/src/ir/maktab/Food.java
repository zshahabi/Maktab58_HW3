package ir.maktab;

public class Food {
    private int     id ;
    private String  price ;
    private String  name ;
    private boolean available ;

    public Food(int id, String price, String name, boolean available) {
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

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", price='" + price + '\'' +
                ", name='" + name + '\'' +
                ", available=" + available +
                '}';
    }
}
