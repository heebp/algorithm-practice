import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        String[] input = s.split("\\s");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int idx = findIndex(deque, num);
            while (deque.peekFirst() != num) {
                if (idx <= deque.size() / 2) {
                    deque.addLast(deque.pollFirst());
                } else {
                    deque.addFirst(deque.pollLast());
                }
                cnt++;
            }
            deque.pollFirst();
        }
        System.out.println(cnt);
        br.close();
    }
    public static int findIndex(ArrayDeque<Integer> deque, int target) {
        int index = 0;
        for (Integer element : deque) {
            if (element == target) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
