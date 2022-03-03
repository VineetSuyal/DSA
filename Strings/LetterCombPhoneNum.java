import java.util.*;
public class Main {
    public static List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return new LinkedList<>();
        List<String> l = new LinkedList<>();
        comb(digits,0,"",l);
        return l;
    }
    static String[] str = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public static void comb(String digits,int i,String s, List<String> l){
        
        if(i==digits.length()){
            l.add(s);
            return;
        }
        
        String st = str[(digits.charAt(i)-'0')];
        
        for(int j=0;j<st.length();j++){
            comb(digits,i+1,s+st.charAt(j),l);
        }
        
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(letterCombinations(s));
    }
}