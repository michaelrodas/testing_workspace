package com.internal.experimental.ocp8.exercises;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
    	/*
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        */
    	
    	int arr[][] = {{-1, -1, 0 ,-9, -2, -2 },
    				  {-2 ,-1 ,-6 ,-8, -2 ,-5},
    				  {-1 ,-1, -1, -2, -3 ,-4},
    				  {-1 ,-9 ,-2 ,-4 ,-4 ,-5},
    				  {-7 ,-3, -3, -2, -9, -9},
    				  {-1 ,-3 ,-1 ,-2 ,-4 ,-5}};
        int maxSum = calculateMaxSum(arr);
        System.out.println(maxSum);
    }
    
    public static int calculateMaxSum(int arr[][]){
        int finalSum = Integer.MIN_VALUE;
        int hourglassSum = 0;
        for(int i=0; i < arr.length-2; i++){
            for(int j=0; j < arr.length-2; j++){
                hourglassSum += arr[i][j] + arr[i][j+1] + arr[i][j+2]
                						+ arr[i+1][j+1]
                			+ arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
               
                	if(hourglassSum > finalSum)
                        finalSum = hourglassSum;
                
                hourglassSum = 0;
            }
        }
        return finalSum;
    }
}

