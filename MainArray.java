import java.util.Scanner;

public class MainArray{
   int [] arr;
   int size , index , count;
   static Scanner input = new Scanner(System.in);
   
   public MainArray(int array) {
      size = array;
      arr = new int[size];
      index = -1;
      count = 0;
   }
   
   boolean isFull() {
      
      return count >= size;
   }
   boolean isEmpty() {
   
      return count == 0;
   }
   
   public void Add() {
      while(true)
      {
         try{
            while(!isFull()){
      
         // let user enter value for each index of the array
         System.out.print("Enter value to add: ");
          int value = input.nextInt();
         
         if(isFull()) {
         
            System.out.println("Array is Full");
         }
            arr[++index] = value;
            count++;
      }
      if(isFull()) {
         
         System.out.println("Array is Full");
         break;
      }
       }catch (Exception e)  {
          System.out.println("Error: Invalid input, Enter proper array value ");
          input.next();          
       }
   }      
}
    //to view the value of the array that the user has entered
   public void view() {
   
      for(int i = 0; i < count; i++) {
        System.out.println("Array: " +  arr[i]);
      }
   }
   
   public void count() {
   
      System.out.println("Current size: " + count);
   }
   
   public void remove() {
   while(true) {
      try{
           if(isEmpty()) {
      
         System.out.println("Array is currently empty");
      } else {
      
         System.out.print("Enter index to remove: ");
         int index = input.nextInt();
         
         if(index < 0 || index >= count) {
            System.out.println("Invalid index number");
         } else {
         
            for(int i = index; i < count - 1; i++) {
               arr[i] = arr[i + 1];
            }
            count--;
            System.out.println("index " + index + " was removed! ");
            break;
          }
       }
     }catch(Exception e) {
         System.out.println("Invalid index! ");
         input.next();
     }
   }      
  }
   public void search() {
    while (true) {
        try {
            if (isEmpty()) {
               // Handle case when the array is empty
            } else {
                System.out.print("Enter value to search: "); // Prompt for value instead of index
                int scanValue = input.nextInt();

                boolean found = false;

                for (int i = 0; i < count; i++) {
                    if (arr[i] == scanValue) { // Compare array element with user input value
                        System.out.println("Value: " + scanValue + " found at Index: " + i);
                        found = true;
                        break; // Break the loop once the value is found
                    }
                }

                if (!found) {
                    System.out.println("Value: " + scanValue + " was not found");
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid index ");
            input.next(); // Consume the invalid input to prevent an infinite loop
        }
    }
 }   
   public void sort() {
   
      if(isEmpty()) {
        System.out.println("Array is currently empty");
      }else {
         
         System.out.print("Choose an Option: (1) - Ascending order (2) - Descending order\n choice: ");
         int choices = input.nextInt();
         
         if(choices == 1) {
            //sorting the input array into ascending order
            for(int i = 0 ; i < count - 1 ; i++){
               for(int j = 0; j < count - i - 1; j++){
                  if(arr[j] > arr[j + 1]) {
                     int temp = arr[j];
                     arr[j] = arr[j + 1];
                     arr[j + 1] = temp;
                  }
               }
            }
            System.out.println("Array is sorted in Ascending order successfully");
         }else if(choices == 2) {
             //arranging the array into descending order
             for(int i = 0 ; i < count - 1; i++){
               for(int j = 0; j < count - i - 1; j++) {
                  if(arr[j] < arr[j + 1]) {
                     int temp = arr[j];
                     arr[j] = arr[j + 1];
                     arr[j + 1] = temp;
                  }
               }
            }
            System.out.println("Array is sorted in Descending order successfully");
         } else{
            System.out.println("Invalid input");
         }
      }
   }
    public void edit () {
    while(true){
      try{ 
         if (isEmpty()) {
        
            System.out.println("Array is Empty!");
        } else {
            System.out.print("Enter Index to Edit: ");
            int editIndex = input.nextInt();

            if (editIndex < 0 || editIndex >= count) {
            
                System.out.println("Invalid Index!");
            } else {
            
                System.out.print("Enter new Value for: [" + editIndex + "] ||| new value: ");
                int newValue = input.nextInt();
                
                arr[editIndex] = newValue;
                System.out.println("Element at index " + editIndex + " was changed to " + newValue);
                break;
            }
        }
      }catch (Exception e) {
         System.out.println("Invalid index to edit! ");
         input.next();
      }
    }    
   }
    public void arraySize () {

        System.out.print("Enter New Array Size: ");
        int newSize = input.nextInt();

        if (newSize < count) {
        
            System.out.println("Unable to Resize to a Smaller Size than the Current Number of Elements!");
        } else {
        
            int [] newArray = new int[newSize];
            System.arraycopy(arr, 0, newArray, 0, count);
            arr = newArray;
            size = newSize;
        }
    }

    public void exit () {

        System.out.println("Sucessfully Exited the Program!");
        System.exit(0);
   
    }

    public static void main (String [] args) {
        boolean validInput = true;
        int initSize = 0;
        while (validInput) {
            try {
                System.out.print("Enter Array Size: ");
                initSize = input.nextInt();       
                validInput = false; // it allows the program to move forward if the user inputs a integer instead of a string
            } catch (Exception e) { // This line will detect erroneous input and request the user to enter the array size again rather than ending the program.
                System.out.println("Error: Invalid input\nPlease enter a valid array size ");
                input.next(); // Consume the invalid input to prevent an infinite loop
            }
        }
          MainArray array = new MainArray(initSize);
        
            while (true) {
               try{
                System.out.println("1 - Add     2 - View");
                System.out.println("3 - Remove  4 - Search");
                System.out.println("5 - Sort    6 - Edit");
                System.out.println("7 - Count   8 - Resize");
                System.out.println("9 - Exit");
                System.out.print("choice: ");
    
                int choice = input.nextInt();
    
                switch (choice) {
                    case 1:
                    array.Add();
                    break;
                case 2:
                    array.view();
                    break;
                case 3:
                    array.remove();
                    break;
                case 4:
                    array.search();
                    break;
                case 5:
                    array.sort();
                    break;
                case 6:
                    array.edit();
                    break;
                case 7:
                    array.count();
                    break;
                case 8:
                    array.arraySize();
                    break;
                case 9:
                    array.exit();
                    break;
                }
              }catch (Exception e) {
                  System.out.println("Invalid choice!");
                  input.next();
              }
           }
        }
    }







