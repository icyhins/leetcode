package io.icyhins.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers 
 * such that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, 
 * and you may not use the same element twice.
 * 
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,

 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * */
public class TwoSum {
	public static void main(String[] args){
		int[] nums = {2, 7, 11, 15,1,23423,234,12312,5235,99813,123,244275,14453,325,13123,12312,3,132123444,12312375,1342,6456,7534535,444444,23335554,223452345,4555532,23,0,445452,3235345};
		int target = 444444;
		getTwoSumByBruteForce(nums,target);	
		getTwoSumByTwoHash(nums, target);
		getTwoSumByOneHash(nums, target);
	}
	
	/***
	 * Brute Force method.
	 * Time complexity:  O(n2)
	 * Space complexity: O(1)
	 * */
	private static int[] getTwoSumByBruteForce(int[] nums, int target){
		
		//Loop the first number
		for(int i=0; i<nums.length; i++){
			//Loop the number after num[i]
			for(int j=i+1; j<nums.length; j++){
				//if it meets the target , then break the loop.
				if(nums[i]+nums[j]==target){
					System.out.printf("[%s,%s]", i, j);
					System.out.println();
					return new int[] { i, j };
				}
			}
		}
		
		throw new IllegalArgumentException("No two sum solution");
	}
	
	/**
	 * Two-pass Hash Table
	 * Time complexity:  O(n)
	 * Space complexity: O(n)
	 * */
	private static int[] getTwoSumByTwoHash(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement)){
				System.out.printf("[%s,%s]", i, map.get(complement));
				System.out.println();
				return new int[] { i, map.get(complement) };
			}
		}

		throw new IllegalArgumentException("No two sum solution");
	}

	/**
	 * One-pass Hash Table 
	 * Time complexity: O(n) 
	 * Space complexity: O(n)
	 */
	private static int[] getTwoSumByOneHash(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				System.out.printf("[%s,%s]", map.get(complement), i);
				System.out.println();
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}

		throw new IllegalArgumentException("No two sum solution");
	}

}
