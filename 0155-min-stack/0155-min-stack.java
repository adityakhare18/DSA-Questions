class MinStack {
    class Pair{
        int ele;
        int min;
        Pair(int ele,int min){
            this.ele = ele;
            this.min = min;
        }
    }
    Stack<Pair> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.size() == 0)
        st.push(new Pair(val,val));
        else{
            if(st.peek().min > val){
                st.push(new Pair(val,val));
            }
            else{
                st.push(new Pair(val,st.peek().min));
            }
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().ele;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */