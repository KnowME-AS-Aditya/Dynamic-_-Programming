/*
 * Data Structures and Algorithms--Greedy
 */

/**
 *
 * @author Aditya Ranjan Sahoo <adityaen.official101@gmail.com>
 */
import java.util.*;
class Job{
    int start;
    int finish;
    int weight;
    Job(int start,int finish, int weight){
        this.start=start;
        this.weight=weight;
        this.finish=finish;
    }
}
public class WeightedIntSchd {

    /**
     * @param args the command line arguments
     */
    public static int findMaxWeight(Job[] jobs){
        Arrays.sort(jobs,Comparator.comparingInt(a -> a.finish));
        int dp[]=new int[jobs.length];
        dp[0]=jobs[0].weight;
        for(int i=1;i<jobs.length;i++){
            int latestConflict=binarySearch(jobs,i);
            dp[i]=Math.max(jobs[i].weight+((latestConflict==-1)?0:dp[latestConflict]),dp[i-1]);
            
        }
        return dp[jobs.length-1];
    }
    public static int binarySearch(Job[] jobs, int i){
        for(int j=i-1;j>=0;j--){
            if(jobs[j].finish<=jobs[i].start)
                 return j;
        }
        return -1;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Job[] jobs = {new Job(1, 3, 5), new Job(2, 5, 6), new Job(4, 6, 5), new Job(6,8 ,7)};
       System.out.println("Maximum weighted sum of non-overlapping intervals: " + findMaxWeight(jobs));
    }
    
}
