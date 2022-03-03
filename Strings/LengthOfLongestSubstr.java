import java.util.*;
public class Main {
    public int lengthOfLongestSubstring(String s) {
       
        HashSet<Character> set = new HashSet<>();
        
        int ans=0;
        int r=0,l=0;
        
        while(r<s.length()){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(r++));
            ans = Math.max(ans,set.size());
        }
        
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(lengthOfLongestSubstring(s));
    }
}