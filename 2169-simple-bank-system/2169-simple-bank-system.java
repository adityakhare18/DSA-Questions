class Bank {
    HashMap<Integer,Long> map ;

    public Bank(long[] balance) {
        map = new HashMap<>();
        for(int i=0;i<balance.length;i++){
            map.put(i+1,balance[i]);
        }
    }
    
    public boolean transfer(int a1, int a2, long money) {
        if(map.containsKey(a1) && map.containsKey(a2) && map.get(a1) >= money){
            map.put(a1,map.get(a1)-money);
            map.put(a2,map.get(a2)+money);
            return true;
        }
        else
        return false;
    }
    
    public boolean deposit(int a, long money) {
        if(map.containsKey(a)){
            map.put(a,map.get(a)+money);
            return true;
        }
        else
        return false;
    }
    
    public boolean withdraw(int a, long money) {
        if(map.containsKey(a) && map.get(a) >= money){
            map.put(a,map.get(a)-money);
            return true;
        }
        else
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */