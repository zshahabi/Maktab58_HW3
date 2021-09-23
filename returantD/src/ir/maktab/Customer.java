package ir.maktab;

public class Customer {
    private int    customerId;
    private String name;
    private String family;
    private String phoneNumber;
    private String gender;
    private Cart cart;

    private static int customerBaseId = 1000;


    public Customer(String name, String family, String phoneNumber, String gender, Cart cart) {
        this.name = name;
        this.family = family;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.cart = cart;

        customerId = customerBaseId++;
    }

//    public Customer(String name, String family, String phoneNumber, String gender) {
//        this.name = name;
//        this.family = family;
//        this.phoneNumber = phoneNumber;
//        this.gender = gender;
//
//        customerId = customerBaseId++;
//    }


    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public Cart getCart() {
        return cart;
    }

    public int getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
