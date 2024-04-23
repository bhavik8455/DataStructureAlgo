
package com.mycompany.aoa;
import java.util.Scanner;


public class ColourGraphing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the No. of Colors");
        int color = sc.nextInt();
        System.out.println("Enter the no. of vertes");
        int n = sc.nextInt();
        int[][] graph = new int[n+1][n+1];
        int[] solutionvector = new int[n+1];
        System.out.println("Enter the Matrix");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j]  = sc.nextInt();
                
            }
            
        }
        graphcolor(1,n,color,graph,solutionvector);
        
        
    }
    
    public static void graphcolor(int k,int n , int color ,int[][] graph , int[] x){
        while (true) {            
            nextValue(k,n,color,graph,x);
            if(x[k]==0){
                return;
            }if(k==n){
                System.out.println("the solution vector is ");
                System.out.println("{");
                for (int i = 1 ; i<=n ; i++) {
                    System.out.print(x[i]+" ");
                
            }
                System.out.println("}");
           }else{
                graphcolor(k+1, n, color, graph, x);
            }
            
        }
    }
    
    public static void nextValue(int k,int n , int color ,int[][] graph , int[] x){
        int i;
        while (true) {
            x[k] = (x[k]+1)%(color+1);
            if(x[k]==0){
                return;
            }
            for (i = 1; i <= n; i++) {
                if (graph[k][i]!=0 && x[k]==x[i]) {
                    break;
                    
                }
                
            }
            if(i == n+1){
                return;
            }
            
        }
    }
}
