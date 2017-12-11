import java.util.Arrays;

public class Sorts{

  public static void main(String[]args){
    //int[] a = {64, 25, 12, 22, 11};
    //int[] a = {34, 25, 12, 22, 12};
    //int[] a = {6, 25, -12, 22, 1, 32, 22};
    //int[] a = {-5, -25, -12, -15, 1};
    //int[] a = {1, 1, 0, 1, 0, 0};
    int[] a = {1932, -25, 12, 12, 3};
    //int[] a = {4, 23, -12, 0, 11, 1, 4, 99, 32, 14, 19, 23};

    System.out.println(Arrays.toString(a));
    insertionSort(a);
    System.out.println(Arrays.toString(a));
  }


  public static String name(){
    return "10.Zheng.George"; 
  }


  public static void selectionSort(int[] data){  
    for (int i=0; i<data.length-1; i++) {
        for (int j=i+1; j<data.length; j++) {
            if (data[j] < data[i]) {
                int storage = data[i];
                data[i] = data[j];
                data[j] = storage;
            }
        }
    }
  }

  public static void insertionSort(int[] data){ 
    int j = 1; 
    while (j <= data.length) {  
        int current=data[j];  
        int i = j-1;  
        while (i>-1 && data[i]>current) {  
            data[i+1] = data[i];  
            i--;  
        }  
        data[i+1] = current;  
        j++;
    }  
}
    public static void bubbleSort(int arr[]){
        for(int i = 0; i <arr.length-1; i++)
            for(int j = 0; j<arr.length-i-1; j++)
                if (arr[j+1] <= arr[j]){
                    int holder = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = holder;
                }
      }
























}