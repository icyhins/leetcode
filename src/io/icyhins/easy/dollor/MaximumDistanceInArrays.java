package io.icyhins.easy.dollor;

import java.util.ArrayList;
import java.util.List;

/**
 * 624
 * Given m arrays, and each array is sorted in ascending order.
 * Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance.
 * We define the distance between two integers a and b to be their absolute difference |a-b|.
 *
 * Your task is to find the maximum distance.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [1,2,3],
 *  [4,5],
 *  [1,2,3]
 * ]
 * Output: 4
 *
 * Explanation:
 * One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 *
 *
 * Note:
 *
 * Each given array will have at least 1 number.
 * There will be at least two non-empty arrays.
 * The total number of the integers in all the m arrays will be in the range of [2, 10000].
 * The integers in the m arrays will be in the range of [-10000, 10000]
 */
public class MaximumDistanceInArrays {

    public static void main(String[] args){
        MaximumDistanceInArrays obj = new MaximumDistanceInArrays();

        List<Integer> num1 = new ArrayList<>();
        num1.add(35);num1.add(45);num1.add(92);num1.add(192);num1.add(395);num1.add(492);num1.add(692);num1.add(799);

        List<Integer> num2 = new ArrayList<>();
        num2.add(15);num2.add(24);num2.add(245);num2.add(435);num2.add(451);num2.add(755);num2.add(995);num2.add(2345);

        List<Integer> num3 = new ArrayList<>();
        num3.add(61);num3.add(992);num3.add(1777);

        List<Integer> num4 = new ArrayList<>();
        num4.add(15);num4.add(45);num4.add(67);num4.add(167);num4.add(168);num4.add(676);num4.add(799);

        List<List<Integer>> nums = new ArrayList<>();
        nums.add(num1);nums.add(num2);nums.add(num3);nums.add(num4);

        System.out.println(obj.maxDistance2(nums));


    }

    /**
     * Solution main idea:
     *
     * We know each array is sorted,
     * Brute Force  - O(n^2)
     * Calculate all distance
     * */
    public int maximumDistance(List<List<Integer>> nums){


        //Sort nums by start
        //nums.sort((List<Integer> list1, List<Integer> list2) -> list1.get(0) - list2.get(0));

        List<Integer> distances = new ArrayList<>();
        for(int i = 0; i < nums.size(); i++){
            for(int j = 0; j < nums.size(); j++){
                if( i != j){
                    List<Integer> min = nums.get(i);
                    List<Integer> max = nums.get(j);

                    int sub = max.get(max.size() -1 ) - min.get(0);
                    distances.add(sub);
                }
            }
        }

        //Desc order sort
        distances.sort((Integer o1, Integer o2) -> o2 - o1);

        return distances.get(0);

    }

    /**
     * Solution main idea
     * Because max & min maybe in same array , but we do NOT calculate max - min
     *
     * we can calculate the [item last - min] & [max - item 1st]
     * So the max & the min is from old array, not the array which we are reading.
     *
     * */
    public int maxDistance2(List<List<Integer>> arrays) {
        int distance = 0;
        //1st array last value
        int max = arrays.get(0).get(arrays.get(0).size() - 1);

        //1st array 1st value
        int min = arrays.get(0).get(0);

        //Start from 2nd array
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> item = arrays.get(i);

            distance = Math.max(distance, Math.abs(max - item.get(0)));

            distance = Math.max(distance, Math.abs(item.get(item.size() - 1) - min));

            max = Math.max(max, item.get(item.size() - 1));
            min = Math.min(min, item.get(0));
        }

        return distance;
    }


}
