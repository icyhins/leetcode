package io.icyhins.medium;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target,
 * find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 *
 * Return 2.
 *
 * Because there are two triplets which sums are less than 2:
 * [-2, 0, 1]
 * [-2, 0, 3]
 *
 * Follow up: Could you solve it in O(n^2) runtime?
 */
public class ThreeSumSmaller {

    public static void main(String[] args){
        ThreeSumSmaller obj = new ThreeSumSmaller();

        int[] nums = {-2, 0, 1, 3};
        int target = 2;
        System.out.println(obj.threeSumClosest(nums,target));
    }

    public int threeSumClosest(int[] nums, int target){

        //Sort array
        Arrays.sort(nums);

        int result  = 0;

        for(int i = 0; i < nums.length -2; i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){//Duplicated nums handle
                int start = i+1;
                int end = nums.length - 1;
                while(start < end ){
                    int sum = nums[i] + nums[start] + nums[end];
                    if(sum >= target){
                        end--;
                    }else{
                        result += end - start;// all nums from end to start is match.
                        //Duplicated nums handle
                        while (start < end && nums[start] == nums[start+1]) start++;
                        while (start < end && nums[end] == nums[end-1]) end--;
                        //Move start pointers
                        start++;
                    }

                }
            }

        }

        return result;
    }

}
