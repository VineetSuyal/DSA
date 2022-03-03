import java.util.*;
public class Main {
    public static String countAndSay(int n) {
        String res = "1";
        for(int i=1;i<n;i++){
            res = count(res);
        }
        return res;
    }
    public static String count(String s){
        StringBuilder sb = new StringBuilder();
        int count=1;
        char c = s.charAt(0);
        
        for(int i=1;i<s.length();i++){
            if(c==s.charAt(i))
                count++;
            else{
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count=1;
            }
        }
        sb.append(count);
        sb.append(c);;
        
        return sb.toString();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countAndSay(n));
    }
}