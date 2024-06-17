//31245 => 32154 => 

import java.util.*;

class Solution {
    public int nextGreaterElement(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        PriorityQueue<Character> pq = new PriorityQueue<>();
        int prev = sb.length() - 1;
    
        for(int i = sb.length() - 2; i >= 0; i--){
            if(sb.charAt(i) < sb.charAt(prev)){
                pq.add(sb.charAt(prev));
                char nge = findNGE(pq, sb.charAt(i));
                pq.add(sb.charAt(i));
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                sb.append(nge);
                return append(sb, pq);
            }
            pq.add(sb.charAt(prev));
            prev = i;
            sb.deleteCharAt(sb.length() - 1);
        }
        return -1;
    }
    int append(StringBuilder sb, PriorityQueue<Character> pq){
        while(!pq.isEmpty())
            sb.append(pq.poll());
        System.out.println(sb.toString());
        return Long.parseLong(sb.toString()) > Integer.MAX_VALUE ? -1 : Integer.parseInt(sb.toString());
    }

    char findNGE(PriorityQueue<Character> pq, char cur){
        PriorityQueue<Character> tmp = new PriorityQueue<>();
        while(!pq.isEmpty()){
            if(cur < pq.peek()){
                char ret = pq.poll();
                pq.addAll(tmp);
                return ret;
            }
            tmp.add(pq.poll());
        }
        return '\0';
    }
}