package com.learn.algorithms.contests;

import java.util.Arrays;
import java.util.Comparator;

public class NumberofWinningPlayers {
    public static void main(String[] args) {
        int n = 4;
        int[][] pick = {{0,0},{1,0},{1,0},{2,1},{2,1},{2,0}};
        System.out.println(winningPlayerCount(4, pick));
        int n1 = 5;
        int[][] pick1 = {{1,1},{1,2},{1,3},{1,4}};
        System.out.println(winningPlayerCount(5, pick1));
        int[][] pick2 = {{1,1},{2,4},{2,4},{2,4}};
        System.out.println(winningPlayerCount(5, pick2));

    }

    public static int winningPlayerCount(int n, int[][] pick) {

        Arrays.sort(pick, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                int a, b;
                a = Integer.valueOf(entry1[0]);
                b = Integer.valueOf(entry2[0]);
                if (a == b) {
                    return Integer.compare(entry1[1], entry2[1]);
                }
                else if (a > b) {
                    return 1;
                }
                return  -1;
            }
        });

        int answer = 0;
        int i = 0;
        while (i < pick.length) {
            int player = pick[i][0];
            int color = pick[i][1];
            int score = 0;
            boolean isSet = false;
            while (i < pick.length && pick[i][0] == player) {
                if (pick[i][1] == color) {
                    score++;
                } else if (score > player && !isSet) {
                    answer++;
                    score = 1;
                    color = pick[i][1];
                    isSet = true;
                }
                else {
                    color  = pick[i][1];
                    score = 1;
                }
                i++;
            }
            if (score > player && !isSet) {
                answer++;
            }
        }
        return answer;
    }
}
