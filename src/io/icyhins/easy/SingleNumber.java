package io.icyhins.easy;

import java.util.*;

/**
 * @author Silver.Kan
 * @date 2018/7/22
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 */
public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();

        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber.singleNumber(nums));
        System.out.println(singleNumber.singleNumber2(nums));
        System.out.println(singleNumber.singleNumber3(nums));
    }

    /**
     * 解题思路：
     *      排序，然后比较 nums[i] 以及nums[i+1]
     *      如果相同则 i=i+2, 不同则返回 nums[i],
     *      时间O(NlogN)
     * */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i =0;

        while(i <nums.length){
            if(i+2 < nums.length && nums[i] == nums[i+1]){
                i= i+2;
            }
            else {
                return nums[i];
            }
        }
        return nums[0];

    }

    /**
     * 使用 List add & remove
     * 时间 O(N)
     * 空间 O(N/2)
     * */
    public int singleNumber2(int[] nums) {
        List<Integer> tmpList = new ArrayList<>();

        for(int i : nums){
            if(tmpList.contains(new Integer(i))){
                tmpList.remove(new Integer(i));
            }else{
                tmpList.add(new Integer(i));
            }
        }

        return tmpList.get(0);
    }

    /**
     * 位操作：
     *  If we take XOR of zero and some bit, it will return that bit
     * a⊕0=a
     *
     * If we take XOR of two same bits, it will return 0
     * a⊕a=0
     *
     * a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
     * */
    public int singleNumber3(int[] nums) {
      int a = 0;
      for(int i :nums) {
          a ^= i;
      }
      return a;

    }

}
