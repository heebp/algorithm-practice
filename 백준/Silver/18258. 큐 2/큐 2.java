import java.io.*;
import java.util.ArrayDeque;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            String[] input = s.split("\\s");
            switch (input[0]){
                case "push" :
                    deque.add(Integer.valueOf(input[1]));
                    break;
                case "pop" :
                    bw.write(deque.isEmpty() ? "-1\n" :deque.poll() +"\n");
                    break;
                case "front":
                    bw.write(deque.isEmpty() ? "-1\n" : deque.getFirst()+"\n");
                    break;
                case "back" :
                    bw.write(deque.isEmpty() ? "-1\n" : deque.getLast()+"\n");
                    break;
                case "size" :
                    bw.write(deque.size()+"\n");
                    break;
                case "empty" :
                    bw.write(deque.isEmpty() ? "1\n" :"0\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
