import java.util.*;

class Solution {
    public String robotWithString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] minChar = new char[s.length()];
        
        minChar[s.length() - 1] = s.charAt(s.length() - 1);
        for (int i = s.length() - 2; i >=  0; i--) {
            minChar[i] = s.charAt(i) < minChar[i + 1] ? s.charAt(i) : minChar[i + 1];
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || c == stack.peek()) {
                stack.push(c);
                continue;
            }
            while(!stack.isEmpty() && stack.peek() <= minChar[i]) {
                sb.append(stack.pop());
            }
            stack.push(c);
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}