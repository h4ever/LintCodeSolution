package main.java.solutions.string;


import java.util.*;

public class DestinationCity1436 {
    public static String destCity(List<List<String>> paths) {
        Set<String> starts = new HashSet<>();
        Set<String> ends = new HashSet<>();
        for(List<String> trip:paths){
            if(starts.contains(trip.get(1))) starts.remove(trip.get(1));
            else ends.add(trip.get(1));

            if(ends.contains(trip.get(0))) ends.remove(trip.get(0));
            else starts.add(trip.get(0));
        }

        return ends.iterator().next();
    }


    public static String destCity3(List<List<String>> paths) {
        List<String> path = new LinkedList<>();
        path.add(paths.get(0).get(0));
        path.add(paths.get(0).get(1));
        paths.remove(0);

        while(!paths.isEmpty()){
            Iterator<List<String>> iterator = paths.iterator();
            while(iterator.hasNext()){
                List<String> trip = iterator.next();
                String startCity = trip.get(0);
                String endCity = trip.get(1);
                if(path.get(0).equals(endCity)){
                    path.add(0,startCity);
                    iterator.remove();

                }
                if(path.get(path.size()-1).equals(startCity)){
                    path.add(endCity);
                    iterator.remove();
                }
            }
        }
        return path.toString();
    }


    public static void main(String[] args) {
        List<String> trip1 = new ArrayList<>(Arrays.asList("qMTSlfgZlC","ePvzZaqLXj"));
        List<String> trip2 = new ArrayList<>(Arrays.asList("xKhZXfuBeC","TtnllZpKKg"));
        List<String> trip3 = new ArrayList<>(Arrays.asList("ePvzZaqLXj","sxrvXFcqgG"));
        List<String> trip4 = new ArrayList<>(Arrays.asList("sxrvXFcqgG","xKhZXfuBeC"));
        List<String> trip5 = new ArrayList<>(Arrays.asList("TtnllZpKKg","OAxMijOZgW"));

        List<List<String>> paths = new ArrayList<>();
        paths.add(trip2);paths.add(trip1);paths.add(trip3);
        paths.add(trip4);paths.add(trip5);

        System.out.println(destCity3(paths));
    }
}
