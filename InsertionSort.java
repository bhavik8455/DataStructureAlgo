
package com.mycompany.aoa;
import java.util.Scanner;
public class InsertionSort {

    public static void main(String[] args) {
        //int[] arr = new int[]
        Scanner obj = new Scanner(System.in);
        
        System.err.println("Enter the NO. of elements");
        int n = obj.nextInt();
        int[] a = new int[n];
        System.out.println("enter the array: ");
        for(int i = 0 ; i<a.length;i++){
            a[i] = obj.nextInt();
        }
         for (int j = 0; j < a.length; j++) {
            System.out.print(" "+a[j]);
            
        }
        insertionSort(a);
        
    }
    
    public static void insertionSort(int[] a){
        int key,i;
        
        
        for(int j=1; j<a.length;j++){
            key = a[j];
            i = j-1;
            
            while(i>=0 && key<a[i]){
                a[i+1]=a[i];
                i= i-1;
            }
            
            a[i+1] = key;
            
        }
        System.out.println("\nThe array after insertion sort is :");
        for (int j = 0; j < a.length; j++) {
            System.out.print(" "+a[j]);
            
        }
        
    }
    
    
}
