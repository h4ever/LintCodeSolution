package solutions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ModifyMapKey {
    public static void main(String[] args) {
        Map<String,Object> a = new HashMap<>();
        a.put("key1","value1");
        a.put("key2","value2");
        Iterator<Map.Entry<String,Object>> iter = a.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String,Object> entry = iter.next();
            String key = entry.getKey();
            //a.put(transferKey(key),entry.getValue());
            iter.remove();
        }
        System.out.println(a.toString());
    }

    public static String transferKey(String key){
        return key+"_";
    }
}
