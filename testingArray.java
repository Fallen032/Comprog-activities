import java.util.Scanner;

public class testingArray{
   int [] arr;
   int size , index , count;
   static Scanner input = new Scanner(System.in);
   
   public testingArray(int array) {
      size = array;
      arr = new int[size];
      index = -1;
      count = 0;
      int value;
   }
   
   boolean isFull() {return count >= size;}
   boolean isEmpty() {return count == 0;}
   
   public void Add() {
      while(!isFull()){
         
         System.out.print("Enter value to add: ");
          int value = 0;
        if (input.hasNextInt()) {
            value = input.nextInt();
        }
        int[] arr = new int[value];
        for (int i = 0; i < count ; i++) {
            if (input.hasNextInt()) {
                count++;
            }
        }
      }
      if(isFull()) {
         
         System.out.println("Array is Full");
      }
   }
   
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
            System.out.println("index " + index + "was removed! ");
         }
      }
   }
   
   public void search () {
      if(isEmpty()) {
      }else {
         System.out.print("Enter index to search: ");
         int scanIndex = input.nextInt();
         
         boolean found = false;
         
         for(int i = 0 ; i < count ; i++) {
            if(arr[i] == scanIndex) {
               System.out.println("Value: " + scanIndex + "Index: " + i);
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
            for(int i = 0 ; i < count - 1 ; i++){
               for(int j = 0; j < count - i - 1; j++){
                  if(arr[j] > arr[j + 1]) {
                     int temp = arr[j];
                     arr[j] = arr[j + 1];
                     arr[j + 1] = temp;
                  }
               }
            }
            System.out.println("Array is sorted in Ascending order succesfully");
         }else if(choices == 2) {
            for(int i = 0 ; i < count - 1; i++){
               for(int j = 0; j < count - i - 1; j++) {
                  if(arr[j] < arr[j + 1]) {
                     int temp = arr[j];
                     arr[j] = arr[j + 1];
                     arr[j + 1] = temp;
                  }
               }
            }
            System.out.println("Array is sorted in Descending order succsessfully");
         } else{
            System.out.println("Invalid input");
         }
      }
   }
    public void edit () {

        if (isEmpty()) {
            System.out.println("Array is Empty!");
        } else {
            System.out.println("Enter Index to Edit: ");
            int editIndex = input.nextInt();

            if (editIndex < 0 || editIndex >= count) {
                System.out.println("Invalid Index!");
            } else {
                System.out.println("Enter new Value for:  [" + editIndex + "]");
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

        System.out.print("Enter Array Size: ");
        int initSize = input.nextInt();
        testingArray array = new testingArray(initSize);

        while (true) {

            System.out.println("1 - Add     2 - View");
            System.out.println("3 - Remove  4 - Search");
            System.out.println("5 - Sort    6 - Edit");
            System.out.println("7 - Count   8 - Resize");
            System.out.println("9 - Exit");
            System.out.print
            ("choice: ");

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


