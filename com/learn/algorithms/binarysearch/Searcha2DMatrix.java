package com.learn.algorithms.binarysearch;

public class Searcha2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 18}, {20, 26, 30, 34}};
        int[][] matrix1 = {{1,3}, {5,12}, {13,16}, {26,27}};
        System.out.println(search2D(matrix, 37));
        System.out.println(search2D(matrix1, 13));

    }

    public static boolean search2D(int[][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0, end = (row * col) - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            int number = matrix[mid/col][mid%col]; //This is the main part here. It is the same as arr[mid] in a 1D array.
            if(number == target){
                return true;
            } else if (number < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return  false;
    }
}
