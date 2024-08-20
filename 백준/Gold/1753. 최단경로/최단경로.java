
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visited;
    static int[] shortest;
    static class Node {
        int v;
        int w;
        Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        visited = new boolean[V + 1];
        shortest = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            shortest[i] = Integer.MAX_VALUE;
        }
        List<List<Node>> graph = new ArrayList<>();
        shortest[start] = 0;
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }
        for (int i = 0; i < V; i++) {
            int min = Integer.MAX_VALUE;
            int index = 0;

            for (int j = 1; j < V + 1; j++) {
                if(!visited[j]){
                    if (shortest[j] < min) {
                        min = shortest[j];
                        index = j;
                    }
                }
            }

            visited[index] = true;
            for (int j = 0; j < graph.get(index).size(); j++) {
                Node node = graph.get(index).get(j);

                if(shortest[node.v] > shortest[index] + node.w){
                    shortest[node.v] = shortest[index] + node.w;
                }
            }
        }
        for (int i = 1; i < V + 1; i++) {
            if (shortest[i] < Integer.MAX_VALUE) {
                bw.write(shortest[i]+"\n");
            } else {
                bw.write("INF\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
