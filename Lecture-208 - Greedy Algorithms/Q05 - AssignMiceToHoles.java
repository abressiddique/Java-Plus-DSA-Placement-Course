
class Solution:
    def assignMiceHoles(self, N: int, M: list[int], H: list[int]) -> int:
        # Step 1: Sort mice and holes
        M.sort()
        H.sort()
        
        # Step 2: Find max distance for corresponding pairs
        maxTime = 0
        for i in range(N):
            maxTime = max(maxTime, abs(M[i] - H[i]))
        
        return maxTime
sol = Solution()
print(sol.assignMiceHoles(3, [4, -4, 2], [4, 0, 5]))
# Output: 4


//User function Template for Java
class Solution {
    static int assignMiceHoles(int N , int[] M , int[] H) {
        // code here
        Arrays.sort(M);
        Arrays.sort(H);
        int maxTime=0;
        for(int i=0;i<N;i++){
            maxTime = Math.max(maxTime, Math.abs(M[i] - H[i]));
        }
        return maxTime;
    }
};
