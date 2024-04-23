
package com.mycompany.aoa;
import java.util.Arrays;
import java.util.Scanner;

public class DijkstraAlgo {
    
    private static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of verices");
        int v = sc.nextInt();
        int[][] graph = new int[v][v];
        
        System.out.println("Enter the Graph");
        for(int i = 0 ; i < v ; i++){
            for (int j = 0; j < v; j++) {
                graph[i][j] = sc.nextInt();
                
            }
        }
        
        System.out.println("Enter the source vertes(Char)");
        char source = sc.next().charAt(0);
        
        dijkstra(graph,source-'A',v);
        
    }
    
    public static void dijkstra(int[][] graph , int scr , int v){
        
        int[] dist = new int[v];
        int[] pred =  new int[v];
        boolean[] visited = new boolean[v];
        
        Arrays.fill(dist, INF);
        Arrays.fill(pred, -1);
        dist[scr] = 0;
        
        for(int count = 0 ; count < v-1 ; count++){
            int u = MinDistance(dist,visited,v);
            visited[u]=true;
            
            for (int V = 0; V < v; V++) {
                if(!visited[V] && graph[u][V]!=0 && dist[u] != INF && dist[V]> dist[u] +graph[u][V]){
                    dist[V] = dist[u] + graph[u][V];
                    pred[V] = u;
                    
                    
                }
                
            }
            
        }
        System.out.println("SDFV" +(char)('A'+scr)+ ": ");
        for (int i = 0; i < v; i++) {
            System.out.println("Vertex"+(char)('A'+i)+" --> "+dist[i]+" Path "+getPath(pred,scr,i));
            
        }
            
        
        
    }
    
    public static int MinDistance(int[] dist , boolean[] visited , int v){
        int min = INF, MinIndex = -1;
        
        for(int V=0 ; V<v; V++){
            if(!visited[V] && dist[V]<=min){
                min = dist[V];
                MinIndex = V;
            }
        }
        
        return MinIndex;
        
    }
    
    public static String getPath(int[] pred , int scr , int dest){
        int current = dest;
        StringBuilder path = new StringBuilder();
        path.append((char)('A'+dest));
        
        while (current!=scr) {
            current = pred[current];
            path.insert(0,(char)('A'+current)+"-->");
            
            
        }
        return path.toString();
        
        
    }
    
}
