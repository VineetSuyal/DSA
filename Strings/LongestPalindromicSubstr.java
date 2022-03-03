import java.util.*;
public class Main {
    public static String longestPalindrome(String s) {
        int n = s.length();
        if(n==1){
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        int maxL = 0;
        int start=0,end=0;
        for(int g=0;g<n;g++){
            for(int i=0, j=g; j<dp.length; i++,j++){
                if(g==0){
                    dp[i][j]=true;
                }else if(g==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=false;
                    }
                }else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=false;
                    }
                }
                if(dp[i][j]){
                    int len = Math.abs(i-j) + 1;
                    if(len>maxL){
                        start = i;
                        end = j;
                        maxL=len;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(longestPalindrome(s));
    }
}