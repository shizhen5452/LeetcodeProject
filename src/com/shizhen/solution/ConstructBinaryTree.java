package com.shizhen.solution;

import com.shizhen.model.TreeNode;

public class ConstructBinaryTree {

    /**
     * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return findNode(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode findNode(int[] inorder, int iLeft, int iRight, int[] postorder, int pLeft, int pRight) {
        if (iLeft > iRight || pLeft > pRight) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[pRight]);
        int i = 0;
        for (i = iLeft; i <= iRight; i++) {
            if (inorder[i] == postorder[pRight]) {
                break;
            }
        }
        node.left = findNode(inorder, iLeft, i - 1, postorder, pLeft, pLeft + i - iLeft - 1);
        node.right = findNode(inorder, i + 1, iRight, postorder, pLeft + i - iLeft, pRight - 1);
        return node;
    }

}
