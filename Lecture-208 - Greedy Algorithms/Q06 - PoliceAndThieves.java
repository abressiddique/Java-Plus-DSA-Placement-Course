✅ Problem: Catch Thieves
Goal:
You're given an array of characters of size n. Each character is either:

'P': police

'T': thief

A police can catch one thief if the distance between them is at most k (inclusive).
Each thief and each police can only be used once.

arr: List of characters, e.g. ['P', 'T', 'T', 'P', 'T']
n:   Length of arr (int)
k:   Maximum distance police can reach to catch thief (int)
class Solution:
    def catchThieves(self, arr, n, k):
        i = -1  # pointer to next police
        j = -1  # pointer to next thief
        
        # Initialize i and j
        for m in range(n):
            if i == -1 and arr[m] == 'P':
                i = m
            if j == -1 and arr[m] == 'T':
                j = m
            if i != -1 and j != -1:
                break

        if i == -1 or j == -1:
            return 0  # no thief or no police

        caught = 0
        while i < n and j < n:
            if abs(i - j) <= k:
                caught += 1
                i += 1
                while i < n and arr[i] != 'P':
                    i += 1
                j += 1
                while j < n and arr[j] != 'T':
                    j += 1
            elif i < j:
                i += 1
                while i < n and arr[i] != 'P':
                    i += 1
            else:
                j += 1
                while j < n and arr[j] != 'T':
                    j += 1

        return caught



//User function Template for Java

class Solution 
{ 
    static int catchThieves(char arr[], int n, int k) 
	{ 
        // Code here
        int i=-1;
        int j=-1;
        for(int m=0;m<n;m++){
            if(i==-1 &&arr[m] == 'P') i=m;
            if(j==-1 &&arr[m] == 'T') j=m;
            if(i!=-1 && j!=-1) break;
        }
        if(i==-1 || j==-1) return 0;
        
        int caught=0;
        while(i<n && j<n){
            if(Math.abs(i-j) <= k) { // next police and thief
                caught++;
                i++;
                while(i<n && arr[i]!='P') i++;
                j++;
                while(j<n && arr[j]!='T') j++;
            }
            else if(i<j){ //next police
                i++;
                while(i<n && arr[i]!='P') i++;
            }else{ //next thief
                j++;
                while(j<n && arr[j]!='T') j++;
            }
        }
        return caught;
	} 
} 
