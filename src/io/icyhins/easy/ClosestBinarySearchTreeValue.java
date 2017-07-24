package io.icyhins.easy;

import io.icyhins.util.TreeNode;

/**
 * Given a non-empty binary search tree and a target value,
 * find the value in the BST that is closest to the target.
 *
 * Note: Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class ClosestBinarySearchTreeValue {


    public static void main(String[] args){
        ClosestBinarySearchTreeValue obj = new ClosestBinarySearchTreeValue();

        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(50);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(70);

        root.right = new TreeNode(150);
        root.right.left = new TreeNode(120);
        root.right.right = new TreeNode(180);

        int target = 11;

        System.out.println(obj.solution(root,target));

    }

    public int solution(TreeNode root, int target){

        int result = root.val;

        result = closestValue(root, target, result);

        return result;
    }

    /**
     * @param node
     *          the root tree node
     * @param target
     *          target value for compare
     * @param result
     *          the result
     *
     * */
    private int closestValue(TreeNode node, int target, int result){

        //Result value comparison
        result = Math.abs(target - node.val) < Math.abs(target - result)? node.val: result;

        if(target < node.val){ // Binary Search Tree Feature
            //Traversal left node
            if(node.left != null)
                result = closestValue(node.left, target, result);
        } else {
            //Traversal right node
            if(node.right != null)
                result = closestValue(node.right, target, result);
        }

        return  result;

    }



}
