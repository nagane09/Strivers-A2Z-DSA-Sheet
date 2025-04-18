/*Input: val[] = [60, 100, 120], wt[] = [10, 20, 30], capacity = 50
Output: 240.000000
Explanation: Take the item with value 60 and weight 10, value 100 and weight 20 and split the third item with value 120 and weight 30, to fit it into weight 20. so
it becomes (120/30)*20=80, so the total value becomes 60+100+80.0=240.0 Thus, total maximum value of item we can have is 240.00 from the given capacity of sack. */

class Item {
    int value, weight;
    double ratio;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }
}

class Solution {
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        // code here
        int n =values.length;
        List<Item> items=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            items.add(new Item(values[i],weights[i]));
        }
        
        Collections.sort(items,(a,b)->Double.compare(b.ratio, a.ratio));
        
        double result=0;
        
        for(Item i:items){
            if(W>=i.weight){
                result+=i.value;
                W-=i.weight;
            }
            else{
                result+=W*i.ratio;
                break;
            }
        }
        return result;
    }
}
