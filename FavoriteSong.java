import java.util.Scanner;

public class FavoriteSong {
   public static void main(String[]args) {
   
   Scanner input = new Scanner(System.in);
   
   while(true) {
   System.out.print("Enter the title of the song that you want: ");
   String display = input.nextLine();
  
   
   switch(display){
   
   case "All of me":
   System.out.println("What would I do without your smart mouth?");
   System.out.println("Drawing me in, and you kicking me out");
   System.out.println("You've got my head spinning, no kidding, I can't pin you down");
   System.out.println("What's going on in that beautiful mind?");
   break;
   
   case "Grenade":
   System.out.print("Easy come, easy go, that's just how you live, oh");
   System.out.print("Take, take, take it all, but you never give");
   System.out.print("Shoulda known you was trouble from the first kiss");
   System.out.print("Had your eyes wide open");
   break;
   
   case "Can you feel my heart":
   System.out.println("Can you hear the silence?");
   System.out.println("Can you see the dark?");
   System.out.println("Can you fix the broken?");
   System.out.println("Can you feel, can you feel my heart?");
   break;
   
   }
   if(display.equals("stop")) {
      break;
   }   
  }   
 }
}