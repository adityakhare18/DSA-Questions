class StockSpanner {
    class Pair{
        int ele;
        int i;
        Pair(int ele,int i){
            this.ele = ele;
            this.i = i;
        }
    }
    Stack<Pair> st = new Stack<>();
    int idx;

    public StockSpanner() {
        st.clear();
        idx = -1;
    }
    
    public int next(int price) {
        idx++;
        while (!st.isEmpty() && st.peek().ele <= price) {
            st.pop();
        }

        int prevGreaterIndex = st.isEmpty() ? -1 : st.peek().i;
        st.push(new Pair(price, idx));

        return idx - prevGreaterIndex;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */