import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            while(!deque.isEmpty() && arr[i] > arr[deque.peek()]){
                deque.poll();
            }
            if(deque.isEmpty()){
                bw.write(0+" ");
            }else{
                bw.write(deque.peek() + 1 +" ");
            }
            deque.push(i);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
