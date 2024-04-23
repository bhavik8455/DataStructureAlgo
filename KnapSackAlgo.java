
package com.mycompany.aoa;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KnapSackAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of items");
        int n = sc.nextInt();
        int[] profit = new int[n];
        int[] weight = new int[n];
        
        System.out.println("Enter the profits ");
        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
        }
         System.out.println("Enter the Weights ");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        System.out.println("Enter the Knapsack capacity: ");
        int capacity = sc.nextInt();
        
        KS(profit,weight,capacity);
        
    }
    
    public static void KS(int profit[] , int weight[] , int capacity){
        int n = profit.length;
        int[][] ks = new int[n+1][capacity+1];
        
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j<= capacity; j++) {
                
               if(i==0 || j==0){
                   ks[i][j]=0;
               }
                
            else{
                    if(weight[i-1] <= j){
                    ks[i][j] = Math.max(ks[i-1][j], profit[i-1] + ks[i-1][j-weight[i-1]] );
                    
                }else{
                    ks[i][j] = ks[i-1][j];
                }
               }
            
        }
        
       }
        System.out.println("The maximum profit is "+ks[n][capacity]+"units");
        
        System.out.println("Calculation table");
        for (int i = 0; i <= n; i++) {
            System.out.print("Item No. : "+ (i+1));
            for (int j = 0; j <= capacity; j++) {
                System.out.print(" | "+ ks[i][j]);
                
            }
            System.out.println();
            
            
        }
        
        List<Integer> SelectedItem = new ArrayList<>();
        int i = n, j = capacity;
        while (j>0 && i>0) {
            if(ks[i][j] != ks[i-1][j]){
                SelectedItem.add(i-1);
                j = j - weight[i-1];
                
            }
            i--;
            
        }
        
        System.out.println("Item in the knapsack is : ");
        for(int index : SelectedItem){
            System.out.println("Item No : "+(index+1) + "Profit is : "+profit[index]+"weights : "+weight[index]);
        }
    }
    
    
    
}
