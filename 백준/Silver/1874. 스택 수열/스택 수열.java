import java.io.*;
import java.util.ArrayDeque;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int cur = 1;
        for(int i = 0; i < n; i++){
            while(cur <= n && (deque.isEmpty() || arr[i] != deque.peek())){
                deque.push(cur);
                sb.append('+');
                cur++;
            }
            int num = deque.poll();
            if(arr[i] != num){
                System.out.println("NO");
                return;
            }
            sb.append('-');
        }
        for (int i = 0; i < sb.length(); i++) {
            bw.write(sb.charAt(i)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
