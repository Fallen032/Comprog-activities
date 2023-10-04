import java.util.Scanner;
import java.text.DecimalFormat;

public class MainMenu {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        DecimalFormat formatnum = new DecimalFormat("#.##"); 
        MainMenu menu = new MainMenu();
        boolean exit = false;

        while (!exit) {
            menu.displayMenu();
            String order = menu.getOrder(input);
            int quantity = menu.getQuantity(input);

            double total = menu.calculateTotal(order, quantity);
            System.out.println("\tTotal Price: Php " + total);
            

            System.out.print("\n\t Do you want to add some add ons with that order? (yes/no): ");
            String addOnChoice = input.next().toLowerCase().trim();
            if (addOnChoice.equals("yes")) {
                double addOnPrice = menu.handleAddOns(input);
                //adding the main menu total and the add on total
                total += addOnPrice;
                String adjustnumber = formatnum.format(total);//setting the decimal point for total
                System.out.println("\tTotal Price (including add-ons): Php " + adjustnumber );
                double totalAmountUSD = total * 0.017;
                String usdollars = formatnum.format(totalAmountUSD);//setting the decimal point for totalamountUSD
                System.out.println("\tTotal price Php " + adjustnumber + "  into US currency its $ " + usdollars);
            }
            //if user doesn't have any addons
             if(addOnChoice.equals("no")){
                double totalUS = total * 0.017;
                String adjust = formatnum.format(totalUS);//setting decimcal point for totalUS
                System.out.print("\n\tTotal price Php " + total + "  into US dollars its $" +  adjust); 
             }
                

            System.out.print("\n\tDo you want to place another order? (yes/no): ");
            String continueChoice = input.next().toLowerCase().trim();
            
            if (!continueChoice.equals("yes")) {
                exit = true;
                System.out.println("Thank you for your order!");
            }
        }
    }

    public void displayMenu() {
    
        System.out.println("\t ======MENU======");
        System.out.println("\t C1 - Php 100.00 "); 
        System.out.println("\t C2 - Php 150.00 ");
        System.out.println("\t C3 - Php 200.00 ");
    }
    // getting the order
    public String getOrder(Scanner input) {
    
        System.out.print("\tOrder: ");
        return input.next().toUpperCase().trim();
    }
    // getting the quantity of the order
    public int getQuantity(Scanner input) {
    
        System.out.print("\tHow many orders do you want? ");
        return input.nextInt();
    }
    //getting the total amount for the main menu
    public double calculateTotal(String order, int quantity) {
    
        double price = 0;
        switch (order) {
        
            case "C1":
                price = 100.00;
                break;
            case "C2":
                price = 150.00;
                break;
            case "C3":
                price = 200.00;
                break;
            default:
                System.out.println("\t Invalid Input");
        }
        return price * quantity;
    }
    // getting the total amount for addons
    public double handleAddOns(Scanner input) {
    
        System.out.println("\t ======ADD ONS====");
        System.out.println("\t R1 - Php 35.00 ");
        System.out.println("\t R2 - Php 50.00 ");
        System.out.print("\tChoice of add ons: ");
        String addOn = input.next().toUpperCase().trim();
        System.out.print("\tHow many orders of " + addOn + " do you want? ");
        int quantity = input.nextInt();

        double addOnPrice = 0;
        switch (addOn) {
            case "R1":
                addOnPrice = 35.00;
                break;
            case "R2":
                addOnPrice = 50.00;
                break;
            default:
                System.out.println("\t Invalid Add-On");
        }
        return addOnPrice * quantity;
    }
}
