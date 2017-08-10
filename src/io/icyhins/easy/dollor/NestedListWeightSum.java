package io.icyhins.easy.dollor;

import io.icyhins.util.NestedInteger;

import java.util.ArrayList;
import java.util.List;

/**339
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1 ： 1*2 + 1*2 + 2 + 1*2 + 1* 2)
 *
 * Example 2:
 * Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 *
 *
 */
public class NestedListWeightSum {


    public static void main(String[] args){
        NestedListWeightSum obj = new NestedListWeightSum();

        List<NestedInteger> nestedList  = new ArrayList<>();

        //[1,1]
        List<NestedInteger> list1  = new ArrayList<>();
        list1.add(new NestedInteger(1));
        list1.add(new NestedInteger(1));
        nestedList.add(new NestedInteger(list1));

        //[2]
        nestedList.add(new NestedInteger(2));

        //[1,1]
        List<NestedInteger> list2  = new ArrayList<>();
        list2.add(new NestedInteger(1));
        list2.add(new NestedInteger(1));
        nestedList.add(new NestedInteger(list2));


        System.out.println(obj.nestedListWeightSum(nestedList));

    }

    /**
     * Solution main idea:
     *
     *  Because we do not know how dept in the list, so we use recursion to calculate;
     *  we create helper function to pass the weight value
     *
     * */
    public int nestedListWeightSum(List<NestedInteger> nestedList){
        return helper(nestedList,1);
    }

    public int helper(List<NestedInteger> nestedList, int weight){
       int sum = 0;
       for(NestedInteger nInt: nestedList){
           sum += nInt.isInteger()?nInt.getInteger() * weight : helper(nInt.getList(),weight +1);
       }
        return sum;
    }
}
