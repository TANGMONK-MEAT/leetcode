package com.github.tangmonkmeat;

import javax.swing.tree.TreeNode;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/8 9:50
 */
public class 平衡二叉树 {

    // 这里的深度和高度均使用 节点为依据，不使用边

    // 深度：指从根节点到该节点的节点个数，包含自己
    // 高度：指从该节点到叶子节点的节点个数，包含自己

    public static void main(String[] args) {
        // new 平衡二叉树().isBalanced()
    }

    public boolean isBalanced(TreeNode root) {
        return def(root) >= 0;
    }

    /**
     * 计算节点的子树的最大高度，
     * 递归使用的化，每次得到结果，计算高度差，
     * 如果高度差  > 1, 立即返回 -1，已经不符合条件了
     *
     * 因此，还需要判断高度差 == -1，也立即返回 -1
     *
     * @param node 节点
     * @return 点的子树的最大高度
     */
    public int def(TreeNode node){
        // 到达叶子节点，向上返回
        if (node == null){
            return 0;
        }
        // 返回左右子树的高度
        // 先一直调用 def，到达二叉树的底部
        int ld = def(node.left);
        int rd = def(node.right);
        // 一直向上返回
        if (ld == -1 || rd == -1){
            return -1;
        }
        // 如果左右子树的高度差 > 1,一直向上返回
        if (Math.abs(ld - rd) > 1){
            return -1;
        }
        // 返回高度差
        return Math.max(ld,rd) + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
