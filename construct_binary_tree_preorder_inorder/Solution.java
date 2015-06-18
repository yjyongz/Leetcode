import java.util.TreeMap;
public class Solution {
    private TreeNode buildTree(int[] preorder, int[] inorder, 
                               TreeMap<Integer,Integer> map, 
                               int start, int end, int[] index)
    {
        if (start > end || index[0] >= preorder.length) {
            return null;
        }

        int par = map.get(preorder[index[0]]);
        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0]++;

        if (start == end) {
            return root;
        }

        root.left = buildTree(preorder, inorder, map, start, par - 1, index);
        root.right = buildTree(preorder, inorder, map, par + 1, end, index);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeMap<Integer,Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int[] index = new int[1];
        return buildTree(preorder, inorder, map, 0, inorder.length - 1, index);
    }
    
    public void pre(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        pre(root.left);
        pre(root.right);
    }

    public static void main (String[] args) {
        Solution s = new Solution();
        int pre[] = new int[4];
        int in[] = new int[4];
        pre[0] = 2;
        pre[1] = 1;
        pre[2] = 3;
        pre[3] = 4;

        in[0] = 1;
        in[1] = 2;
        in[2] = 3;
        in[3] = 4;
        TreeNode root = s.buildTree(pre, in);
        s.pre(root);
    }
}
