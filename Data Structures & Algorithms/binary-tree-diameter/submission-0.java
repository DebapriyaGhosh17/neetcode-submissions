/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int maxdiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxdiameter = 0;
        calculateHeight(root);
        return maxdiameter;

    }

    private int calculateHeight(TreeNode node){
        if(node==null) return 0;

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        maxdiameter = Math.max(maxdiameter,leftHeight+rightHeight);

        return 1+Math.max(leftHeight,rightHeight);
    }
        
}
