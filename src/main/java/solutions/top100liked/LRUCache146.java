package solutions.top100liked;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {
    class LRUCacheNode {
        public int k,v;
        public LRUCacheNode l,r;
        LRUCacheNode(int k,int v){
            this.k = k;
            this.v = v;
        }
    }

    Map<Integer,LRUCacheNode> data;
    int capacity;
    LRUCacheNode head ,tail;

    public LRUCache146(int capacity) {
        head = new LRUCacheNode(-1,-1);
        tail =  new LRUCacheNode(-1,-1);
        head.r = tail;
        tail.l = head;
        data = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if(data.containsKey(key)){
            LRUCacheNode node = data.get(key);
            delete(node);
            use(node);
            return node.v;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(data.containsKey(key)){
            LRUCacheNode node = data.get(key);
            delete(node);
            use(node);
            node.v = value;
        }else{
            if(data.size()>=capacity){
                data.remove(tail.l.k);
                delete(tail.l);
            }
            LRUCacheNode newNode = new LRUCacheNode(key,value);
            data.put(key,newNode);
            use(newNode);
        }
    }

    private void delete(LRUCacheNode node){
        node.l.r = node.r;
        node.r.l = node.l;
    }

    private void use(LRUCacheNode node){
        LRUCacheNode tmp = head.r;
        tmp.l = node;
        node.r = tmp;
        node.l = head;
        head.r = node;
    }
}
