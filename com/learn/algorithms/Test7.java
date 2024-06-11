package com.learn.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test7 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,3,5,7,3));
        addAtBeginning(list,9);
        addAtEnd(list, 66);
        System.out.println(list);

    }

    public static void addAtEnd(List<Integer> list, int i){
        list.add(i);
    }
    public static void addAtBeginning(List<Integer> list, int i){
        Collections.reverse(list);
        list.add(i);
        Collections.reverse(list);
    }
}
