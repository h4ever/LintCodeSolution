package solutions.top100liked;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LRUCache146Test {
    public static int[] LRU (int[][] operators, int k) {
        List<Integer> list = new ArrayList<>();
        LRUCache146 lru = new LRUCache146(k);
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

    public static void main(String[] args) {
        int[][] operators = {{1,1,1},{1,2,2},{2,1}};
        int[] res = LRU(operators,2);
        System.out.println(res[0]);
    }
}
