import java.util.Scanner;
public class Equation{
   public static void main(String[]args){
      Scanner input = new Scanner(System.in);
      
     System.out.println("Enter first fraction in a / b form: ");
        String x = input.nextLine();

        System.out.println("Enter operation: ");
        char z = input.next().charAt(0);

        System.out.println("Enter second fraction in c / d form: ");
        input.nextLine();
        String y = input.nextLine();


   }
}