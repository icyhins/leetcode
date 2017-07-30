package io.icyhins.easy;

import io.icyhins.util.TreeNode;

/**
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced Binary Search Tree.
 */
public class ConvertSortedArrayToBST {


    public static void main(String[] args){
        ConvertSortedArrayToBST obj =  new ConvertSortedArrayToBST();

        int[] nums = {1,2,3,4,5,6};
        TreeNode root = obj.sortedArrayToBST(nums);

        System.out.println(root);

    }

    /**
     * Solution main idea:
     *  Most Tree problem can be solved with Recursion.
     *  For this one, we need to find the root node ,
     *  and as a BST, the root node should be the middle value of the sorted array
     *  then the core problem to find the middle until to the array[0] and array[n]
     *
     * */
    public TreeNode sortedArrayToBST(int[] nums) {

        //Corner case
        if(nums == null || nums.length == 0){
            return null;
        }
        return buildTree(nums, 0 , nums.length -1);
    }

    /**
     * @param start start pointer
     * @param end   end pointer
     * */
    private TreeNode buildTree(int[] nums , int start , int end){

        // when start over end position, return null
        if(start > end){
            return null;
        }

        //*** Calculate middle item position ***
        int mid = start + (end - start)/2;

        TreeNode root = new TreeNode(nums[mid]);

        // find middle node for left part
        // start pointer is fixed for left tree
        root.left = buildTree(nums, start,mid-1);

        // find middle node for right part
        // end pointer is fixed for right tree
        root.right = buildTree(nums, mid+1,end);

        return root;
    }

}
