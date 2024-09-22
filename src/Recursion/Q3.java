package Recursion;
//https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/?envType=daily-question&envId=2024-09-22
import java.util.ArrayList;
import java.util.List;

public class Q3 {
    /*
    //Approach-1 (Simple Recursion - DFS) - MEMORY LIMIT EXCEEDE (MLE)
//T.C : O(n)
//S.C : O(d) of system stack and O(n) for storing numbers in result array
    public void solve(int curr, int n, List<Integer> result) {
        if (curr > n) return;

        result.add(curr);

        for (int nextDigit = 0; nextDigit <= 9; nextDigit++) {
            int nextnum = curr * 10 + nextDigit;
            if (nextnum > n) return;

            solve(nextnum, n, result);
        }
    }

    public int findKthNumber(int n, int k) {
        List<Integer> result = new ArrayList<>();

        for (int num = 1; num <= 9; num++) {
            solve(num, n, result);
        }

        return result.get(k - 1);
    }

     */

    /*

    //Approach-2 (Iterative) - MEMORY LIMIT EXCEEDE (MLE)
//TC =O(n);
//SC =O(1) // Without extra Space
    public int findKthNumber(int n, int k) {
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
        return result.get(k-1);// Return the result at k-1
    }

    */


    /*

    //Approach-3 (Simple Recursion - DFS without storing in result) - TIME LIMIT EXCEEDE (TLE)
//T.C : O(n)
//S.C : O(d) of system stack
    public static void main(String[] args) {
        System.out.println(findKthNumber(13, 2));

    }
    private  static int count = 0;
    private static int result = 0;

    public static boolean solve(long curr, int n, int k) {
        if (curr > n) return false;

        count++;

        if (count == k) {
            result = (int) curr;
            return true;
        }

        for (int nextDigit = 0; nextDigit <= 9; nextDigit++) {
            long nextnum = curr * 10 + nextDigit;
            if (nextnum > n) break;

            if (solve(nextnum, n, k)) return true;
        }

        return false;
    }

    public static int findKthNumber(int n, int k) {
        for (long num = 1; num <= 9; num++) {
            if (solve(num, n, k)) break;
        }

        return result;
    }
    */

    //Approach-4 (Optimal) - ACCEPTED
//T.C : O((logn)^2)
//S.C : O(log(n)) system resursion stack

    public int countNumbers(long curr, long next, int n) {
        int countNum = 0;

        while (curr <= n) {
            countNum += Math.min(next, (long) n + 1) - curr;
            curr *= 10;
            next *= 10;
        }

        return countNum;
    }

    public int findKthNumber(int n, int k) {
        int curr = 1;
        k -= 1; // Since we start from the first number (1), we need k-1 more numbers

        while (k > 0) {
            int count = countNumbers(curr, curr + 1, n);
            if (count <= k) {
                curr++;
                k -= count; // Skipping the elements under the current prefix tree
            } else {
                curr *= 10;
                k -= 1;
            }
        }

        return curr;
    }

}
