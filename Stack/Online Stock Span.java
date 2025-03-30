/*["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]
*/

class StockSpanner {
    Stack<int[]> s;
    public StockSpanner() {
        s=new Stack<>();
    }
    
    public int next(int price) {
        int span=1;
        while(!s.isEmpty() && price>=s.peek()[0]){
            span+=s.pop()[1];
        }

        s.push(new int[]{price,span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
