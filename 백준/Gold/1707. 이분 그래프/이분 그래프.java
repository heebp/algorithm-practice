import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= V; j++) {
                graph.add(new ArrayList<>());
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph.get(s).add(e);
                graph.get(e).add(s);
            }
            int[] visited = new int[graph.size()];
            boolean flag = false;
            for (int j = 1; j <= V; j++) {
                if(visited[j] == 0){
                    visited[j] = 1;
                    if(!dfs(j, 1, graph, visited)){
                        System.out.println("NO");
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag) System.out.println("YES");
        }
    }
    static boolean dfs(int cur, int num,  List<List<Integer>> graph, int[] visited) {

        for (Integer next : graph.get(cur)) {
            if(visited[next] == -num)
                continue;
            if (visited[next] == num)
                return false;
            visited[next] = -num;
            if(!dfs(next, -num, graph, visited)){
                return false;
            }
        }
        return true;
    }

}
