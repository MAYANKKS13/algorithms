package com.learn.algorithms.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeAddingNewInterval {
    public static void main(String[] args) {

        List<Interval> intervalList = new ArrayList<>();
//        intervalList.add(new Interval(1,5));
//        intervalList.add(new Interval(7, 9));
//        Interval interval = new Interval(11,15);

        intervalList.add(new Interval(1, 6));
        intervalList.add(new Interval(8, 10));
        Interval interval = new Interval(4, 7);

        System.out.println(mergeAfterAdding(intervalList, interval));

    }
    public static List<Interval> mergeAfterAdding(List<Interval> intervalList, Interval newInterval) {

        intervalList.add(newInterval);
        Collections.sort(intervalList, (a, b) -> a.start - b.start);
        List<Interval> result = new ArrayList<>();
        int start = intervalList.get(0).start;
        int end = intervalList.get(0).end;
        for (int i = 1; i < intervalList.size(); i++) {
            if (intervalList.get(i).start <= end) {
                end = Math.max(intervalList.get(i).end, end);
            } else {
                result.add(new Interval(start, end));
                start = intervalList.get(i).start;
                end = intervalList.get(i).end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }

}
