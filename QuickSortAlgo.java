
package com.mycompany.aoa;
import java.util.Scanner;


public class QuickSortAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of array:");
        int size = sc.nextInt();
        int[] arr = new int[size];
        
        System.out.println("Enter the elements : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
            
        }
        
        QuickSort(arr,0,size-1);
        System.out.println("After Quick Sort");
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
            
        }
        
    }
    
    public static void QuickSort(int[] arr ,int low ,int  high){
       if(low<high){
            int pivot = partition(arr,low,high);
            QuickSort(arr, low, pivot);
            QuickSort(arr, pivot+1, high);
       }
        
        
    }
    
    public static int partition(int arr[] , int lb , int ub){
       int  x = arr[lb];
        int down = lb;
        int  up = ub;
        
        while (down<up) {
            while(down<up && arr[down] <= x){
                down += 1;
            }
            while (arr[up]>x) {
                up = up -1;
                
            }
            if(down<up){
                int temp = arr[down];
                arr[down] = arr[up];
                arr[up] = temp;
            }
            
        }
        arr[lb] =arr[up];
        arr[up] = x;
        return up;
        
      
    }
    
}
