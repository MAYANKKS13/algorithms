package com.learn.algorithms.mergeintervals;

/*
Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
Example 1:

Intervals: [[1,4], [2,5], [7,9]]
Output: [[1,5], [7,9]]
Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
one [1,5].
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(new Interval(2, 3));
        intervalList.add(new Interval(5, 7));
        intervalList.add(new Interval(1, 4));
        intervalList.add(new Interval(19, 22));
        intervalList.add(new Interval(8, 20));
//        intervalList.add(new Interval(8, 14));
//        System.out.println(intervalList);

        System.out.println(merge(intervalList));
    }

    public static List<Interval> merge(List<Interval> intervalList) {

        if (intervalList == null || intervalList.size() <= 1) {
            return intervalList;
        }
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


//
//  for (int i = 0; i < intervalList.size(); i++) {
//        int start = intervalList.get(0).start;
//        int end = intervalList.get(0).end;
//        int j;
//        for (j = i+1; j < intervalList.size()-1; j++) {
//        if (intervalList.get(j).start <= end) {
//        end = Math.max(intervalList.get(j).end, end);
//        result.add(new Interval(start, intervalList.get(j).end));
//        } else {
//
//        }
//        }result.add(new Interval(intervalList.get(i).start, intervalList.get(j).end));
//        }


