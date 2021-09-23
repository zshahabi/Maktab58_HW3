package ir.maktab;

import java.util.Arrays;

public class Restaurant {
    private Customer[] customers ;
    private Launch launch;
    private Dinner dinner;

    public Restaurant() {
        customers = new Customer[0];
        launch    = new Launch(new Food[0],new Drink[0]);
        dinner    = new Dinner(new Food[0],new Drink[0]);
    }

    //adding food to dinner menu
    public void addToDinnerMenu(Food food) {
        Food[] foods = dinner.getFoods();
        foods        = Arrays.copyOf(foods,foods.length+1);
        foods[foods.length-1] = food;

        dinner.setFoods(foods);
    }
    //adding drink to dinner menu
    public void addToDinnerMenu(Drink drink) {
        Drink[] drinks = dinner.getDrinks();
        drinks         = Arrays.copyOf(drinks,drinks.length+1);
        drinks[drinks.length-1] = drink;

        dinner.setDrinks(drinks);
    }


    //adding food to launch menu
    public void addToLaunchMenu(Food food) {
        Food[] foods = launch.getFoods();
        foods        = Arrays.copyOf(foods,foods.length+1);
        foods[foods.length-1] = food;

        launch.setFoods(foods);
    }
    //adding drink to launch menu
    public void addToLaunchMenu(Drink drink) {
        Drink[] drinks = launch.getDrinks();
        drinks         = Arrays.copyOf(drinks,drinks.length+1);
        drinks[drinks.length-1] = drink;

        launch.setDrinks(drinks);
    }


    //getting customers information
    public String getCustomersInfo() {
        return "customers=" + Arrays.toString(customers) +
                '}';
    }


    public void addCustomer(Customer customer) {
        customers = Arrays.copyOf(customers,customers.length+1);
        customers[customers.length-1] = customer;
    }

    //adding new Order via launch
    public void addNewOrder_launch(Food food,int customerId) {
        //finding customer index
        int customerIndex = -1;
        for (int i = 0; i < customers.length; i++) {
            if (customerId == customers[i].getCustomerId()) {
                customerIndex = i;
            }
        }

        //get food which is in launch in cart
        Cart cart     = customers[customerIndex].getCart();
        Launch launch = cart.getLaunch();
        Food[] foods  = launch.getFoods();

        //add food
        foods = Arrays.copyOf(foods,foods.length+1);
        foods[foods.length-1] = food;

        //setup cart
        launch.setFoods(foods);
        cart.setLaunch(launch);
        customers[customerIndex].setCart(cart);

    }
    //adding new Order via launch
    public void addNewOrder_launch(Drink drink,int customerId) {
        //finding customer index
        int customerIndex = -1;
        for (int i = 0; i < customers.length; i++) {
            if (customerId == customers[i].getCustomerId()) {
                customerIndex = i;
            }
        }

        //get drink which is in launch in cart
        Cart cart     = customers[customerIndex].getCart();
        Launch launch = cart.getLaunch();
        Drink[] drinks  = launch.getDrinks();

        //add drink
        drinks = Arrays.copyOf(drinks,drinks.length+1);
        drinks[drinks.length-1] = drink;

        //setup cart
        launch.setDrinks(drinks);
        cart.setLaunch(launch);
        customers[customerIndex].setCart(cart);


    }

    //adding new Order via dinner
    public void addNewOrder_dinner(Food food,int customerId) {
        //finding customer index
        int customerIndex = -1;
        for (int i = 0; i < customers.length; i++) {
            if (customerId == customers[i].getCustomerId()) {
                customerIndex = i;
            }
        }

        //get food which is in dinner in cart
        Cart cart     = customers[customerIndex].getCart();
        Dinner dinner = cart.getDinner();
        Food[] foods  = dinner.getFoods();

        //add food
        foods = Arrays.copyOf(foods,foods.length+1);
        foods[foods.length-1] = food;

        //setup cart
        dinner.setFoods(foods);
        cart.setDinner(dinner);
        customers[customerIndex].setCart(cart);

    }
    //adding new Order via launch
    public void addNewOrder_dinner(Drink drink,int customerId) {
        //finding customer index
        int customerIndex = -1;
        for (int i = 0; i < customers.length; i++) {
            if (customerId == customers[i].getCustomerId()) {
                customerIndex = i;
            }
        }

        //get drink which is in dinner in cart
        Cart cart     = customers[customerIndex].getCart();
        Dinner dinner = cart.getDinner();
        Drink[] drinks  = dinner.getDrinks();

        //add drink
        drinks = Arrays.copyOf(drinks,drinks.length+1);
        drinks[drinks.length-1] = drink;

        //setup cart
        dinner.setDrinks(drinks);
        cart.setDinner(dinner);
        customers[customerIndex].setCart(cart);

    }


    //showing order details of customer
    public String showCustomerOrders(int customerId){
        //finding customer index
        int customerIndex = -1;
        for (int i = 0; i < customers.length; i++) {
            if (customerId == customers[i].getCustomerId()) {
                customerIndex = i;
                break;
            }
        }

        return customers[customerIndex].toString();
    }

