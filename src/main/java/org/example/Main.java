package org.example;

import java.sql.Array;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws Exception {
        int[] aray = new int[]{1,7,5,8,15,47,24, 2};
        ArrayStats test = new ArrayStats();
        System.out.println(test.MIN(aray));
        System.out.println(test.MAX(aray));
        System.out.println(test.AVERAGE(aray));
        System.out.println(test.MEDIAN(aray));
    }
}
