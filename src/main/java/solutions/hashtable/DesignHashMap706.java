package solutions.hashtable;

public class DesignHashMap706 {
    final ListNode[] buckets;
    int cap = 1000;

    public DesignHashMap706() {
        buckets = new ListNode[cap];
    }


    public void put(int key, int value) {
        int h = hash(key);
        if(buckets[h]==null) buckets[h] = new ListNode(-1,-1);
        ListNode prev = find(buckets[h],key);
        if(prev.next==null){
            prev.next=new ListNode(key,value);
        }else{
            prev.next.val = value;
        }
    }

    public int get(int key) {
        int h = hash(key);
        if(buckets[h]==null) return -1;
        ListNode prev = find(buckets[h],key);
        return prev.next==null?-1:prev.next.val;
    }

    public void remove(int key) {
        int h = hash(key);
        if(buckets[h]==null) return ;
        ListNode prev = find(buckets[h],key);
        if(prev.next!=null){
            prev.next = prev.next.next;
        }
    }

    int hash(int key) {
        return key % cap;
    }

    ListNode find(ListNode bucket, int key) {
        ListNode p = bucket, prev = null;
        while(p!=null&&p.key!=key){
            prev = p;
            p = p.next;
        }
        return prev;
    }

    class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
