import java.util.*;

class Solution {
    static Queue<Time>[] queues;
    static int tmp = Integer.MAX_VALUE;
    static class Time{
        int start;
        int end;
        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        queues = new Queue[k];

        for (int i = 0; i < k; i++) {
            queues[i] = new LinkedList<>();
        }
        for (int[] req : reqs) {
            queues[req[2] - 1].add(new Time(req[0], req[1]));
        }
        List<Integer> typeNum = new ArrayList<>();
        combination(0,n,k,typeNum);
        answer = tmp;
        return answer;
    }
    
    void combination(int depth, int n, int k, List<Integer> typeNum) {
        if (depth == k && n == 0){                
            int wait = 0;
            for (int i = 0; i < k; i++){
                int counsler = typeNum.get(i);
                Queue<Time> queue = new LinkedList<>(queues[i]);
                if(queue.isEmpty())
                    continue;
                Time first = queue.peek();
                
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for (int j = first.start; j <= 100000; j++){
                    if (queue.isEmpty())
                        break;
                    while (!pq.isEmpty() && pq.peek() <= j){
                        pq.poll();
                        counsler++;
                    }
                    while (counsler > 0 && !queue.isEmpty() && queue.peek().start <= j) {
                        Time time = queue.poll();
                        wait += (j - time.start);
                        int working = j + time.end;
                        pq.add(working);
                        counsler--;
                    }
                }
            }
            tmp = Math.min(tmp,wait);
            return;
        }

    	for (int i = 1; i <= n; i++) {
            typeNum.add(i);
            combination(depth + 1, n - i, k, typeNum);
            typeNum.remove(typeNum.size() - 1);
        }
    }
}