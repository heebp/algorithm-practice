import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            list.get(day).add(score);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int max = 0;
        for(int i = 1000; i >= 1; i--){
            if(!list.get(i).isEmpty()) {
                pq.addAll(list.get(i));
            }
            if(!pq.isEmpty())
                max += pq.poll();
        }
        System.out.println(max);
    }
}
