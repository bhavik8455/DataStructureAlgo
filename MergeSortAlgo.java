
package com.mycompany.aoa;
import java.util.Scanner;


public class MergeSortAlgo {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the element in the array");
        for(int i = 0 ; i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
         for (int j = 0; j < arr.length; j++) {
            System.out.print(" "+arr[j]);
            
        }
         Merge_Sort(arr,0,size-1);
         System.out.println("The sorted array is :");
        for(int k=0;k<arr.length;k++){
            System.out.print(" " + arr[k]);
          
      }
    }
    
    public static void Merge_Sort(int[] arr ,int low ,int high){
        if(low<high){
          int  mid = (low+high)/2;
            Merge_Sort(arr, low, mid);
            Merge_Sort(arr, mid+1, high);
            Merge(arr,low,mid,high);
            
        }
        
    }
    
    
    public static void Merge(int[] arr,int low , int mid , int high){
        int i,h,k ,j;
        i = low;
        h = low;
        j = mid+1;
        int[] bbr = new int[arr.length];
        
        while (h <= mid && j<= high) { 
            
            if(arr[h]<arr[j]){
                bbr[i] = arr[h];
                h = h + 1;
                
            }else{
                bbr[i] = arr[j];
                j = j + 1;
                
            }
            i = i + 1;
        }
            if(h>mid){
                for(k=j;k<=high;k++){
                    bbr[i] = arr[k];
                    i = i + 1;
                    
                }
            }else{
                 for(k=h;k<=mid;k++){
                    bbr[i] = arr[k];
                    i = i + 1;
                
            }
            
        }
        
        
    
      for(k=low;k<=high;k++){
          arr[k] = bbr[k];
          
      } 
      
         
    }
    
    
}
