package com.mycompany.aoa;

import java.util.Arrays;
import java.util.Scanner;

 public class PrimsAlgo{
     private static final int INF = Integer.MAX_VALUE;
     
       public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter the no of vertices");
         int v = sc.nextInt();
         int[][] graph = new int[v][v];
         System.out.println("Enter the graph");
         
         for (int i = 0; i < v; i++) {
             for (int j = 0; j < v; j++) {
                 graph[i][j] = sc.nextInt();
             }
             
         }
         
       PSM ob1 = new PSM();
       ob1.prims(graph);
       sc.close();
        
     }
     
     public static int MinDistance(int[] dist ,boolean[] visited){
         int min = INF , MinIndex = -1;
         for (int i = 0; i < dist.length; i++) {
             if (!visited[i] && dist[i] < min) {
                 min = dist[i];
                 MinIndex = i;
                 
             }
             
         }
         
         return MinIndex;
         
     }

     void prims(int[][] graph){
         int v = graph.length;
         int[] dist  =new int[v];
         int[] pred = new int[v];
         boolean[] visited = new boolean[v];
         
         Arrays.fill(dist, INF);
         Arrays.fill(visited, false);
         
         dist[0] = 0;
         pred[0]=-1;
         
         for (int Count = 0; Count <v-1 ; Count++) {
             int u = MinDistance(dist, visited);
             visited[u]=true;
             for(int V= 0 ; V < v ; V++){
                 
                 if (!visited[V] && graph[u][V]!=0 && dist[V] > graph[u][V]){
                     dist[V] = graph[u][V];
                     pred[V] = u;
                     
                 }
             
         }
       }
        
         System.out.println("Edge\t\tWeight");
         for (int i = 1; i < graph.length; i++) {
             System.out.println(pred[i]+" - "+i+"\t"+graph[i][pred[i]]);
             
         }
      
             int MinCost = 0;
             for (int i = 1; i < v; i++) {
                 MinCost = MinCost + graph[i][pred[i]];
                 
             }
             System.out.println("The Minimum cost is : "+MinCost);
 
     }
 
 }