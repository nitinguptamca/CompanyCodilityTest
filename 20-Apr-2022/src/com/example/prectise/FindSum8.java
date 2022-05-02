package com.example.prectise;

import java.util.ArrayList;
import java.util.List;

/**
 * problem statement We have sorted array find all possible combination of sum 8
 * like int[] sorted array ={-3,-2,-1,0,2,3,4,5,7,8,10,11} then possible
 * combination is {-3,11}{-2,10}{0,8}{3,5}
 *
 * @author nitin
 */

public class FindSum8 {
    static int[] sorted_array = {-3, -2, -1, 0, 2, 3, 4, 5, 7, 8, 10, 11};

    public static void main(String[] args) {
        List<List<Integer>> findSums = getAllSum8(sorted_array);
        for (List<Integer>  sdsd: findSums   ) {
            System.out.println(sdsd);
        }
    }


    private static List<List<Integer>> getAllSum8(int[] array) {

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if ((array[i] + array[j]) == 8 && i != j) {
                    List<Integer> sumLists = new ArrayList<>();
                    sumLists.add(array[i]);
                    sumLists.add(array[j]);
                    list.add(sumLists);
                }
            }
        }
        return list;
    }
}
