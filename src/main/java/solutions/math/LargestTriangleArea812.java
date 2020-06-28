package main.java.solutions.math;


public class LargestTriangleArea812 {
    public static double largestTriangleArea(int[][] points) {
        double ans = 0;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                for(int k=j+1;k<points.length;k++){
                    if(isTriangle(points[i],points[j],points[k])){
                        ans = Math.max(ans,areaOfTriangle(points[i],points[j],points[k]));
                    }
                }
            }
        }
        return ans;
    }

    public static boolean isTriangle(int[] point1,int[] point2,int[] point3){
        if(point1[0]!=point2[0]&&point2[0]!=point3[0]){
            double k1 = (double) (point2[1]-point1[1])/(point2[0]-point1[0]);
            double k2 = (double) (point3[1]-point2[1])/(point3[0]-point2[0]);
            if(k1==k2) return false;
            else return true;
        }else if(point1[0]==point2[0]&&point1[0]==point3[0]){
            return false;
        }
        return true;
    }

    public static boolean isTriangle2(int[] point1,int[] point2,int[] point3){
        return (point2[0]-point1[0])*(point3[1]-point2[1])!=(point3[0]-point2[0])*(point2[1]-point1[1]);
    }

    public static  double areaOfTriangle(int[] point1,int[] point2,int[] point3){
        double area =   Math.abs(point1[0]*point2[1]+point2[0]*point3[1]+point3[0]*point1[1]
        -point1[1]*point2[0]-point2[1]*point3[0]-point3[1]*point1[0]);
        return area/2;
    }

    public static void main(String[] args) {
        int[][] points = {{10,7},{0,4},{5,7}};
        System.out.println(isTriangle(points[0],points[1],points[2]));

    }
}
