import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        List<Character> oper = new ArrayList<>();
        List<Long> num = new ArrayList<>();
        Set<Character> operMeta = new HashSet<>();
        int s = 0;
        int e = 0;
        while(e < expression.length()){
            char cur = expression.charAt(e);
            if(cur == '-' || cur == '*' || cur == '+'){
                num.add(Long.valueOf(expression.substring(s, e)));
                oper.add(cur);
                operMeta.add(cur);
                s = e + 1;
            }
            e++;
        }
        num.add(Long.valueOf(expression.substring(s, e)));
        
        String ss = "";
        for(Character c : operMeta){
            ss += c;
        }
        List<List<Character>> orders = new ArrayList<>();
        makeOrder(orders, new ArrayList<>(), ss, new boolean[operMeta.size()]);
        long max = -1;
        for(List<Character> order : orders){
            List<Long> cNum = new ArrayList<>(num);
            List<Character> cOper = new ArrayList<>(oper);
            long sum = 0;
            for(Character o : order){
                for(int i = 0; i < cOper.size(); i++){
                    if(o == cOper.get(i)){
                        sum = calc(o, cNum.get(i), cNum.get(i + 1));
                        cNum.set(i, sum);
                        cNum.remove(i + 1);
                        cOper.remove(i);
                        i--;
                    }
                }
            }
            max = Math.max(max, Math.abs(sum));
        }
        answer = max;
        return answer;
    }
    
    void makeOrder(List<List<Character>> result, List<Character> tmp, String operMeta, boolean[] v){
        if(tmp.size() == operMeta.length()){
            result.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0; i < operMeta.length(); i++){
            if(v[i])
                continue;
            v[i] = true;
            tmp.add(operMeta.charAt(i));
            makeOrder(result, tmp, operMeta ,v);
            tmp.remove(tmp.size() - 1);
            v[i] = false;
        }
    }
    
    long calc(char oper, Long n1, Long n2){
        switch(oper){
            case '*' : return n1 * n2;
            case '+' : return n1 + n2;
            case '-' : return n1 - n2;
        }
        return 0;
    }
}