✅ Problem Statement:
You are given:

Two arrays:

capacity[i]: total capacity of the i-th bag

rocks[i]: current number of rocks in the i-th bag

An integer additionalRocks — rocks you can distribute.

Goal:
Distribute the additionalRocks to maximize the number of bags that become full (i.e., rocks[i] == capacity[i]).




def maximum_bags(capacity, rocks, additionalRocks):
    n = len(rocks)
    diff = [capacity[i] - rocks[i] for i in range(n)]  # how many rocks each bag still needs

    diff.sort()  # fill the bags that need the least first
    count = 0

    for i in range(n):
        if diff[i] <= additionalRocks:
            additionalRocks -= diff[i]
            diff[i] = 0  # now bag is full
        if diff[i] == 0:
            count += 1

    return count
capacity = [10, 2, 2]
rocks = [2, 2, 0]
additionalRocks = 3

print(maximum_bags(capacity, rocks, additionalRocks))  # Output: 2


class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int diff[] = new int[n];
        for(int i=0;i<n;i++){
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        int count=0;
        for(int i=0;i<n;i++){
            if(diff[i]<= additionalRocks){
                additionalRocks-=diff[i];
                diff[i] = 0;
            }
            if(diff[i] == 0){
                count++;
            }
        }
        return count;
    }
}
