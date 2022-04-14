package nowcoder.linkedlist;

import java.util.*;

class LRUCacheV2 {
    LinkedHashMap<Integer,Integer> data;
    private static final  float hashLoadFactor = 0.75f;

    int cacheSize;
    public LRUCacheV2(int cacheSize) {
        this.cacheSize = cacheSize;
        int capacity = (int)Math.ceil(cacheSize/hashLoadFactor)+1;
        data = new LinkedHashMap<Integer, Integer>(capacity,hashLoadFactor,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > cacheSize;
            }
        };
    }

    public int get(int key) {
        if(data.containsKey(key))
        return data.get(key);
        return -1;
    }

    public void put(int key, int value) {
        data.put(key,value);
    }



}

public class LRUSolutionV2 {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        List<Integer> list = new ArrayList<>();
        LRUCacheV2 lru = new LRUCacheV2(k);
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
