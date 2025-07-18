class StockSpanner {
    List<Integer> ls;

    public StockSpanner() {
        ls = new ArrayList<>();
    }
    
    public int next(int price) {
        int cnt = 1;
        int n = ls.size()-1;
        for(int i=n;i>=0;i--){
            if(ls.get(i) <= price)
            cnt++;
            else
            break;
        }
        ls.add(price);
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */