package solutions.carl.array;

public class BinarySearch {
    public static int lowerBound(int[] a, int target){
        int l=0,r=a.length;
        while(l<r){
            int m = l + ((r-l)>>1);
            if(a[m]<target){
                l=m+1;
            }else{
                r=m;
            }
        }
        return l;
    }

    public static int upperBound(int[] a, int target){
        int l=0,r=a.length;
        while(l<r){
            int m = l + ((r-l)>>1);
            if(a[m]<=target){
                l=m+1;
            }else{
                r=m;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] a = {1,4,4,5,5,5,5,7,8};
        System.out.println(lowerBound(a,5));
        System.out.println(upperBound(a,5));
    }
}
