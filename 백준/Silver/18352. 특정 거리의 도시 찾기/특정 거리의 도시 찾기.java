import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
        }
        List<Integer> ans = bfs(graph, K, X);
        Collections.sort(ans);
        if(ans.isEmpty())
            bw.write("-1\n");
        for (Integer node : ans) {
            bw.write(node + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static List<Integer> bfs(List<List<Integer>> graph, int k, int x) {
        Queue<int[]> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[graph.size()];
        visited[x] = true;
        q.add(new int[]{x, 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[1] == k){
                ans.add(cur[0]);
                continue;
            }
            for(int node : graph.get(cur[0])){
                if(visited[node])
                    continue;
                visited[node] = true;
                q.add(new int[]{node, cur[1] + 1});
            }
        }
        return ans;
    }
}
