import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        Stack<Character> main = new Stack<>();
        Stack<Character> sub = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            main.add(s.charAt(i));
        }
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);

            switch (cmd){
                case 'L':
                    if(!main.isEmpty())
                        sub.add(main.pop());
                    break;
                case 'D' :
                    if(!sub.isEmpty())
                        main.add(sub.pop());
                    break;
                case 'B' :
                    if(!main.isEmpty()){
                        main.pop();
                    }
                    break;
                case 'P' :
                    char appendix = st.nextToken().charAt(0);
                    main.add(appendix);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!main.isEmpty()){
            sb.append(main.pop());
        }
        sb.reverse();
        while(!sub.isEmpty()){
            sb.append(sub.pop());
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
