package Pizza_Order;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        float cost = 0.0F;
        float totalBill = 0.0F;
        float discount = 0.1F;
        float discountAmount = 0.0F;
        float totalPizzaPrice = 0.0F;
        float totalGarlicBreadPrice = 0.0F;
        float totalBeveragePrice = 0.0F;
        String text = "Do you want to continue ordering...(Yes-1/No-0): ";
        int noOfPizzasOrdered = 0;
        int pizzaSize = 0;
        int noOfGarlicBreadOrdered = 0;
        int noOfBeveragesOrdered = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Your Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Your Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter Your Address: ");
        String address = scanner.nextLine();
        System.out.println("Enter Your Phone Number: ");
        long phone = scanner.nextLong();

        Main main = new Main(); // Create an object of the Main class to call non-static methods

        do {
            main.displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter number of Pizzas: ");
                    noOfPizzasOrdered = scanner.nextInt();
                    System.out.println("Enter the Pizza Size: ");
                    pizzaSize = scanner.nextInt();
                    System.out.println(text);
                    totalPizzaPrice = main.calculatePriceOfPizza(noOfPizzasOrdered, main.getPriceOfPizzaBasedOnSize(pizzaSize, cost));
                    break;
                case 2:
                    System.out.println("Enter number of Garlic Bread you ordered: ");
                    noOfGarlicBreadOrdered = scanner.nextInt();
                    System.out.println(text);
                    totalGarlicBreadPrice = main.calculatePriceOfGarlicBread(noOfGarlicBreadOrdered, main.getPriceOfGarlicBread());
                    break;
                case 3:
                    System.out.println("Enter number of Beverages you ordered: ");
                    noOfBeveragesOrdered = scanner.nextInt();
                    System.out.println(text);
                    totalBeveragePrice = main.calculatePriceOfBeverage(noOfBeveragesOrdered, main.getPriceOfBeverage());
            }
        } while (scanner.nextInt() != 0);

        totalBill = main.calculateTotalBill(totalPizzaPrice, totalGarlicBreadPrice, totalBeveragePrice);
        float discountBill = main.calculateDiscountAndReturnBillAmount(totalBill, discount);

        main.displayCustomerDetails(name, email, phone, address);
        main.displayOrderDetails(noOfPizzasOrdered, noOfGarlicBreadOrdered, noOfBeveragesOrdered, pizzaSize, totalBill);

        if (totalBill > 50.0F) {
            System.out.println("The Discounted Bill Amount is : $" + discountBill);
        } else {
            System.out.println("No Discount on bill");
        }
    }

    // Display menu
    public void displayMenu() {
        System.out.println("Select the items to order \nSl No   Item Category");
        System.out.println("--------------------------------------------------");
        System.out.println("1) Pizza \n     Price of One Regular Pizza : $9.99\n     Price of One Medium Pizza : $11.99\n     Price of One Large Pizza  : $13.99");
        System.out.println("2) Garlic Bread \n     Price of One Garlic Bread : $5.99");
        System.out.println("3) Beverages \n     Price of One Beverage     : $1.99");
        System.out.println("Enter 1 for Pizza, 2 for Garlic Bread and 3 for Beverages");
    }

    public float getPriceOfPizzaBasedOnSize(int size, float cost) {
        if (size == 1) {
            cost = 9.99F;
        } else if (size == 2) {
            cost = 11.99F;
        } else if (size == 3) {
            cost = 13.99F;
        }
        return cost;
    }

    public float getPriceOfGarlicBread() {
        return 5.99F;
    }

    public float getPriceOfBeverage() {
        return 1.99F;
    }

    public float calculatePriceOfPizza(int noOfPizza, float priceOfPizza) {
        return noOfPizza * priceOfPizza;
    }

    public float calculatePriceOfGarlicBread(int noOfGarlicBread, float priceOfGarlicBread) {
        return noOfGarlicBread * priceOfGarlicBread;
    }

    public float calculatePriceOfBeverage(int noOfBeverage, float priceOfBeverage) {
        return noOfBeverage * priceOfBeverage;
    }

    public float calculateTotalBill(float totalPizzaPrice, float totalGarlicBreadPrice, float totalBeveragePrice) {
        return totalPizzaPrice + totalGarlicBreadPrice + totalBeveragePrice;
    }

    public float calculateDiscountAndReturnBillAmount(float totalBillAmount, float discount) {
        return totalBillAmount > 50.0 ? totalBillAmount - discount * totalBillAmount : totalBillAmount;
    }

    public void displayOrderDetails(int noOfPizza, int noOfGarlicBread, int noOfBeverages, int size, float totalPrice) {
        System.out.println("Order Details \n----------------------");
        System.out.println("The number of pizza ordered        : " + noOfPizza);
        System.out.println("The number of garlic bread ordered : " + noOfGarlicBread);
        System.out.println("The number of beverages ordered    : " + noOfBeverages);
        System.out.println("------------------------------------------------------------------");
        System.out.println("The total Bill Amount is           : $" + totalPrice);
    }

    public void displayCustomerDetails(String name, String email, long phoneNo, String address) {
        System.out.println("Customer Details\n-------------------------");
        System.out.println("Name of the Customer is       : " + name);
        System.out.println("Email of the Customer is      : " + email);
        System.out.println("Contact No of the Customer is : " + phoneNo);
        System.out.println("Address of the Customer is    : " + address);
        System.out.println("------------------------------------------------------------------");
    }
}
