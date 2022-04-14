package solutions.hashtable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DesignHashSet705 {
    List<Integer>[] container = null;
    int cap = 1000;
    double loadFactor = 0.75;
    int count = 0;
    /** Initialize your data structure here. */
    public DesignHashSet705() {
        container = new LinkedList[cap];
    }

    public void add(int key) {
        if(contains(key)) return;
        rehash();
        int hash = myhash(key);
        if(container[hash] == null)
            container[hash] = new LinkedList<>();
        container[hash].add(key);
        ++count;
    }

    private int myhash(int key){
        return key%cap;
    }

    private  void rehash(){
        if(loadFactor*cap == count){
            count = 0;
            //rehash
            cap *= 2;
            List<Integer>[] oldC = container;
            container = new LinkedList[cap];
            for (List<Integer> list : oldC) {
                if (list != null) {
                    for (int entry : list)
                        this.add(entry);
                }
            }
        }
    }

    public void remove(int key) {
        int hash = myhash(key);
        List<Integer> list = container[hash];
        if(list != null){
            Iterator<Integer> itr = list.iterator();
            while(itr.hasNext())
                if(itr.next() == key){
                    itr.remove();
                    --count;
                }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = key % cap;
        List<Integer> list = container[hash];
        if(list != null){
            for (Integer integer : list)
                if (integer == key)
                    return true;
        }
        return false;
    }

    public static void main(String[] args) {
        DesignHashSet705 hashSet = new DesignHashSet705();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));// returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));
    }

}
