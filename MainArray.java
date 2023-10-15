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
         }
      }
   }
   // to search for the index in the array
   public void search () {
   
      if(isEmpty()) {
      }else {
      
         System.out.print("Enter index to search: ");
         int scanIndex = input.nextInt();
         
         boolean found = false;
         
         for(int i = 0 ; i < count ; i++) {
            if(arr[i] == scanIndex) { // if the scanindex contains the value of the array it will display value of the index that the user has entered
               System.out.println("Value: " + scanIndex + " Index: " + i);
               found = true;
               break;
            }
         }
         
         if(!found) {
            System.out.println("Value: " + scanIndex + "was not found");
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
        boolean validInput = false;
        int initSize = 0;
        
        while (!validInput) {
            try {
                System.out.print("Enter Array Size: ");
                initSize = input.nextInt();
                validInput = true; //This line allows the program to move forward instead of inputting the array size again and again
            } catch (Exception e) { // This line will detect erroneous input and request the user to enter the array size again rather than ending the program.
                System.out.print("Error: Invalid input\nPlease enter a valid array size: ");
                input.next(); // Consume the invalid input to prevent an infinite loop
            }
        }
          MainArray array = new MainArray(initSize);
        
            while (true) {
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
            }
        }
    }




