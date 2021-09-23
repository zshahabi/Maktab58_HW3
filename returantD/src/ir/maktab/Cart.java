package ir.maktab;

public class Cart {
    private Launch launch;
    private Dinner dinner;

    public Cart(Launch launch, Dinner dinner) {
        this.launch = launch;
        this.dinner = dinner;
    }

    public Launch getLaunch() {
        return launch;
    }

    public void setLaunch(Launch launch) {
        this.launch = launch;
    }

    public Dinner getDinner() {
        return dinner;
    }

    public void setDinner(Dinner dinner) {
        this.dinner = dinner;
    }
}
