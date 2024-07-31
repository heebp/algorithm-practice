import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] capacity = new int[3];
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        capacity[0] = Integer.parseInt(st.nextToken());
        capacity[1] = Integer.parseInt(st.nextToken());
        capacity[2] = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        int[] abc = new int[3];
        abc[0] = 0;
        abc[1] = 0;
        abc[2] = capacity[2];
        dfs(abc, list, new HashSet<>());
        Collections.sort(list);
        for (Integer i : list) {
            bw.write(i+ " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int[] abc, List<Integer> list, Set<String> set) {
        String s = "" +abc[0] + abc[1] + abc[2];
        if(set.contains(s))
            return;
        set.add(s);
        if(abc[0] == 0)
            list.add(abc[2]);
        for (int i = 0; i < 3; i++) {
            if(abc[i] == 0)
                continue;
            for (int j = 0; j < 3; j++) {
                if(j == i)
                    continue;
                int[] nabc = abc.clone();
                if(nabc[j] + nabc[i] >= capacity[j]){
                    int tmp = nabc[j];
                    nabc[j] = capacity[j];
                    nabc[i] -= capacity[j] - tmp;
                }else{
                    nabc[j] += nabc[i];
                    nabc[i] = 0;
                }
                dfs(nabc, list, set);
            }
        }
    }
}