    //canceling a food order in launch
    public void cancelFoodOrder_launch(int customerId,int foodId) {
        //finding customer index
        int customerIndex = -1;
        for (int i = 0; i < customers.length; i++) {
            if (customerId == customers[i].getCustomerId()) {
                customerIndex = i;
                break;
            }
        }

        //finding food index
        int foodIndex = -1;
        Food[] foods = customers[customerIndex].getCart().getLaunch().getFoods();
        int i =0;
        boolean flag = true;
        while(i<foods.length && flag) {
            if (foods[i].getId() == foodId) {
                foodIndex = i;
                flag = false;
            }
            i++;
        }

        //setup customer details
        foods[foodIndex].setAvailable(false);
        customers[customerIndex].getCart().getLaunch().setFoods(foods);


    }
    //canceling a drink order in launch
    public void cancelDrinkOrder_launch(int customerId,int drinkId) {
        //finding customer index
        int customerIndex = -1;
        for (int i = 0; i < customers.length; i++) {
            if (customerId == customers[i].getCustomerId()) {
                customerIndex = i;
                break;
            }
        }

        //finding food index
        int drinkIndex = -1;
        Drink[] drinks = customers[customerIndex].getCart().getLaunch().getDrinks();
        int i =0;
        boolean flag = true;
        while(i<drinks.length && flag) {
            if (drinks[i].getId() == drinkId) {
                drinkIndex = i;
                flag = false;
            }
            i++;
        }

        //setup customer details
        drinks[drinkIndex].setAvailable(false);
        customers[customerIndex].getCart().getLaunch().setDrinks(drinks);


    }

    //canceling a food order in dinner
    public void cancelFoodOrder_dinner(int customerId,int foodId) {
        //finding customer index
        int customerIndex = -1;
        for (int i = 0; i < customers.length; i++) {
            if (customerId == customers[i].getCustomerId()) {
                customerIndex = i;
                break;
            }
        }

        //finding food index
        int foodIndex = -1;
        Food[] foods = customers[customerIndex].getCart().getDinner().getFoods();
        int i =0;
        boolean flag = true;
        while(i<foods.length && flag) {
            if (foods[i].getId() == foodId) {
                foodIndex = i;
                flag = false;
            }
            i++;
        }

        //setup customer details
        foods[foodIndex].setAvailable(false);
        customers[customerIndex].getCart().getDinner().setFoods(foods);

    }
    //canceling a drink order in dinner
    public void cancelDrinkOrder_dinner(int customerId,int drinkId) {
        //finding customer index
        int customerIndex = -1;
        for (int i = 0; i < customers.length; i++) {
            if (customerId == customers[i].getCustomerId()) {
                customerIndex = i;
                break;
            }
        }

        //finding food index
        int drinkIndex = -1;
        Drink[] drinks = customers[customerIndex].getCart().getDinner().getDrinks();
        int i =0;
        boolean flag = true;
        while(i<drinks.length && flag) {
            if (drinks[i].getId() == drinkId) {
                drinkIndex = i;
                flag = false;
            }
            i++;
        }

        //setup customer details
        drinks[drinkIndex].setAvailable(false);
        customers[customerIndex].getCart().getDinner().setDrinks(drinks);


    }


    //is selected food or drink available in dinner
    public boolean isOrderAvailable_inDinner(int orderId) {
        for (Food food:dinner.getFoods()) {
            if (food.getId() == orderId)
                return true;
        }

        for (Drink drink:dinner.getDrinks()) {
            if (drink.getId() == orderId)
                return true;
        }

        return false;
    }

    //is selected food or drink available in launch
    public boolean isOrderAvailable_inLaunch(int orderId) {
        for (Food food:launch.getFoods()) {
            if (food.getId() == orderId)
                return true;
        }

        for (Drink drink:launch.getDrinks()) {
            if (drink.getId() == orderId)
                return true;
        }

        return false;
    }

    //checking is there this user or not
    public Customer getCustomer(int customerId) {
        for (Customer customer:customers) {
            if (customer.getCustomerId() == customerId)
                return customer;
        }

        return null;
    }

    public Food getFoodFromLaunch(int foodId) {
        for (Food food: launch.getFoods()) {
            if (food.getId() == foodId)
                return food;
        }
        return null;
    }

    public Drink getDrinkFromLaunch(int drinkId) {
        for (Drink drink:launch.getDrinks()) {
            if (drink.getId() == drinkId)
                return drink;
        }
        return null;
    }

    public Food getFoodFromDinner(int foodId) {
        for (Food food: dinner.getFoods()) {
            if (food.getId() == foodId)
                return food;
        }
        return null;
    }

    public Drink getDrinkFromDinner(int drinkId) {
        for (Drink drink:dinner.getDrinks()) {
            if (drink.getId() == drinkId)
                return drink;
        }
        return null;
    }

    public Launch getLaunch() {
        return launch;
    }

    public Dinner getDinner() {
        return dinner;
    }
}
