import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new int[]{v, w});
        }
        int[] vs = dijkstra(graph, start);
        for (int i = 1; i < vs.length; i++) {
            if(vs[i] == Integer.MAX_VALUE)
                bw.write("INF\n");
                else bw.write(vs[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
    static int[] dijkstra(List<List<int[]>> graph, int start) {
        int[] v = new int[graph.size()];
        Arrays.fill(v, Integer.MAX_VALUE);
        v[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(cur[1] < v[cur[0]])
                continue;
            for (int[] next : graph.get(cur[0])) {
                if(v[next[0]] <= v[cur[0]] + next[1])
                    continue;
                v[next[0]] = v[cur[0]] +  next[1];
                pq.add(new int[]{next[0], v[next[0]]});
            }
        }
        return v;
    }
}
