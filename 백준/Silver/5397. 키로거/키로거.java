import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());
        Stack<Character> main = new Stack<>();
        Stack<Character> sub = new Stack<>();
        for (int i = 0; i < TC; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                char input = s.charAt(j);
                switch (input){
                    case '<' :
                        if(!main.isEmpty())
                            sub.add(main.pop());
                        break;
                    case '>' :
                        if(!sub.isEmpty())
                            main.add(sub.pop());
                        break;
                    case '-' :
                        if(!main.isEmpty())
                            main.pop();
                        break;
                    default:
                        main.add(input);
                        break;
                }
            }
            StringBuilder sb = new StringBuilder();
            while(!main.isEmpty())
                sb.append(main.pop());
            sb.reverse();
            while(!sub.isEmpty()) {
                sb.append(sub.pop());
            }
            bw.write(sb+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
