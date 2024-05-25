import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<int[]> schedule = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            schedule.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        schedule.sort((o1, o2)->{
                return o1[0] - o2[0];
        });
        int cnt = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(schedule.get(0)[1]);
        for (int i = 1; i < schedule.size(); i++) {
            while (!pq.isEmpty() && schedule.get(i)[0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(schedule.get(i)[1]);
            cnt = Math.max(cnt, pq.size());
        }
        System.out.println(cnt);
    }
}
