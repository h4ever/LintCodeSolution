package main.java.solutions.hashtable;

public class DesignHashMap2 {
    final ListNode[] buckets;
    int cap = 1000;
    /** Initialize your data structure here. */
    public DesignHashMap2() {
        buckets = new ListNode[cap];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = key%cap;
        if(buckets[h]==null){
            buckets[h] = new ListNode(key,value);
            return;
        }
        ListNode p = find(buckets[h],key);
        if(p==null){
            ListNode next = buckets[h];
            buckets[h] = new ListNode(key,value);
            buckets[h].next = next;
            next.prev = buckets[h];
        }else{
            p.val = value;
        }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = key%cap;
        ListNode e = find(buckets[h],key);
        return e==null?-1:e.val;
    }

    public ListNode find(ListNode bucket,int key){
        ListNode p = bucket ;
        while(p!=null&&p.key!=key){
            p = p.next;
        }
        return p;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h = key%cap;
        ListNode e = find(buckets[h],key);
        if(e!=null){
            if(e.prev==null) {
                buckets[h] = e.next;
                if(e.next!=null) e.next.prev = null;
                return;
            }
            if(e.next==null){
                e.prev.next=null;
            }else{
                e.prev.next = e.next;
                e.next.prev = e.prev;
            }
        }
    }

    class ListNode {
        int key,val;
        ListNode next;
        ListNode prev;
        public ListNode(int key ,int val){
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        DesignHashMap2 test = new DesignHashMap2();
        test.put(1,2);
        test.put(2,6);
        test.put(8,100000);
        test.get(2);
        test.remove(8);
        test.put(2,8);
        test.put(10002,8);
        test.put(20002,9);
        test.remove(20002);
        System.out.println(Math.log(10)/Math.log(2));
    }
}
