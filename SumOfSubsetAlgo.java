
package com.mycompany.aoa;
import java.util.Scanner;
public class SumOfSubsetAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no, of Elements");
        int size = sc.nextInt();
        int[] arr = new int[size];
        int[] subset=  new int[arr.length];
       
        System.out.println("Enter the elements");
        for (int i = 0; i <arr.length; i++) {
            System.out.println("Elements "+(i+1)+":");
            arr[i] = sc.nextInt();
            
        }
        System.out.println("Enter the sum : ");
        int sum = sc.nextInt();
        
         SumSubsetutil(arr,sum,0,subset);
     
    }
  
    public static void SumSubsetutil(int arr[] , int sum ,int index, int subset[]){
        if(sum==0){
            System.out.println("the solution vector is ");
            for (int i = 0; i <subset.length; i++) {
                System.out.print(subset[i]+" ");
                
            }
            System.out.println("");
            return;
        }
        if(index==arr.length || sum<0){
            return;
        }
        subset[index]=1;
        SumSubsetutil(arr, sum-arr[index], index+1, subset);
        subset[index]=0;
        SumSubsetutil(arr, sum, index+1, subset);
    }
    
}
