
package com.mycompany.aoa;
import java.util.Scanner;


public class RabinKarpAlgo {
    public final static int d = 256;
    public static void main(String[] args) {
        int q= 101;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the txt");
        String txt = sc.nextLine();
        System.out.println("Enter the pattern");
        String ptn = sc.nextLine();
        
        search(txt,ptn,q);
       
    }
    
    public static void search(String txt , String ptn , int q){
        int i,j;
        int p=0;
        int t = 0;
        int h = 1;
        int M = ptn.length();
        int N = txt.length();
        
        for (int k = 0; k < M-1; k++) {
            h= (h*d)%q;
        }
        for (i= 0;  i< M;i++) {
            p =  (d*p+ ptn.charAt(i))%q;
            t = (d*t + txt.charAt(i))%q;
            
        }
        for ( i = 0; i <= N-M; i++) {
            if(p==t){
                for(j=0;j<M;j++){
                    if(ptn.charAt(j)!=txt.charAt(j+i))
                        break;
                }
               if(j==M)
                    System.out.println("Pattern is found at "+i);
                   
                
            }
            if(i<N-M){
                t= (d*(t-txt.charAt(i)*h)+txt.charAt(i+M))%q;
                if(t<0)
                    t=t+q;
            }
            
        }
        
       
    }
    
}
