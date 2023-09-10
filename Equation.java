import java.util.Scanner;
public class Equation
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int x,y;


        System.out.print("Enter first variable: ");
        x = input.nextInt();

        System.out.print("Enter operation: ");
        char z = input.next().charAt(0); //allowing characters to be used in the switch case statement by converting char to int

        System.out.print("Enter second variable: ");
        y = input.nextInt();

     
        int answer = 0;
        switch (z)
        {
            case '+':
                answer = x + y;
                break; 
            case '-':
                answer = x - y;
                break;
            case '*':
                answer = x * y; 
                break;
            case '/':
                answer = x / y;
                break;
            default:
                System.out.println("ERROR");
                break;              
        }
        System.out.println("Answer = " + answer);       
    }
}
