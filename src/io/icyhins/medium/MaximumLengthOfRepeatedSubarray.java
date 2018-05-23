package io.icyhins.medium;

/**
 * @author Silver.Kan
 * @date 2018/5/23
 * 718
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 *
 * Example 1:
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 * Note:
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * @author Silver.Kan
 */
public class MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray max = new MaximumLengthOfRepeatedSubarray();
        int[] A = new int[]{1,2,3,2,1};
        int[] B = new int[]{3,2,1,4,5};
        int result = max.findLengthDp(A,B);
        System.out.print(result);
    }

    /**
     * DP Solution
     * when A[i]=B[j], then dp[i][j] = dp[i-1][j-1] + 1;
     * otherwise dp[i][jr] = 0;
     * */
    public int findLengthDp(int[] A, int[] B) {

        // Corner case
        if(A==null||B==null||A.length==0||B.length==0){
            return 0;
        }

        int[][] dp = new int[A.length][B.length];
        int maxLength = 0;

        // Initial the first item
        dp[0][0] = A[0]==B[0]?1:0;

        // Initial the first column
        for(int i=1;i<A.length;i++){
            dp[i][0]=A[i]==B[0]?1:0;
        }

        // Initial the first
        for(int i=1;i<B.length;i++){
            dp[0][i]=A[0]==B[i]?1:0;
        }

        for(int i=1; i<A.length; i++){
            for(int j=1; j<B.length; j++){
                if(A[i] == B[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxLength = Math.max(maxLength,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        return maxLength;
    }
}
