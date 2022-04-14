package nowcoder.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUTest {
    public int[] LRU (int[][] operators, int k) {
        List<Integer> list = new ArrayList<>();
        LRUData lru = new LRUData(k);
        for (int[] op : operators) {
            int type = op[0];
            if (type == 1) {
                // set(k,v) 操作
                lru.put(op[1], op[2]);
            } else {
                // get(k) 操作
                list.add(lru.get(op[1]));
            }
        }
        int n = list.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = list.get(i);
        return ans;
    }

}

class LRUData{
    static class LRUListNode{
        int key;
        int val;
        LRUListNode prev,next;
        LRUListNode(int k,int v){
            key=k;
            val=v;
        }
    }
    LRUListNode head = new LRUListNode(-1,-1);
    LRUListNode tail = new LRUListNode(-1,-1);
    Map<Integer,LRUListNode> listMap = new HashMap<>();
    int size;
    LRUData(int size){
        this.size = size;
        head.prev=null;
        head.next=tail;
        tail.next=null;
        tail.prev=head;
    }

    int get(int key){
        if(listMap.containsKey(key)){
            LRUListNode node = listMap.get(key);
            refresh(node);
            return node.val;
        }
        return -1;
    }

    void put(int key ,int val){
        if(listMap.containsKey(key)){
            LRUListNode node = listMap.get(key);
            node.val = val;
            refresh(node);
        }else{
            if(listMap.size()==size){
                LRUListNode last = tail.prev;
                listMap.remove(last.key);
                delete(last);
            }
            LRUListNode node = new LRUListNode(key,val);
            offer(node);
            listMap.put(key,node);
        }
    }

    public void refresh(LRUListNode node){
        delete(node);
        offer(node);
    }

    public void offer(LRUListNode node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void delete(LRUListNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        node.prev=null;
        node.next=null;
    }
}
