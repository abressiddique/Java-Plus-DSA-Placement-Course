class Solution:
    def JobSequencing(self, id, deadline, profit):
        # Step 1: Find the maximum deadline
        n = 0
        for d in deadline:
            n = max(n, d)

        # Step 2: Prepare a list to track assigned job slots
        assignedJobs = [-1] * (n + 1)

        # Step 3: Create an array of indices (0 to len-1)
        length = len(profit)
        index = [i for i in range(length)]

        # Step 4: Sort indices by decreasing profit
        index.sort(key=lambda x: profit[x], reverse=True)

        # Step 5: Try to schedule each job
        count = 0
        maxProfit = 0
        for i in range(length):
            ind = index[i]
            d = deadline[ind]

            # Try to find a free slot from deadline d to 1
            while d > 0 and assignedJobs[d] != -1:
                d -= 1

            if d == 0:
                continue

            # Assign job and update counters
            assignedJobs[d] = id[ind]
            count += 1
            maxProfit += profit[ind]

        # Step 6: Return result as a list [number of jobs done, total profit]
        return [count, maxProfit]
id = [1, 2, 3, 4]
deadline = [4, 1, 2, 3]
profit = [20, 10, 40, 30]

sol = Solution()
print(sol.JobSequencing(id, deadline, profit))




class Solution {

    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        // code here..
        //find the max deadline
        int n = 0;
        for(int d : deadline){
            n = Math.max(n,d);
        }
        int assignedJobs[] = new int[n+1];
        Arrays.fill(assignedJobs,-1);
        int len = profit.length;
        Integer index[] = new Integer[len];
        for(int i=0;i<len;i++){
            index[i] = i;
        }
        Arrays.sort(index, (a,b) -> profit[b] - profit[a]);
        int count=0;
        int maxProfit=0;
        for(int i=0;i<len;i++){
            int ind = index[i];
            int d = deadline[ind];
            while(assignedJobs[d]!=-1) d--;
            if(d==0) continue;
            count++;
            assignedJobs[d]= id[ind];
            maxProfit += profit[ind];
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(count);
        res.add(maxProfit);
        return res;
    }
}
