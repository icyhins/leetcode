package io.icyhins.medium;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that
 * a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note: The solution set must not contain duplicate triplets.
 *
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * @author Silver.Kan
 */
public class ThreeSum {

    public static void main(String[] args){
        ThreeSum obj = new ThreeSum();

        //int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0,0,0,0};
        int target = 0;
        List<List<Integer>> result = obj.threeSum(nums, target);

        for(List<Integer> tmp: result){
            System.out.println(tmp.toString());
        }
    }

    /**
     * The idea is to sort an input array
     * and then run through all indices of a possible first element of a triplet.
     * For each possible first element
     * we make a standard bi-directional 2Sum sweep of the remaining part of the array.
     * Also we want to skip equal elements to avoid duplicates in the answer without making a set or sth. like that.
     * */
    public List<List<Integer>> threeSum(int[] num,int target) {
        //Sort the array
        Arrays.sort(num);

        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {//Skip the duplicate num
                int lo = i+1;//Lower pointer(for 2 sum)
                int hi = num.length-1;  //Higher pointer(for 2 sum)
                int sum = target - num[i];//
                //Calculate 2 Sum
                while (lo < hi) {
                    //When the 2 sum is found
                    if (num[lo] + num[hi] == sum) {
                        //Save result
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        //Skip the duplicate num
                        while (lo < hi && num[lo] == num[lo+1])
                            lo++;
                        //Skip the duplicate num
                        while (lo < hi && num[hi] == num[hi-1])
                            hi--;
                        //Move pointer
                        lo++; hi--;
                    }
                    else if (num[lo] + num[hi] < sum)
                        lo++;//If lower than 2 sum , move lower pointer
                    else
                        hi--;//If higher than 2 sum , move higher pointer
                }
            }
        }
        return res;
    }

//    private List<List<Integer>> solution(int[] nums, int target){
//
//        List<List<Integer>> threeSum = new ArrayList<>();
//
//        Set<Integer> uniqueFixer = new HashSet<>();
//
//        //Map <sub, index>
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i = 0; i<nums.length ;i++){
//
//            if(uniqueFixer.add(nums[i])){
//
//                int[] tmp = remove(nums, i);
//                int complement = target - nums[i];
//                List<int[]> twosum = twosum(tmp, complement);
//                if(twosum.size() > 0){
//                    for(int[] ts: twosum){
//                        List<Integer> item = new ArrayList<>();
//                        item.add(nums[i]);
//                        item.add(ts[0]);
//                        item.add(ts[1]);
//                        uniqueFixer.add(ts[0]);
//                        uniqueFixer.add(ts[1]);
//
//                        threeSum.add(item);
//                    }
//                }
//            }else{
//                continue;
//            }
//
//
//        }
//
//
//        return threeSum;
//    }
//
//    private  List<int[]> twosum(int nums[], int target){
//        //Map <sub, index>
//        Map<Integer,Integer> map = new HashMap<>();
//        List<int[]> twosum = new ArrayList<>();
//        for(int i = 0;i<nums.length ;i++){
//                int complement = target - nums[i];
//                //Compare diff with key
//                if (map.containsKey(complement)) {
//                    twosum.add(new int[]{complement, nums[i]});
//                } else {
//                    map.put(nums[i], i);
//                }
//
//
//        }
//        return twosum;
//    }
//
//    private int[] remove(int[] array, int index){
//        if(index < 0 || index > array.length - 1 || array.length <= 0){
//            return new int[0];
//        }
//
//        int[] result = new int[array.length - 1];
//        // Copy first part before index
//        System.arraycopy(array,0, result,0, index);
//
//        // Copy second part after index
//        System.arraycopy(array,index + 1, result, index,array.length - index - 1);
//
//        return result;
//    }


}
