package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses241 {
}

//https://leetcode.com/problems/different-ways-to-add-parentheses/description/?envType=daily-question&envId=2024-09-19

//Approach 1-DP(Recursion+memoization)
//T.C : O(n*2^n)
//S.C : O(2^n) //The result vector stores all possible outcomes. The number of results is at most exponential in terms of the number of operators, so the space required to store the results is O(2^n).



class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        int n= expression.length();
        List<Integer>[][]dp=new ArrayList[n][n];
        return solve(expression, 0,n-1, dp);
    }

    public List<Integer> solve(String exp, int start, int end,List<Integer>[][]dp){
        List<Integer> result= new ArrayList<>();
        if(dp[start][end]!=null){
            return dp[start][end];
        }
        //base case:single digit
        if(start==end){
            int num=exp.charAt(start)-'0';
            result.add(num);
            return result;
        }
        // base case: double digit
        if(end-start==1 && Character.isDigit(exp.charAt(start))){
            int num=Integer.parseInt(exp.substring(start, end+1));
            result.add(num);
            return result;

        }
        // split
        for(int i=start; i<=end;i++){
            char c=exp.charAt(i);
            if(Character.isDigit(c)){
                continue;
            }

            List<Integer> leftResult= solve(exp, start, i-1, dp);
            List<Integer> rightResult= solve(exp, i+1, end, dp);
            for(int l:leftResult){
                for(int r: rightResult){
                    if(c=='+'){
                        result.add(l+r);
                    }else if(c=='-'){
                        result.add(l-r);
                    }else{
                        result.add(l*r);
                    }
                }
            }

        }
        return dp[start][end]= result;


    }
}



