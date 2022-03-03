import java.util.*;
public class Main {
    public static int longestValidParentheses(String s) {
        int ans=0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                st.push(i);
            else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    ans = Math.max(ans,i-st.peek());
                }
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(longestValidParentheses(s));
    }
}