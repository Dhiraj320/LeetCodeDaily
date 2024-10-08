package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Q2 {
    /*
    //Approach (Simple Recursion - DFS)
//T.C : O(n) - We visit each number (1 to n) only once.
//S.C : O(d) - where d is the number of digits in n i.e. log10(n)
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result= new ArrayList<>();
        // Start from numbers 1 to 9
        for(int startNum=1; startNum<=9; startNum++){
            dfs(startNum, n, result);

        }
        return result;// Return the result list
    }

    public void dfs(int curNum, int n, List<Integer> result){
        if(curNum>n){
            return;
        }
        result.add(curNum); // Add current number to result

        // Generate the new number by appending digits 0 to 9
        for(int append=0;append<=9; append++){
            int newNum=(curNum*10) + append;
            if(newNum>n){
                break;
            }
            dfs(newNum, n, result); // Recursive call

        }
    }
    */

    //Approach 2 Iterative
//TC =O(n);
//SC =O(1) // Without extra Space
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result= new ArrayList<>();
        int curNum=1;
        // Start from numbers 1 to 9
        for(int startNum=1; startNum<=n; startNum++){
            result.add(curNum);
            if(curNum*10<=n){
                curNum=curNum*10;
            }else{
                while(curNum%10==9 || curNum==n){
                    curNum=curNum/10;
                }
                curNum=curNum+1;
            }

        }
        return result;// Return the result list
    }

}
