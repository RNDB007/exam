package main;



import java.lang.reflect.Array;
import java.util.*;


class Solution {
    int[] ans = new int[38];

    public int tribonacci(int n) {
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 1;
        else{
            ans[0] = 0;
            ans[1] = 1;
            ans[2] = 1;
        }
        return dfs(ans,n);
    }
    int dfs(int[] ans,int n){
        if(ans[n]!=0) return ans[n];
        else {
            ans[n] = dfs(ans,n-1)+dfs(ans,n-2)+dfs(ans,n-3);
        }
        return ans[n];
    }
}
