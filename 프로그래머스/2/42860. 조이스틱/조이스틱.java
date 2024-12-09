class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] arrName = name.toCharArray();
        answer += recur(0, arrName, 0);
        return answer;
    }
    int recur(int cur, char[] name, int dst){
        dst += findAlphabet(cur, name);
        int l = findIdx(cur, name, -1);
        int r = findIdx(cur, name, 1);
        if(l == -1 && r == -1)
            return dst;
        int min = Integer.MAX_VALUE;
        int lIdx = (cur + name.length - l) % name.length;
        int rIdx = (cur + r) % name.length;
        min = Math.min(recur(lIdx, name.clone(), dst + l), min);
        min = Math.min(recur(rIdx, name.clone(), dst + r), min);
        return min;
    }
    int findIdx(int cur, char[] name, int sig){
        for(int i = 1; i < name.length; i++){
            int idx = cur + (i * sig);
            if(idx < 0)
                idx = name.length + idx;
            if(name[idx % name.length] != 'A')
                return i;
        }
        return -1;
    }

    int findAlphabet(int cur, char[] name){
        int num1 = name[cur] - 'A';
        int num2 = Math.abs('Z' - name[cur]) + 1;
        name[cur] = 'A';
        if(num1 > num2)
            return num2;
        return num1;
    }
}