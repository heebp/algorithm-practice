import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        String[] input = s.split("\\s");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]) - 1;
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int idx = K;
        for(int i = 0; i < N; i++){
            if(i == N - 1){
                sb.append(list.get(idx)+">");
                break;
            }
            sb.append(list.get(idx)+", ");
            list.remove(idx);
            idx = (idx + K) % list.size();
        }
        System.out.println(sb);
        br.close();
    }
}
