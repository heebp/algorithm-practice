import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int max;
    static int maxNode;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            List<int[]> list = graph.get(start);
            while (st.hasMoreTokens()) {
                int node = Integer.parseInt(st.nextToken());
                if (node == -1) {
                    break;
                }
                int weight = Integer.parseInt(st.nextToken());
                list.add(new int[]{node, weight});
                list.add(new int[]{start, weight});
            }
        }

        dfs(1, graph, 0, new boolean[N + 1]);
        dfs(maxNode, graph, 0, new boolean[N + 1]);

        System.out.println(max);
    }

    static void dfs(int cur, List<List<int[]>> graph, int length, boolean[] visited) {
        if (length > max) {
            max = length;
            maxNode = cur;
        }
        visited[cur] = true;
        for (int[] edge : graph.get(cur)) {
            if (visited[edge[0]])
                continue;
            dfs(edge[0], graph, length + edge[1], visited);
        }
    }
}
