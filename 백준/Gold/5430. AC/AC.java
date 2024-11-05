import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < TC; i++) {
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String nums = br.readLine();
            nums = nums.substring(1, nums.length() - 1);
            String[] num;
            if(n != 0){
                num = nums.split(",");
                for (String a : num) {
                    deque.add(Integer.parseInt(a));
                }
            }
            int rCnt = 0;
            boolean errorFlag = false;
            for (int j = 0; j < cmd.length(); j++) {
                if(cmd.charAt(j) == 'R'){
                    rCnt++;
                }else{
                    if (deque.isEmpty()) {
                        errorFlag = true;
                        break;
                    }
                    if(rCnt % 2 == 0){
                        deque.removeFirst();
                    }else{
                        deque.removeLast();
                    }
                }
            }
            if (errorFlag) {
                bw.write("error\n");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if(rCnt % 2 == 0){
                while (!deque.isEmpty())
                    sb.append(deque.removeFirst()).append(",");
            }else{
                while (!deque.isEmpty())
                    sb.append(deque.removeLast()).append(",");
            }
            if(sb.charAt(sb.length() - 1) == ',')
                sb.deleteCharAt(sb.length() - 1);

            sb.append("]");
            bw.write(sb + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
