package com.homeng.sort_algorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class QuickSort {

    public static int[] sort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end)
            return null;
        // 分区（割）指示器
        int zoneIndex = partition(array, start, end);
        if (zoneIndex > start) {
            sort(array, start, zoneIndex -1);
        }
        if (zoneIndex < end) {
            sort(array, zoneIndex + 1, end);
        }
        System.out.printf("");
        return array;
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int zoneIndex = start - 1;
        //交换了基准数和尾元素的位置
        swap(array, pivot, end);
        for (int i = start; i<= end; i++) {
            if(array[i] <= array[end]) {
                zoneIndex++;
                if (i > zoneIndex) {
                    swap(array, i, zoneIndex);
                }
            }
        }
        return zoneIndex;
    }

    /**
     * 交换两个数组元素位置
     * @param array 需要交换的原数组
     * @param i 交换元素的位置
     * @param j 需要交换的元素位置
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void fizzBuzz(int n) {
        // Write your code here
        if (n%3==0 && n%5==0) {
            System.out.printf("FizzBuzz");
        } else if (n%3==0 && n%5!=0) {
            System.out.printf("Fizz");
        }else if (n%3!=0 && n%5==0) {
            System.out.printf("Buzz");
        }else{
            System.out.printf(String.valueOf(n));
        }
    }
    public static String isPangram(List<String> pangram) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < pangram.size(); i++) {
            String word = pangram.get(i);
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                Integer index = Character.getNumericValue(c);
                if (index>=97 && index<=122 && !result.contains(index)) {
                    result.add(index);
                }
            }

        }
        return result.size() == 26 ? "1" : "0";
    }

    public static void main(String[] args) throws IOException {
        PrintArray.print(PrintArray.SRC);
        System.out.println("===============================================================================");
        int[] dest = QuickSort.sort(PrintArray.SRC, 0, PrintArray.SRC.length -1);
        PrintArray.print(dest);
    }
}
