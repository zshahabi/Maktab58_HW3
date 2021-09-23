package ir.maktab;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    //the usage is in methods : getNumber and getYesOrNo and getString and getGender
    private Scanner scanner;
    //all app operations
    private Restaurant restaurant;

    public static void main(String[] args) {

        //initialize variables
        Main main = new Main();
        main.scanner    = new Scanner(System.in);
        main.restaurant = new Restaurant();

        //main menu
        main.showWelcomeMenu();

    }

    //showing main menu : called in main method
    private void showWelcomeMenu() {

        System.out.println("***Welcome to restaurant system***\n" + "enter the number ");
        String message = "1) login as manager\n" +
                "2) login as customer\n" +
                "3) Exit\n";
        int choiceLogin = getNumber(message,"[123]*","your value is not ok . pleas enter your number between 1 to 3 ");

        switch (choiceLogin) {
            //login as manager
            case 1:
                System.out.println();
                String userName = getString("enter your user name : ","[a-zA-Z ]*","your name is invalid");

                String password = getString("enter your password ","[a-zA-Z0-9]*"
                        ,"your password format is invalid");

                boolean isSignOk = true;

                if (!userName.equals(Manager.USER_NAME)) {
                    System.out.println("your userName is inValid");
                    isSignOk = false;
                }
                if (!password.equals(Manager.PASSWORD)) {
                    System.out.println("your password is inValid ");
                    isSignOk = false;
                }

                //do manager work
                if (isSignOk) {
                    //show manager menu
                    showManagerMenu();
                }

                break;

            //login as customer
            case 2:
                //show customer menu
                showCustomerMenu();

                break;

            //exit
            case 3:
                System.out.println("your exit is successfully");
                break;

        }


    }

    //sowing manager menu after user choose manager in welcome menu
    private void showManagerMenu() {
        System.out.println("**Manager Menu***\n" + "enter the number ");
        String message = "1.add_to_dinner_menu\n" +
                "2.add_to_lunch_menu\n" +
                "3.Customer_info\n" +
                "4.Back_to_main_menu";
        int choiceLogin_managerMenu = getNumber(message,"[1234]*","your value is not ok . pleas enter your number between 1 to 4 ");

        switch (choiceLogin_managerMenu) {
            // 1) Add to dinner menu
            case 1:
                boolean doYouWantToEnterOtherFood = true;

                do {
                    int foodType_dinner = getNumber("enter your food type \n" + "1)food\n" + "2)drink", "[12]*", "your number is ont in range 1,2 ");

                    //setup message for showing to user
                    String foodOrDrinkName = "";
                    if (foodType_dinner == 1)
                        foodOrDrinkName = "food";
                    else
                        foodOrDrinkName = "drink";


                    int foodId_dinner = getNumber("enter "+foodOrDrinkName +" id :" ,"[0123456789]*","id must be number");
                    String foodName_dinner = getString("enter "+foodOrDrinkName+ " name :" ,"[a-zA-Z]*","your food name is invalid");
                    String foodPrice_dinner = getString("enter "+foodOrDrinkName+" price: ","[1234567890,]*","your price format is invalid")+"";
                    boolean foodAvailable_dinner = getYesOrNo("enter available "+foodOrDrinkName+" or not (yes,no)");


                    switch (foodType_dinner) {
                        //food
                        case 1:
                            //if food not available in restaurant dinner menu add it
                            if (restaurant.isOrderAvailable_inDinner(foodId_dinner)) {
                                System.out.println("sorry your food order is exists in restaurant dinner menu");
                            }
                            else {
                                //add food to menu
                                restaurant.addToDinnerMenu(new Food(foodId_dinner,foodPrice_dinner,foodOrDrinkName,foodAvailable_dinner));
                                System.out.println("your food is added to menu list ");
                            }
                            break;

                        //drink
                        case 2:
                            //if food not available in restaurant dinner menu add it
                            if (restaurant.isOrderAvailable_inDinner(foodId_dinner)) {
                                System.out.println("sorry your drink order is exists in restaurant dinner menu");

                            } else {
                                //add drink to menu
                                restaurant.addToDinnerMenu(new Drink(foodId_dinner, foodPrice_dinner, foodName_dinner, foodAvailable_dinner));
                                System.out.println("your drink is added to menu list ");
                            }
                            break;
                    }

                    //get from user that want to continue or not
                    doYouWantToEnterOtherFood =  getYesOrNo("do you want to order other food or drink ? (yes,no) ");


                }while (doYouWantToEnterOtherFood);

                showWelcomeMenu();

                break;

            // 2) Add to lunch menu
            case 2:

                do {
                    int foodType_launch = getNumber("enter your food type \n" + "1)food\n" + "2)drink", "[12]*", "your number is ont in range 1,2");

                    String foodOrDrinkName = "";
                    if (foodType_launch == 1)
                        foodOrDrinkName = "food";
                    else
                        foodOrDrinkName = "drink";


                    int foodId_launch = getNumber("enter "+foodOrDrinkName +" id :","[0123456789]*","id must be number");
                    String foodName_launch = getString("enter "+foodOrDrinkName+ " name :","[a-zA-Z]*","your food name is invalid");
                    String foodPrice_launch = getString("enter "+foodOrDrinkName+" price: ","[1234567890,]*","your price format is invalid");
                    boolean foodAvailable_launch = getYesOrNo("enter available "+foodOrDrinkName+" or not (yes,no) ");


                    switch (foodType_launch) {
                        //food
                        case 1:
                            //if food not available in restaurant launch menu add it
                            if (restaurant.isOrderAvailable_inLaunch(foodId_launch)) {
                                System.out.println("sorry your food order is exists in restaurant launch menu");
                            } else {
                                //add food to menu
                                restaurant.addToLaunchMenu(new Food(foodId_launch, foodPrice_launch, foodName_launch, foodAvailable_launch));
                                System.out.println("your food is added to menu list ");
                            }

                            break;

                        //drink
                        case 2:
                            //if food not available in restaurant launch menu add it
                            if (restaurant.isOrderAvailable_inLaunch(foodId_launch)) {
                                System.out.println("sorry your drink order is exists in restaurant launch menu");
                            } else {
                                restaurant.addToLaunchMenu(new Drink(foodId_launch, foodPrice_launch, foodName_launch, foodAvailable_launch));
                                System.out.println("your drink is added to menu list ");
                            }
                            break;
                    }

                    //get from user that want to continue or not
                    doYouWantToEnterOtherFood =  getYesOrNo("do you want to order other food or drink ? (yes,no) ");


                }while (doYouWantToEnterOtherFood);


                showWelcomeMenu();


                break;

            // 3) Customer info
            case 3:
                System.out.println("customer info : "+restaurant.getCustomersInfo());

                showWelcomeMenu();


                break;

            // 5) Back to main menu
            case 4:
                //return in welcome menu
                showWelcomeMenu();
                break;

        }

    }

    //showing customer menu after user choose customer in welcome menu
    private void showCustomerMenu() {
        String message = "1) Add new Order\n" +
                "2) Show Orders details\n" +
                "3) Cancel an order\n" +
                "4) Back to main menu\n";

        int number = getNumber(message, "[1234]*", "your number is not in range 1,2,3,4");




        switch (number) {
            //1) Add new Order
            case 1:
                Customer customer ;
                boolean haveAnyAccount = getYesOrNo("did you create account in this restaurant ? (yes,no)");
                if (haveAnyAccount) {
                    int customerId = getNumber("enter your id ","[0-9]*","your id format is inCorrect");
                    if (restaurant.getCustomer(customerId) != null) {
                        customer = restaurant.getCustomer(customerId);
                    } else {
                        System.out.println("your account didn't register . pleas create an account first");
                        customer = getCustomerInfo();
                        restaurant.addCustomer(customer);
                        System.out.println("your details : "+customer.toString());
                    }

                } else {
                    customer = getCustomerInfo();
                    restaurant.addCustomer(customer);
                    System.out.println("your details : "+customer.toString());
                }

                boolean wantToContinue = true;

                do {
                    int launchOrDinner = getNumber("1) launch\n2) dinner", "[12]*", "your input number hase to be 1 or 2");
                    // 1)launch
                    if (launchOrDinner == 1) {
                        int foodOrDrink = getNumber("1)Food \n2) Drink", "[12]*", "pleas enter 1 or 2");

                        switch (foodOrDrink)
                        {
                            //food
                            case 1 :
                                //print food list in launch
                                System.out.println(restaurant.getLaunch().getFoodsAsString());

                                int foodId = getNumber("enter your food id ","[0-9]*","your food id is inValid ");
                                if (restaurant.isOrderAvailable_inLaunch(foodId)){
                                    restaurant.addNewOrder_launch(restaurant.getFoodFromLaunch(foodId),customer.getCustomerId());
                                    System.out.println("your food add to your order list ");
                                } else {
                                    System.out.println("sorry this food is not available");
                                }

                                break;

                            //drink
                            case 2 :
                                //print drink list in launch
                                System.out.println(restaurant.getLaunch().getDrinksAsString());

                                int drinkId = getNumber("enter your drink id ","[0-9]*","your drink id is inValid ");
                                if (restaurant.isOrderAvailable_inLaunch(drinkId)){
                                    restaurant.addNewOrder_launch(restaurant.getDrinkFromLaunch(drinkId),customer.getCustomerId());
                                    System.out.println("your drink add to your order list ");
                                } else {
                                    System.out.println("sorry this drink is not available");
                                }

                                break;

                        }

                        // 2)dinner
                    } else {
                        int foodOrDrink = getNumber("1)Food \n2) Drink ", "[12]*", "pleas enter 1 or 2");
                        switch (foodOrDrink)
                        {
                            //food
                            case 1 :
                                //get foods for dinner in list
                                System.out.println(restaurant.getDinner().getFoodsAsString());

                                int foodId = getNumber("enter your food id ","[0-9]*","your food id is inValid ");
                                if (restaurant.isOrderAvailable_inDinner(foodId)){
                                    restaurant.addNewOrder_dinner(restaurant.getDrinkFromDinner(foodId),customer.getCustomerId());
                                    System.out.println("your food add to your order list ");
                                } else {
                                    System.out.println("sorry this food is not available");
                                }

                                break;

                            //drink
                            case 2 :
                                //get driks for dinner in list
                                System.out.println(restaurant.getDinner().getDrinksAsString());

                                int drinkId = getNumber("enter your drink id ","[0-9]*","your drink id is inValid ");
                                if (restaurant.isOrderAvailable_inDinner(drinkId)){
                                    restaurant.addNewOrder_dinner(restaurant.getDrinkFromDinner(drinkId),customer.getCustomerId());
                                    System.out.println("your drink add to your order list ");
                                } else {
                                    System.out.println("sorry this drink is not available");
                                }

                                break;

                        }

                    }

                    //ask from user that want to continue or not
                    wantToContinue = getYesOrNo("do you wanna continue ? (yes,no)");

                }while (wantToContinue);

                showWelcomeMenu();

                break;

            //2) Show Orders details
            case 2:

                int customerId = getNumber("enter your account id (customerId) ","[0-9]*","your id format is invalid ");
                String customerInfo = restaurant.showCustomerOrders(customerId);
                System.out.println(customerInfo);


                break;

            //3) Cancel an order
            case 3:
                int launchOrDinner = getNumber("1)launch \n2)dinner","[12]*","pleas enter your answer correctly");
                int foodOrDrink    = getNumber("1)food \n2)Drink","[12]*","enter your food or drink correctly 1 or 2 ");
                customerId = getNumber("enter your account id (customerId) ","[0-9]*","your id format is invalid");

                String foodOrDrinkText = foodOrDrink == 1 ? "food" : "drink";
                int foodDrinkId = getNumber("enter your "+foodOrDrinkText+" id ","[0-9]*","your "+foodOrDrinkText+" id format is invalid");

                //1) launch
                if (launchOrDinner == 1){
                    switch (foodOrDrink)
                    {
                        //1)food
                        case 1 :
                            restaurant.cancelFoodOrder_launch(customerId,foodDrinkId);
                            System.out.println("your order canceled");
                            break;

                        //drink
                        case 2 :
                            restaurant.cancelDrinkOrder_launch(customerId,foodDrinkId);
                            System.out.println("your order canceled");
                            break;
                    }
                }
                //2) dinner
                else{
                    switch (foodOrDrink)
                    {
                        //1)food
                        case 1 :
                            restaurant.cancelFoodOrder_dinner(customerId,foodDrinkId);
                            System.out.println("your order canceled");
                            break;

                        //drink
                        case 2 :
                            restaurant.cancelDrinkOrder_dinner(customerId,foodDrinkId);
                            System.out.println("your order canceled");
                            break;
                    }
                }

                break;

            //4) Back to main menu
            case 4:
                showWelcomeMenu();
                break;


        }


    }


    //get customer info
    public Customer getCustomerInfo() {
        System.out.println("enter your information : \n");

        String name = getString("name : ","[a-zA-Z]*","enter your name correctly");
        String family = getString("last name :","[a-zA-Z]*","pleas enter your last name correctly");
        String phoneNumber = getString("phone number :","[0-9,]*","pleas enter your phone number correctly");
        String gender = getGender();

        Launch launch = new Launch(new Food[0],new Drink[0]);
        Dinner dinner = new Dinner(new Food[0],new Drink[0]);
        Cart   cart   = new Cart(launch,dinner);

        return new Customer(name,family,phoneNumber,gender,cart);
    }


    //get Number from user
    private int getNumber(String message, String format, String errorMessage) {
        System.out.println(message);
        String getFromUser = scanner.next();

        boolean isInputOk = getFromUser.matches(format);
        if (!isInputOk) {
            System.out.println(errorMessage);
            return getNumber(message, format, errorMessage);
        }

        return Integer.parseInt(getFromUser);
    }

    //get yes or no : boolean
    private boolean getYesOrNo(String message) {

        System.out.println(message);
        String yesOrNo = scanner.next();

        if (yesOrNo.trim().toLowerCase(Locale.ROOT).equals("yes"))
            return true;
        else if (yesOrNo.trim().toLowerCase(Locale.ROOT).equals("no"))
            return false;
        else
            return getYesOrNo(message);
    }

    //get string with valid type
    private String getString(String message, String format, String errorMessage) {

        System.out.println(message);
        String valueFromUser = scanner.next();

        boolean isInputOk = valueFromUser.matches(format);

        if (!isInputOk) {
            System.out.println(errorMessage);
            return getString(message,format,errorMessage);
        }

        return valueFromUser;

    }

    //get gender of user : called in method customerMenu
    private String getGender() {

        System.out.println("your gender : (mail or female)");
        String gender = scanner.next();

        if (gender.trim().toLowerCase(Locale.ROOT).equals("mail") || gender.trim().toLowerCase(Locale.ROOT).equals("female"))
            return gender;

        System.out.println("enter your gender correctly");
        return getGender();

    }
}
