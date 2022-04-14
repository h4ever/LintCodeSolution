package solutions;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class CharacterStatistics {
    /*
    输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。
本题含有多组样例输入
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            System.out.println(printRes(sc.next()));
        }
    }

    private static String printRes(String s){
        Map<Character,Integer> m = new HashMap<>();
        for(int i=0;i<s.length();i++){
            m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
        }
        Map<Character,Integer> sorted = m.entrySet().stream().sorted((o1, o2) -> {
            if(o1.getValue()==o2.getValue()){
                return o1.getKey().compareTo(o2.getKey());
            }else{
                return -(o1.getValue().compareTo(o2.getValue()));
            }
        }).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));
        StringBuilder res = new StringBuilder();
        for(Character ch:sorted.keySet()){
            res.append(ch);
        }
        return res.toString();
    }

}
