
package com.mycompany.aoa;
import java.util.Scanner;

public class LongestCommonSequence {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 1st String");
        String str1 = sc.nextLine();
         System.out.println("Enter the 2nd String");
        String str2 = sc.nextLine();
        String lcs = FindLCS(str1,str2);
        System.out.println("The length of LCS is "+lcs.length());
        System.out.println("The LCS String is "+lcs);
        
        
        
    }
    public static String FindLCS(String str1 ,String str2){
        int m = str1.length();
        int n  = str2.length();
        int[][] dp = new int[m+1][n+1];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;    
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                
            }
            
        }
        
//        Find the lcs
        int i = m , j = n;
        int length = dp[m][n];
        char[] lcs = new char[length];
        while (i>0 && j>0) {
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                lcs[length-1] = str1.charAt(i-1);
                i--;
                j--;
                length--;
            }else if (dp[i-1][j]>dp[i][j-1]) {
                    i--;
                    
                }else{
                    j--;
                }     
        }
        
//        printing calculation table
            System.out.println("the calculation table is : ");
            for (int k = 0; k <= m; k++) {
                for (int l = 0; l <= n; l++) {
                    if(k==0 || l==0){
                        System.out.print("0\t");
                    }else {
                        System.out.print(dp[k][l]+"\t");
                        if (str1.charAt(k-1)==str2.charAt(l-1)){
                        System.out.print("d");
                    }else if(dp[k-1][l]>dp[k][l-1]) {
                                
                                System.out.print("u");
                                
                            }else{
                                 System.out.print("l");
                                
                            }     
                   }   
                }
                System.out.println("");
            
        }
        return new String(lcs);
    }
    
}
