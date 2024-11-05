import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                deque.pop();
            }else{
                deque.push(num);
            }
        }
        int sum = deque.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
        br.close();
    }
}