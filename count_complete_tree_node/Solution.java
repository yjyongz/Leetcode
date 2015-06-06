public class Solution {
	public int countNodes (TreeNode root) {
        return countNodeWithHeight(root);
    }
    
    public int countHeight (TreeNode root) {
		TreeNode    r      = root;
        int         height = 0;
		while (r != null) {
			r = r.left;
            height++;
		}
        return height;
    } 

    public int countNodeWithHeight (TreeNode root)
    {
        if (root == null) return 0;
        if (sameLevel(root)) {
            return ((int)Math.pow(2, countHeight(root))) - 1;
        }
        int leftNode = countNodeWithHeight(root.left); 
        int rightNode = countNodeWithHeight(root.right);
        return leftNode + rightNode + 1;
    }

    public boolean sameLevel (TreeNode root) {
        TreeNode leftRoot  = root;
        TreeNode rightRoot = root;
        while (leftRoot.left != null && rightRoot.right != null) {
            leftRoot  = leftRoot.left;
            rightRoot = rightRoot.right;
        }
        if (leftRoot.left != null || rightRoot.right != null) {
            return (false);
        }
        return (true);
    }

	public static void main (String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(3);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        Solution s = new Solution();
        System.out.println(s.countNodes(root));
	}
}
