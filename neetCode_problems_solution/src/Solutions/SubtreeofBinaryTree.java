class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;
        if(helperTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public boolean helperTree(TreeNode s, TreeNode t) {
        if(s == null && t == null)return true;
        if(s !=null && t != null && s.val == t.val){
            return helperTree(s.left, t.left) && helperTree(s.right, t.right);
        }
        return false;
    }
}