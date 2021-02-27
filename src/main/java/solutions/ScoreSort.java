package main.java.solutions;

import java.util.*;
import java.util.stream.Collectors;

public class ScoreSort {
    /*
    查找和排序
题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
都按先录入排列在前的规则处理。

例示：
jack      70
peter     96
Tom       70
smith     67

从高到低  成绩
peter     96
jack      70
Tom       70
smith     67

从低到高
smith     67
jack      70
Tom       70
peter     96

注：0代表从高到低，1代表从低到高

本题含有多组输入数据！
     */
    public static void main(String[] args) {
        approach2(new Scanner(System.in));
    }


    private static void approach2(Scanner sc){
        while(sc.hasNextInt()) {
            int size = sc.nextInt();
            int dir = sc.nextInt();
            String[] names = new String[size];
            int[] scores = new int[size];
            for(int i=0;i<size;i++){
                names[i]=sc.next();
                scores[i]=sc.nextInt();
            }
            if(dir==0) sortByScoreDesc(scores,names,size);
            else sortByScoreAsc(scores,names,size);

            printRes(scores,names,size);
        }
    }

    private static void printRes(int[] scores,String[] names,int size){
        for(int i=0;i<size;i++){
            System.out.println(names[i]+" "+scores[i]);
        }
    }

    private static void sortByScoreAsc(int[] scores,String[] names,int size){
        for(int i=0;i<size;i++){
            for(int j=0;j<size-i-1;j++){
                if(scores[j]>scores[j+1]){
                    swap(scores,j,j+1);
                    swap(names,j,j+1);
                }
            }
        }
    }

    private static void sortByScoreDesc(int[] scores,String[] names,int size){
        for(int i=0;i<size;i++){
            for(int j=0;j<size-i-1;j++){
                if(scores[j]<scores[j+1]){
                    swap(scores,j,j+1);
                    swap(names,j,j+1);
                }
            }
        }
    }

    private static void swap(int[] scores ,int l,int r){
        int tmpS = scores[l];
        scores[l] = scores[r];
        scores[r] = tmpS;
    }

    private static void swap(String[] names ,int l,int r){
        String tmpName = names[l];
        names[l] = names[r];
        names[r] = tmpName;
    }

    private static void approach1(Scanner sc){
        while(sc.hasNextInt()){
            int size = sc.nextInt();
            int dir = sc.nextInt();
            Map<Integer,List<String>> data = gatherInfo(sc,size);
            Map<Integer, List<String>> sorted =
                    data.entrySet().stream().sorted(dir==1?Map.Entry.comparingByKey():Collections.reverseOrder(Map.Entry.comparingByKey()))
                            .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e2,LinkedHashMap::new));
            printRes(sorted);
        }
    }

    private static Map<Integer,List<String>> gatherInfo(Scanner sc,int size){
        Map<Integer, List<String>> data = new HashMap<>();
        for(int i=0;i<size;i++){
            String name = sc.next();
            int score = sc.nextInt();
            if(data.containsKey(score)){
                data.get(score).add(name);
            }else{
                List<String> nameList = new ArrayList<>();
                nameList.add(name);
                data.put(score,nameList);
            }
        }
        return data;
    }

    private static void printRes(Map<Integer, List<String>> sorted){
        for(Integer score:sorted.keySet()){
            for(String name:sorted.get(score)){
                System.out.println(name+" "+score);
            }
        }
    }

}
