
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        List<Integer> list = new LinkedList<>();
        List<Character> ch = new LinkedList<>();
        String s = br.readLine();
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                list.add(Integer.valueOf((s.substring(len, i))));
                ch.add(s.charAt(i));
                len = i+1;
            }
            if (i == s.length()-1) {
                list.add(Integer.valueOf(s.substring(len,i+1)));
            }
        }
        int result;
        int operand = '+';
        while (ch.size() != 0) {
            for (int i = 0; i < ch.size(); i++) {
                if (ch.get(i) == operand) {
                    if (ch.get(i) == '+') {
                        result = list.get(i) + list.get(i + 1);
                    } else {
                        result = list.get(i) - list.get(i + 1);
                    }
                    list.remove(i);
                    ch.remove(i);
                    list.remove(i);
                    list.add(i, result);
                    i--;
                }
            }
            operand = '-';
        }
        bw.write(list.get(0)+"");
        bw.flush();
        bw.close();
    }
}
