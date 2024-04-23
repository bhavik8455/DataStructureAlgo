
package com.mycompany.aoa;
import java.util.Scanner;


public class SelectionSort {
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of array");
        int size = sc.nextInt();
        int[] arr = new int[size];
        
        System.out.println("Enter the element in array");
        for (int i = 0; i <arr.length; i++) {
            arr[i] = sc.nextInt();
            
        }
         for (int i = 0; i <arr.length; i++) {
             System.out.print(" "+arr[i]);
            
        }
        
        
        selection(arr);
    }
    public static void selection(int[] arr){
        int i ,j , k;
        
        for (i = 0; i < arr.length-1; i++) {
            j=i;
            
            for(k=i+1;k<arr.length;k++){
                if(arr[k]<arr[j]){
                    j = k;
                }
            
            
        }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        
    }
       System.out.println("\nThe array after Selection sort is :");
         for (i = 0; i <arr.length; i++) {
             System.out.print(" "+arr[i]);
            
        }
        
    
}

}