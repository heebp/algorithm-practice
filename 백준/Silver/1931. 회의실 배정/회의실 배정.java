

import java.io.*;
import java.util.*;

//1931
public class Main {
    static class Schedule{
        int s;
        int e;

        Schedule(int s, int e) {
            this.s =s ;
            this.e =e;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Schedule> list = new ArrayList<Schedule>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Schedule(s, e));
        }
        list.sort((o1, o2) -> o1.s != o2.s ? o1.s - o2.s : o1.e - o2.e);
        for (int i = 0; i < list.size(); i++) {

            if(i+1 == list.size()){
                break;
            }
            if (list.get(i).s == list.get(i).e) {
                continue;
            }
            if (list.get(i).s <= list.get(i + 1).s && list.get(i).e == list.get(i + 1).e && list.get(i+1).s == list.get(i+1).e) {
                continue;
            }
            if (list.get(i).s <= list.get(i + 1).s && list.get(i).e >= list.get(i + 1).e) {
                list.remove(i);
                i--;
                continue;
            }
            if (list.get(i).s >= list.get(i + 1).s && list.get(i).e <= list.get(i + 1).e) {
                list.remove(i + 1);
                i--;
                continue;
            }
            if (list.get(i).s < list.get(i + 1).s && list.get(i).e < list.get(i + 1).e && list.get(i+1).s < list.get(i).e) {
                list.remove(i + 1);
                i--;
            }
        }
        bw.write(list.size()+"");
        bw.flush();
        bw.close();
    }
}
