def maximum_units(boxTypes, truckSize):
    # Step 1: Sort boxTypes by units per box in decreasing order
    boxTypes.sort(key=lambda x: x[1], reverse=True)

    total_units = 0
    for boxes, units_per_box in boxTypes:
        if boxes >= truckSize:
            total_units += truckSize * units_per_box
            truckSize = 0
        else:
            total_units += boxes * units_per_box
            truckSize -= boxes

        if truckSize == 0:
            break

    return total_units
boxTypes = [[1, 3], [2, 2], [3, 1]]
truckSize = 4

print(maximum_units(boxTypes, truckSize))  # Output: 8


class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // sort in decreasing order of ratio
        // a[1], b[1] -> value of 1 item
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int res=0;
        for(int boxType[] : boxTypes){
            if(boxType[0]>=truckSize){
                res+=(truckSize*boxType[1]);
                truckSize=0;
            }else{
                res+=(boxType[0] * boxType[1]);
                truckSize-=boxType[0];
            }
            if(truckSize==0) break;
        }
        return res;

    }
}
