import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    class Job implements Comparable<Job>{
        int req;
        int work;
        int timer = 0;
        public Job(int req, int work){
            this.req = req;
            this.work = work;
        }
        public void waiting(){
            timer++;
        }
        public void exec(){
            work--;
        }
        @Override
        public int compareTo(Job job){
            return this.work >= job.work ? 1: -1; 
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        int timer = 0;
        int num = 0;
        int sum = 0;
        PriorityQueue<Job> JobPQ = new PriorityQueue<>();
        Queue<Job> workQ = new LinkedList<>();
        while(!(JobPQ.isEmpty() && workQ.isEmpty() && (num == jobs.length))){
            for(int i  = 0; i<jobs.length; i++){
                if(timer == jobs[i][0]){
                    JobPQ.add(new Job(jobs[i][0], jobs[i][1]));
                    num++;
                }
            }
            if(JobPQ.peek() != null)
                if(workQ.isEmpty())
                    workQ.add(JobPQ.poll());

            if(workQ.peek() != null)
                workQ.peek().exec();

            for(Job job : JobPQ)
                job.waiting();
            for(Job job : workQ)
                job.waiting();
            if(workQ.peek() != null)
                if(workQ.peek().work == 0)
                    sum += workQ.poll().timer;

            timer++;
        }
        answer = sum / jobs.length;
        return answer;
    }
}