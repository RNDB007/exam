package main;


import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String[] split = s.split(",");
        int[] arr = new int[split.length];
        for(int i = 0;i<split.length;i++){
            arr[i] = Integer.parseInt(split[i]);
        }
        //排序使得下标*数字的总和最大
        Arrays.sort(arr);
        int ans = 0;
        for(int i = 0;i<arr.length;i++){
            ans += (i+1)*arr[i];
        }
        System.out.println(ans);
    }
}