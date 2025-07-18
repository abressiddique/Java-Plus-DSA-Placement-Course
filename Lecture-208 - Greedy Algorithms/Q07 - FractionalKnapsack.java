class Item:
    def __init__(self, val, wt):
        self.val = val
        self.wt = wt
        self.ratio = val / wt  # value-to-weight ratio

def fractional_knapsack(values, weights, capacity):
    n = len(values)
    
    # Step 1: Create a list of Items with ratio
    items = []
    for i in range(n):
        items.append(Item(values[i], weights[i]))

    # Step 2: Sort items by ratio in descending order
    items.sort(key=lambda item: item.ratio, reverse=True)

    # Step 3: Greedily pick items
    total_value = 0.0
    for item in items:
        if capacity == 0:
            break
        
        if item.wt <= capacity:
            total_value += item.val
            capacity -= item.wt
        else:
            # Take only fraction of the item
            total_value += item.ratio * capacity
            capacity = 0

    return total_value
values = [60, 100, 120]
weights = [10, 20, 30]
capacity = 50

print(fractional_knapsack(values, weights, capacity))  # Output: 240.0


// User function Template for Java
class Solution {
    class Item implements Comparable<Item>{
        int val;
        int wt;
        double ratio;
        Item(int v, int w){
            val = v;
            wt = w;
            ratio = (double)val/(double)wt;
        }
        //dec order of ratio sort
        public int compareTo(Item that){
            if(this.ratio <= that.ratio) return 1;
            return -1;
        }
    }
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // code here
        int n = val.size();
        ArrayList<Item> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Item(val.get(i) , wt.get(i)));
        }
        Collections.sort(list);
        
        double res=0.0;
        for(Item item : list){
            if(item.wt>=capacity){
                res += (capacity * item.ratio);
                capacity=0;
            }else{
                res+= item.val;
                capacity -= item.wt;
            }
            if(capacity==0) break;
        }
        return res;
        
    }
}



