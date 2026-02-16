package org.example;

import java.util.Arrays;

public class ArrayStats {


    public int MIN (int[] arrays) throws Exception {
        if(arrays.length == 0) throw new Exception("Пустой массив");
        int min = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            if(min > arrays[i]){
                min = arrays[i];
            }
        }
        return min;
    }
    public int MAX (int[] arrays) throws Exception {
        if(arrays.length == 0) throw new Exception("Пустой массив");
        int max = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            if(max < arrays[i]){
                max = arrays[i];
            }
        }
        return max;
    }

    public float AVERAGE (int[] arrays) throws Exception {
        if(arrays.length == 0) throw new Exception("Пустой массив");
        int sum = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            sum += arrays[i];
        }
        return (float) sum /arrays.length;
    }

    public float MEDIAN (int[] arrays) throws Exception {
        if(arrays.length == 0) throw new Exception("Пустой массив");
        Arrays.sort(arrays);
        if(arrays.length % 2 == 0){
            return (float) arrays[arrays.length/2];
        }
        return (float) ((arrays[arrays.length/2] + arrays[(arrays.length/2)+1])/2);
    }
}
