class LRUCache {
     class Node{
        int k;
        int v;
        Node next , prev;
        Node(int k,int v){
            this.k = k;
            this.v = v;
            next = prev = null;
        }
    }
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int limit;
    HashMap<Integer,Node> map;
    

    public LRUCache(int capacity) {
        limit = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            int ans = map.get(key).v;
            deleteNode(map.get(key));
            addNode(map.get(key));
            return ans;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node oldNode = map.get(key);
            deleteNode(oldNode);
        }
        else if(map.size() >= limit){
            Node lru = tail.prev;
            map.remove(lru.k); // ✅ Remove LRU key
            deleteNode(lru);
        }
        Node newNode = new Node(key,value);
        addNode(newNode);
        map.put(key,newNode);
    }

    public void addNode(Node node){
        Node oldNext = head.next;
        head.next = node;
        oldNext.prev = node;
        node.next = oldNext;
        node.prev = head;
    }
    public void deleteNode(Node node){
        Node oldPrev = node.prev;
        Node oldNext = node.next;

        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */