package com.learn.algorithms.heap;

/*
Frequency Sort (medium)
Given a string, sort it based on the decreasing frequency of its characters.
Input: "Programming"
Output: "rrggmmPiano"
Explanation: 'r', 'g', and 'm' appeared twice, so they need to appear before any other character.
Input: "abcbab"
Output: "bbbaac"
Explanation: 'b' appeared three times, 'a' appeared twice, and 'c' appeared only once.
 */

import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        String s = new String("Programming");
        System.out.println(frequencySort(s));
        String s1 = new String("abcbab");
        System.out.println(frequencySort(s1));
        String s2 = new String("hfiubvkiriooyvjfirovndjri");
        System.out.println(frequencySort(s2));

        System.out.println(s);
    }

    public static String frequencySort(String s) {

        char[] ch = s.toCharArray();
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : ch) {
            if (frequencyMap.containsKey(c)) {
                int count = frequencyMap.get(c) + 1;
                frequencyMap.put(c, count);
            } else {
                frequencyMap.put(c, 1);
            }
        }

        PriorityQueue<Freq> maxHeap = new PriorityQueue<>((a, b) -> b.count - a.count);

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            maxHeap.add(new Freq(entry.getKey(), entry.getValue()));
        }
        String result = "";
        while (!maxHeap.isEmpty()) {
            Freq freq = maxHeap.poll();
            for (int i = 0; i < freq.count; i++) {
                result = result + freq.c;
            }

        }
        return result;
    }
}

class Freq {
    char c;
    int count;

    public Freq(char c, int count) {
        this.c = c;
        this.count = count;
    }

    @Override
    public String toString() {
        return "[" + c + ", " + count + "]";
    }
}


