import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class OnlineRetailSystem {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Product> Lists = new ArrayList<Product>();

    public static void main(String[] args) {

        int choices = 0;

        while (choices != 3) {
            System.out.print("Please put enter to Login: ");
            String Login = input.nextLine();
            if(Login.equals("enter")){
                
                System.out.print("Thank you for Loging in:\n\n" + 
                " To login as Admin please Press[1]\n If Costumer please press[2]\n If you're not an Admin/Costumer press [3] to exit\n Choice: ");
                
                choices = input.nextInt();
                if(choices == 1) {
            

                    System.out.print("\nEnter Admin ID: ");
                    int adminID = input.nextInt();
                    input.nextLine(); // to enable to input   Admin Username
                    System.out.print("Enter Admin Username: ");
                    String aUsername = input.nextLine();
                    System.out.print("Enter Admin Email: ");
                    String aEmail = input.nextLine();
                    System.out.print("Enter Department: ");
                    String department = input.nextLine();

                    Admin newAdmin = new Admin(adminID, aUsername, aEmail, department);
                    newAdmin.login();

                    int adminChoice;
                    do {
                       System.out.print("User is an ADMIN: \n\n How can we help you?\n\n " +
                         "If you want to add Product press[1]\n If you want to remove Product press[2]\n If you want to Manage inventory press[3]\n "+
                         "If you want to display Product List press[4]\n If you want to Logout press[5]\n Choice: ");
                        adminChoice = input.nextInt();

                        switch (adminChoice) {
                            case 1:
                                newAdmin.addProduct(Lists,input);
                            break;
                            case 2:
                                newAdmin.removeProduct(Lists, input);
                            break;
                            case 3:
                                newAdmin.manageInventory(Lists, input);
                            break;
                            case 4:
                                newAdmin.showList(Lists);
                            break;
                        }

                    } while (adminChoice != 5);
                    newAdmin.logout();
            }if(choices == 2) {
                System.out.print("\nEnter Customer ID: ");
                    int customerID = input.nextInt();
                    input.nextLine(); // to enable to input   Costumer Username
                    System.out.print("Enter Customer Username: ");
                    String cUsername = input.nextLine();
                    System.out.print("Enter Customer Email: ");
                    String cEmail = input.nextLine();
                    System.out.print("Enter Customer Address: ");
                    String address = input.nextLine();

                    Customer newCustomer = new Customer(customerID, cUsername, cEmail, address);
                    newCustomer.login();
                    
                    int customerchoices;
                    do {
                        System.out.print("Customer:\nIf you want to place order press[1]\nIf you want to view order history press[2]\n" + 
                                        "If you want to logout please press[3]\nchoice: ");
                        customerchoices = input.nextInt();
                        switch(customerchoices) {
                            case 1:
                                newCustomer.showList(Lists);
                                newCustomer.placeOrder(Lists, input);
                            break;
                            case 2:
                                newCustomer.viewOrderHistory();
                            break;
                        }
                        
                    } while (customerchoices != 3);
                break; 
            }
              
        }
    }   input.close();
            
    }
}

class User {
    private static int userID;
    private static String email;
    private static String username;
    
    User (int userID, String username, String email) {
        this.userID = userID;
        this.username = username;
        this.email = email;
    }
    
    // setting getter
    public static String getUsername(){
    	return username;
    }
    
    public static void login() {
        System.out.println("\nWelcome " + username);
    }
    
    public static void logout() {
        System.out.println("Logged out as " + username);
    }
}

/* 
    Admin has the ability to add, remove, and alter stock or product prices.
*/

class Admin extends User {
    private static String department;
    
    Admin (int _adminID, String _username, String _email, String _Department) {
        super(_adminID, _username, _email);
        this.department = department;
    }

    public static void addProduct(ArrayList<Product> Lists,Scanner input) {
        
        System.out.print("\nEnter Product ID: ");
        int productID = input.nextInt();
        System.out.print("Enter Price: ");
        int price = input.nextInt();
        System.out.print("Enter Stock Quantity: ");
        int quantity = input.nextInt();
        input.nextLine(); // catch the next line character
        System.out.print("Enter Product Name: ");
        String productName = input.nextLine();

        Product newProduct = new Product(productID, price, quantity, productName);//variables in this part must be the same with the input variable if not then it will display an error
        Lists.add(newProduct);
        
        System.out.println("\nProduct Added");
    }
    
    public static void removeProduct(ArrayList<Product> Lists, Scanner input) {
        
        if (Lists.isEmpty()) {
            System.out.println("No product yet, nothing to remove.");
            return;
        } 
        
        System.out.print("Enter index of product to remove:" + 
                           " 0 -> " + (Lists.size() - 1) + "\nIndex: ");
        int index = input.nextInt();

        if (index >= 0 && index < Lists.size()) {
            Lists.remove(index);
        } else {
            System.out.println("Invalid index, no product removed.");
        }
        
    }

    public static void showList (ArrayList<Product> Lists) {
        if (Lists.isEmpty()) {
           System.out.println("there are no Products added or to be removed..");
           return;
        }
		
		System.out.println("-------- PRODUCT LIST ----------\n");
        for (int i = 0; i < Lists.size(); i++) {
            Product temp = Lists.get(i);
            System.out.println(i + ". Product Name: " + temp.getName() + 
                               "\n   Product ID: " + temp.getProductID() + 
                               "\n   Product Quantity: " + temp.getStock() + 
                               "\n   Product Price: " + temp.getPrice() + "\n");
        }
    }
    
