package io.icyhins.easy;

import java.util.Arrays;

/**
 * @author Silver.Kan
 * @date 2018/7/23
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 *
 * Clarification:
 *
 * Confused why the returned value is an integer but your answer is an array?
 *
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 *
 * Internally you can think of this:
 *
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int[] nums = new int[]{1,1,1,1,1,1};
        removeDuplicatesFromSortedArray.removeDuplicates(nums);

    }

    /**
     * 解题思路：
     *
     * 题目有两个要求
     * 1。 返回 single number 的数量 N
     * 2. 入参数组的前 N 位要替换成 single number 数组
     *
     * 因为入参数组已经是有序的，
     * 所以考虑使用双指针，
     * p0 指向需要改动的位置，
     * p1 遍历数组，进行比较，
     *      如果 nums[p1] != nums[p0],
     *      则nums[p0+1] = nums[p1], 且 p0 前移一位
     *
     * */
    public int removeDuplicates(int[] nums) {

        // side case
        if(nums == null) return 0;
        if(nums.length == 1) return 1;

        // 双指针，p0从第1位开始，p1 从第2位开始
        int p0 = 0;
        for(int p1=1; p1 < nums.length; p1++){
            // 出现不一样的数，则填充
            if(nums[p1] != nums[p0]){
                nums[p0 + 1] = nums[p1];
                p0++;
            }
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(p0+1);

        return p0+1;
    }
}
