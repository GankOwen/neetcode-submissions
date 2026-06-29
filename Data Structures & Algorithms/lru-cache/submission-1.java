class LRUCache {

    private class Node {
        int key, val;
        Node prev, next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private static int capacity;
    Map<Integer, Node> map;
    private Node dummyHead, dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dummyHead = new Node(0, 0);
        this.dummyTail = new Node(0, 0);
        this.dummyHead.next = this.dummyTail;
        this.dummyTail.prev = this.dummyHead;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node valNode = map.get(key);
        remove(valNode);
        insertToHead(valNode);
        return valNode.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node valNode = map.get(key);
            valNode.val = value;
            remove(valNode);
            insertToHead(valNode);
        }else{
            if(map.size() == this.capacity){
                Node lru = this.dummyTail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertToHead(newNode);
        }
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToHead (Node node){
        node.prev = this.dummyHead;
        node.next = this.dummyHead.next;
        this.dummyHead.next.prev = node;
        this.dummyHead.next = node;
    }
}
