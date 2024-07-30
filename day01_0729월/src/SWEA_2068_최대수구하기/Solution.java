package SWEA_2068_최대수구하기 ;

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t =1; t<=T; t++) {
            int result = 0;
            int counter = 10;
            while (counter-- > 0) {
                result = Math.max(result, sc.nextInt());
            }
            
            System.out.println("#" + t + " " + result);
        }
    }
}