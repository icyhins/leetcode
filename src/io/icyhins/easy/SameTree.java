package io.icyhins.easy;

import io.icyhins.model.TreeNode;

/**
 * @author Silver.Kan
 * @date 2018/7/22
 *
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same val.
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 * Example 2:
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 * Example 3:
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 */
public class SameTree {

    public static void main(String[] args) {
        // p tree
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        SameTree sameTree = new SameTree();

        System.out.println(sameTree.isSameTree(p,q));
    }

    /**
     * 解题思路：
     *  两棵树相同 = 根节点相同 && 右子树相同 && 左子树相同
     *  使用递归遍历树
     * */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // 前序遍历
        return preRecursion(p,q);
    }

    /**
     * 前序遍历 递归函数
     * */
    private boolean preRecursion(TreeNode p, TreeNode q){

        // Side case
        if(p==null && q== null) {
            return true;
        }
        // 当根节点相同，则比较左右子树
        if(p != null && q != null && q.val == p.val){
            return preRecursion(p.left, q.left) && preRecursion(p.right , q.right);
        }
        return false;
    }
}
