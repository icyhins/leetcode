package io.icyhins.easy;

/**
 * @author Silver.Kan
 * @date 2018/8/4
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 *
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

        int[] nums = new int[]{1,3,5,6};
        int target = 3;

        System.out.print(searchInsertPosition.searchInsert(nums,target));
    }

    /**
     * 解题思路：
     *
     * 1.对无重复的有序数组，进行遍历，对比nums[i],
     * 时间复杂度是 O(N)
     *
     * 2. 二分搜索，O(logN)
     *
     * */
    public int searchInsert(int[] nums, int target) {

        // Corner case
        if(null == nums || nums.length == 0) return -1;

        int start = 0, end = nums.length-1;
        return helper(nums,target,start,end);
    }

    /**
     * 二分搜索
     * */
    private int helper(int[] nums, int target, int start, int end){
         if (start > end)  return end + 1;

         // 从中间对比
         int mid = start + (end -start)/2;

         if(nums[mid] < target){
            // 搜索后半部分
             start = mid + 1;
             return helper(nums,target,mid+1,end);
         }
         else if(nums[mid] > target){
            // 搜索前半部分
             return helper(nums,target,start,mid-1);
         }
         else{
             // 相等即找到了对应位置
             return mid;
         }
    }

    /**
     * 讨论区8行代码
     * */
    public int searchInsert2(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}
