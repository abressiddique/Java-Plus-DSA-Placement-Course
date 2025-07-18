class Solution:
    def activitySelection(self, start: list[int], end: list[int]) -> int:
        """
        Parameters:
        start : List[int] -> list of start times of activities
        end   : List[int] -> list of end times of activities

        Returns:
        int -> maximum number of non-overlapping activities
        """
        n = len(start)

        # Step 1: Create a list of (start, end, index) tuples
        activities = []
        for i in range(n):
            activities.append([start[i], end[i], i])

        # Step 2: Sort activities based on end time
        def sort_by_end(activity):
            return activity[1]  # activity[1] is end time

        activities.sort(key=sort_by_end)

        # Step 3: Greedy selection
        max_activities = 1
        last_end_time = activities[0][1]  # end time of first selected activity

        for i in range(1, n):
            current_start = activities[i][0]
            current_end = activities[i][1]

            if current_start > last_end_time:
                max_activities += 1
                last_end_time = current_end

        return max_activities
start = [1, 3, 2, 5]
end = [2, 4, 3, 6]

sol = Solution()
print(sol.activitySelection(start, end))  # Output: 3


class Solution {
    public int activitySelection(List<Integer> start, List<Integer> end) {
        // code here.
        int n = start.size();
        ArrayList<Integer> indexArr = new ArrayList<>();
        for(int i=0;i<n;i++){
            indexArr.add(i);
        }
        //sorting
        // [2,1,0,5,4,3]
        Collections.sort(indexArr, (a,b) -> (end.get(a) - end.get(b)));
        int maxActivity=1;
        int lastEnd = end.get(indexArr.get(0));
        for(int i=1;i<n;i++){
            int index = indexArr.get(i);
            if(start.get(index) > lastEnd){
                maxActivity++;
                lastEnd = end.get(index);
            }
        }
        return maxActivity;
    }
}
