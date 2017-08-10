package io.icyhins.easy.dollor;

/** 276
 * There is a fence with n posts, each post can be painted with one of the k colors.
 *
 * You have to paint all the posts such that "no more than" two adjacent fence posts have the same color.
 *
 * Return the total number of ways you can paint the fence.
 *
 * Note:
 * n and k are non-negative integers.
 */
public class PaintFence {

    public static void main(String[] args){
        PaintFence obj = new PaintFence();
        System.out.println(obj.paintFence(1,2));
    }
    /**
     * n posts
     * k colors
     *
     * Solution Main Idea
     *  Total result is same color with pre post + different color with pre post
     *
     * */
    public int paintFence(int n, int k){
        //Corner case
        if (n == 0) return 0;
        int same = 0,//Initial 1st post same as 0th post
                diff = k;//Initial 1st post diff from 0th post

        int res = same + diff;

        //Start from 2nf post
        for (int i = 2; i <= n; ++i) {
            same = diff;//same color case, so the ways total also same as pre post(diff case)
            diff = res * (k - 1);//diff color case
            res = same + diff;//Total case
        }
        return res;
    }

    /**
     * DP Solution
     *
     * "No more than 2 adjacent fence posts have the same color"
     * means 3rd post not same as 1st post OR not same as 2nd post
     *
     * */
    public int paintFence2(int n, int k) {
        int dp[] = {0,
                k , //when n = 1
                k*k, // when n =2 should be k*(k-1) + k
                0};
        if(n <= 2){
            return dp[n];
        }

        //Start calculate from 3rd
        for(int i = 3; i <= n; i++){
            dp[3] = dp[1] * (k - 1) //the 3rd post not same as 1st post
                    + dp[2] * (k - 1);//or not same as 2nd post
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[3];
    }

}
