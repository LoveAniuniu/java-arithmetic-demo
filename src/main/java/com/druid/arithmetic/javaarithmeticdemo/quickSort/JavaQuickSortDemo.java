package com.druid.arithmetic.javaarithmeticdemo.quickSort;

public class JavaQuickSortDemo {
    // 时间复杂度 O(nlogn)

    public static void quickSort(int[] arr, int left ,int right){
        int l= left;//左下标
        int r = right;//右下标
        int pivot =arr[(left+right)/2];//中轴值
        int temp=0;//辅助变量,交换数据时使用
        //while循环的作用是让比pivot值小的放在左边,比pivot值大的放在右边
        while (l<r){
            // 在pivot的左边一直找, 找到大于等于pivot的值才退出
            // 作用是找到不符合条件的元素,进行元素交换
            while (arr[l]<pivot){
                l+=1;//作用是一直找
            }
            // 在pivot的右边一直找, 找到小于pivot的值才退出
            while (arr[r]>pivot){
                r -= 1;
            }
            //如果l>=r,说明指针已经从左边移动找pivot,或者它的右边.因此pivot的左右两的值,已按照规律排序
            //即: 左边都是小于pivot的值, 右边都是大于pivot的值
            if (l>=r){
                break;
            }
            //交换元素
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if(arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if(arr[r] == pivot) {
                l += 1;
            }
        }
        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if(left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if(right > l) {
            quickSort(arr, l, right);
        }



    }

    public static void main(String[] args) {

        int[] data={-9,78,0,23,-567,70};

        JavaQuickSortDemo.quickSort(data, 0, 5);

        for (int i : data) {
            System.out.println(i);
        }
    }
}