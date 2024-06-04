 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}


class Solution {
    void dfs(int depth, TreeNode r1, TreeNode r2){
        if(r1 == null || r2 == null)
            return;
        if(depth % 2 == 0){
            int tmp = r1.val;
            r1.val = r2.val;
            r2.val = tmp;
        }
        dfs(depth + 1, r1.left, r2.right);
        dfs(depth + 1, r1.right, r2.left);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(0, root.left, root.right);
        return root;
    }
}