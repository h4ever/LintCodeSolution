package demo;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] a){

        quickSort(a,0,a.length-1);
    }

    public static void quickSort(int[] a,int left,int right){
        if(left>right){
            return;
        }
        int i = left,j=right,pivot = a[right];
        while(i<j){
            while(a[j]>=pivot&&i<j){
                j--;
            }


            while(a[i]<=pivot&&i<j){
                i++;
            }

            if(i<j){
                swap(a,i,j);
            }
        }
        swap(a,right,i);
        quickSort(a,left,i-1);
        quickSort(a,i+1,right);

    }

    public static void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }




    /**
     * 双轴快速排序算法
     * @param arr 待排序数组
     */
    public static void dualPivotQuickSort(int[] arr) {
        //启动双轴快速排序
        dualPivotQuickSort(arr, 0, arr.length - 1);
    }

    /**
     * 双轴快速排序递归算法
     * @param arr 待排序数组
     * @param start 排序范围左下标
     * @param end 排序范围右下标
     */
    private static void dualPivotQuickSort(int[] arr, int start, int end) {
        //下标不等才进行排序，相等则只有一个元素，不用排序
        if (start < end) {

            //如果最左边的元素比最右边的元素大
            if (arr[start] > arr[end]) {

                //将之交换，最左边要不大于最右边
                swap(arr, start, end);
            }

            //第一个排序轴为最左边的元素
            int pivot1 = arr[start];

            //第二个排序轴为最右边的元素
            int pivot2 = arr[end];

            //设置i为首部下标（左哨兵）
            int i = start;

            //设置j为尾部下标（右哨兵）
            int j = end;

            //设置k为首部的下一个的下标，表示当前值（移动哨兵）
            int k = start + 1;

            //当k没有到达尾部，持续循环
            //保持这样的状态：小 i 中 j 大
            OUT_LOOP: while (k < j) {

                //当前值如果小于左排序轴
                if (arr[k] < pivot1) {

                    //将当前值放在i的左边，i向右移动，k继续下一个
                    //也就是将arr[k]放在i的左边
                    swap(arr, ++i, k++);

                    //如果当前值在两个排序轴的中间
                } else if (arr[k] <= pivot2) {

                    //arr[k]保持在中间，k往右移
                    k++;

                    //如果当前值大于右排序轴
                } else {

                    //将j一直向左移动，只要碰到比他大的
                    while (arr[--j] > pivot2) {

                        //移动哨兵已经到了或超过右边界，扫描终止
                        if (j <= k) {

                            //跳回到标志位OUT_LOOP
                            break OUT_LOOP;
                        }
                    }

                    //如果遇到的第一个比arr[j]小的比做排序轴还小
                    if (arr[j] < pivot1) {

                        //两次交换放到i的左边，i往后移动
                        swap(arr, j, k);
                        swap(arr, ++i, k);

                        //如果遇到的第一个比arr[j]小的是在中间
                    } else {

                        //k和j交换，放在k的左边
                        swap(arr, j, k);
                    }

                    //k往右移
                    k++;
                }
            }

            //最后再让标志位还原初始值
            swap(arr, start, i);
            swap(arr, end, j);

            //递归双轴快排左边的区域
            dualPivotQuickSort(arr, start, i - 1);

            //递归双轴快排中间的区域
            dualPivotQuickSort(arr, i + 1, j - 1);

            //递归双轴快排右边的区域
            dualPivotQuickSort(arr, j + 1, end);
        }
    }



    /**
     * 测试双轴快速排序
     * @param args
     */
    public static void main(String[] args) {
        //待排序数组有30个元素
        int[] arr = new int[30];

        //随机数类
        Random random = new Random();

        //初始化生成100以内的随机数
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.println("双轴快排前：" + Arrays.toString(arr));

        //调用双轴快速排序算法
        dualPivotQuickSort(arr);

        System.out.println("双轴快排后：" + Arrays.toString(arr));
    }


}
