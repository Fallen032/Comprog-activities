import java.util.Scanner;
public class Equation
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int a,b,c,d,e,f;


        System.out.print("Enter number: ");
        a = input.nextInt();
        System.out.print("Enter number: ");
        b = input.nextInt();
        System.out.print("Enter number: ");
        c = input.nextInt();

        System.out.print("Enter operation: ");
        char z = input.next().charAt(0); //allowing characters to be used in the switch case statement by converting char to int

        System.out.print("Enter a number: ");
        d = input.nextInt();
        System.out.print("Enter a number: ");
        e = input.nextInt();
        System.out.print("Enter a number: ");
        f = input.nextInt();

     
        int answer = 0;
        switch (z)
        {
            case '+':
                answer = a + b + c + d + e + f;
                break; 
            case '-':
                answer = a - b - c - d - e - f;
                break;
            case '*':
                answer = a * b * c * d * e * f;
                break;
            case '/':
                answer = a / b / c / d / e / f;
                break;
            default:
                System.out.println("ERROR");
                break;              
        }
        System.out.println("Answer = " + answer);       
    }
}
