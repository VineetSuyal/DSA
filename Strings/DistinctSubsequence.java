import java.util.*;
public class Main {
     public static int numDistinct(String s, String t) {
        int[][] cache = new int[s.length()+1][t.length()+1];
        for(int[] row : cache)
            Arrays.fill(row,-1);
        return count(s,t,cache,0,0);
    }
    public static int count(String s, String t, int cache[][], int currS, int currT){

        if(currT==t.length())
            return 1;
        
        if(currS==s.length())
            return 0;
        
        if(cache[currS][currT]!=-1)
            return cache[currS][currT];
        int a=0;
        if(s.charAt(currS)==t.charAt(currT))
             a = count(s,t,cache,currS+1,currT+1);
        int b = count(s,t,cache,currS+1,currT);
        
        return cache[currS][currT] = a+b;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        System.out.println(numDistinct(s,t));
    }
}