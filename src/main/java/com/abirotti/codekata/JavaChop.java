package com.abirotti.codekata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andrea.birotti on 18/04/2014.
 */
public class JavaChop {

    /**
     * Imperative with pivot
     * 
     * */
    public int chop(int integer, List<Integer> arr) {
        if ( arr == null) {
            throw new IllegalArgumentException("Provide two not-null arguments");
        }
        int start = 0;
        int end = arr.size() - 1;
        while (end >= start ) {
            int middle = middle(start, end);
            if (arr.get(middle) > integer) {
                end = middle - 1;
            } else if (arr.get(middle) < integer) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public Integer middle (Integer a, Integer b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Provide two not-null arguments");
        }
        return a + (b - a) / 2;
    }
}
