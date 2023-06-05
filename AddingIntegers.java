import java.util.Scanner;
public class AddingIntegers
{
   public static void main(String[]args)
   {
      Scanner input = new Scanner(System.in);
      
      System.out.print("Enter first integer(enter 0 to quit): ");
      int num = input.nextInt();
      
      if(num == 0)
      {
         System.out.print("No integers were entered \nbye");
      }
      else
      {
         int sum = num;
         while(true)
         {
            System.out.print("Enter first integer(enter 0 to quit): ");
            num = input.nextInt();
            if(num == 0)
            {
               System.out.println("Sum of the integers: " + sum + "\nbye");
               break;
            }
            sum += num;
         }
      }
   }  
}