    public static void manageInventory(ArrayList<Product> Lists, Scanner in) {

        if (Lists.isEmpty()) {
        	System.out.println("there are no Products added or to be removed..");
               return;
        }
        
        Product temp = Lists.get(0); // Initialize as temp product
        int choices = 0;	

        do{
        	showList(Lists);
        	
        	System.out.print("\nINVENTORY:\nIf you want to update Product price press[1]\nIf you want to update Stock press[2]\n" + 
                             "If you want to exit please press[3]\nChoice: ");
        	choices = in.nextInt();

            if (choices == 3 ) {
                return;
            }

        	System.out.print("Select Product to update: 0 -> " + (Lists.size() - 1) + "\nIndex: ");
        	int index = in.nextInt();
        	
        	if (index == 0) {
        		temp = Lists.get(0);
        	} else {
        		for (int i = 1; i <= index; i++) {
            		temp = Lists.get(i);
        		}
        	}
			
        	switch (choices) {
                case 1:
                	System.out.print("\nOld price: " + temp.getPrice() + "\nEnter new price: ");
                	int newPrice = in.nextInt();
                    temp.updatePrice(newPrice, in);
                break;
                case 2:
                	System.out.println("\nOld Stock: " + temp.getStock() + "\nEnter new stock: ");
                	int newStock = in.nextInt();
                    temp.updateStock(newStock, in);
                break;
           
            }
        } while (choices != 3);
        
    }
}

/* 
    Object representation of a product which have methods to update the price and stock
*/

class Product {
    private int productID, price, stockQuantity;
    private String name;

    Product (int productID, int price, int stockQuantity, String name) {
        this.productID = productID;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.name = name;
    }
    
    // GETTER 
    public String getName() {
    	return name;
    }
    
    public int getProductID() {
    	return productID;
    }
    
    public int getPrice() {
    	return price;
    }
    
    public int getStock() {
    	return stockQuantity;
    }
    
    // SETTER
    public void setPrice(int newPrice) {
    	this.price = newPrice;
    }
    
    public void setStock (int newStock) {
    	this.stockQuantity = newStock;
    }
    
    // Product Methods

    public void updatePrice(int newPrice, Scanner input) {
        setPrice(newPrice);
        System.out.println("Price has been updated");
    }

    public void updateStock (int newStock, Scanner input) {
        setStock(newStock);
        System.out.println("Stock has been updated");
    }
}

/* 
    Customer can place an order and view its order history.
*/

class Customer extends User {
    private String address;
    private ArrayList<Order> orderList = new ArrayList<>();

    Customer (int customerID, String username, String email, String address) {
        super(customerID, username, email);
        this.address = address;
    }
    
    public void showList (ArrayList<Product> Lists) {
        if (Lists.isEmpty()) {
             System.out.println("there are no Products added or to be removed..");
               return;
        }
		
		System.out.println("--------- PRODUCT LIST ----------\n");
        for (int i = 0; i < Lists.size(); i++) {
            Product temp = Lists.get(i);
            System.out.println(i + ". Product Name: " + temp.getName() + 
                               "\n   Product ID: " + temp.getProductID() + 
                               "\n   Product Quantity: " + temp.getStock() + 
                               "\n   Product Price: " + temp.getPrice() + "\n");
        }
        System.out.println("==================================\n");
    }

    public void placeOrder (ArrayList<Product> Lists, Scanner in) {
        System.out.print("Enter the product number you want to purchase: ");
        int choice = in.nextInt();

        if (choice >= 0 && choice < Lists.size()) {
            Product chosenProduct = Lists.get(choice);

            System.out.print("Enter the quantity of products you want to purchase: ");
            int prodQuantity = in.nextInt();

            if (prodQuantity <= 0) {
                System.out.println("Invalid quantity. Order not placed.");
                return;
            }

            if (chosenProduct.getStock() < prodQuantity) {
                System.out.println("Insufficient stock. Order not placed.");
                return;
            }

            Order newOrder = new Order(chosenProduct, prodQuantity);
            newOrder.calculateTotalAmount();
            orderList.add(newOrder);
            System.out.println("Order placed successfully.");
        }
    }
    
    public void viewOrderHistory () {
        if (orderList.isEmpty()) {
            System.out.println("No order history available.");
            return;
        }
        
        System.out.println("------- ORDER HISTORY -------\n");
        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            System.out.println("Order ID: " + order.getOrderID());
            System.out.println("Order Date: " + order.getOrderDate());
            System.out.println("Total Amount: $" + order.getTotalAmount());

            System.out.println("Ordered Products:");
            ArrayList<Product> orderedProducts = order.getOrderedProducts();
            for (int j = 0; j < orderedProducts.size(); j++) {
                Product product = orderedProducts.get(j);
                System.out.println("Product Name: " + product.getName());
                System.out.println("Quantity: " + order.getOrderedQuantities().get(j));
            }

            System.out.println("----------------------------------");
        }
        System.out.println("==================================\n");
    }
}

class Order {
    private int orderID, totalAmount;
    private LocalDate orderDate;
    private ArrayList<Product> orderedProducts = new ArrayList<>();
    private ArrayList<Integer> orderedQuantities = new ArrayList<>();

    Order(Product product, int quantity) {
        this.orderID = orderID++;
        this.orderDate = LocalDate.now();
        addProductToOrder(product, quantity);
    }

    public int getOrderID() {
        return orderID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public ArrayList<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public ArrayList<Integer> getOrderedQuantities() {
        return orderedQuantities;
    }

    public void addProductToOrder(Product product, int quantity) {
        orderedProducts.add(product);
        orderedQuantities.add(quantity);
    }

    public void calculateTotalAmount() {
        totalAmount = 0;
        for (int i = 0; i < orderedProducts.size(); i++) {
            totalAmount += orderedProducts.get(i).getPrice() * orderedQuantities.get(i);
        }
    }

}
