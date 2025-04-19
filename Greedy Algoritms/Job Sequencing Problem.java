/*You are given two arrays: deadline[], and profit[], which represent a set of jobs, where each job is associated with a deadline, and a profit. Each job takes 1 unit 
of time to complete, and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed by its deadline.

Your task is to find:

The maximum number of jobs that can be completed within their deadlines.
The total maximum profit earned by completing those jobs.
Examples :

Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
Output: [2, 60]
Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40)*/

class Solution {
    static class Job{
        int deadline,profit,idx;
        
        Job(int deadline,int profit, int idx){
            this.deadline=deadline;
            this.profit=profit;
            this.idx=idx;
        }
    }
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        ArrayList<Job> jobStore=new ArrayList<>();
        
        for(int i=0;i<deadline.length;i++){
            jobStore.add(new Job(deadline[i],profit[i],i+1));
        }
        
        jobStore.sort((m1,m2)->
            m2.profit-m1.profit
        );
        
        int maxDeadline=0;
        for(int i:deadline){
            maxDeadline=Math.max(i,maxDeadline);
        }
        
        boolean[] slot = new boolean[maxDeadline];
        int totalProfit = 0;
        int jobCount = 0;
        
        for(Job i:jobStore){
            for(int j=i.deadline-1;j>=0;j--){
                if(!slot[j]){
                    slot[j]=true;
                    totalProfit+=i.profit;
                    jobCount++;
                    break;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(jobCount);
        result.add(totalProfit);
        return result;
    }
}
