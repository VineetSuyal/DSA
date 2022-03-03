import java.util.*;
public class Main {
     public static List<String> generateParenthesis(int n) {
        List<String> l = new LinkedList<>();
        paranth(n,new StringBuilder(),l,0,0);
        return l;
    }
    public static void paranth(int n, StringBuilder s , List<String> l, int open, int close){
        if(s.length()==2*n){
            l.add(s.toString());
            return;
        }
        
        if(open<n){
            s.append("(");
            paranth(n,s,l,open+1,close);
            s.deleteCharAt(s.length()-1);
        }
        if(close<open){
            s.append(")");
            paranth(n,s,l,open,close+1);
            s.deleteCharAt(s.length()-1);
        }
        
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(generateParenthesis(n));
    }
}