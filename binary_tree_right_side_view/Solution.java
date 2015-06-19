import java.util.List;
import java.util.ArrayList;
public class Solution {
    private List<Integer> list;
    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<Integer>();
        int height = calc(root);
        int[] visit = new int[height];
        rightSideView(root, visit, 0);
        return list;
    }
    
    public int calc(TreeNode root) {
        if (root == null) return 0;
        return Math.max(calc(root.left) + 1, calc(root.right) + 1);
    } 

    public void rightSideView(TreeNode root, int[] visit, int h) 
    {
        if (root == null || h >= visit.length || 
            list.size() == visit.length) return;
        if (visit[h] == 0) {
            visit[h] = 1;
            list.add(root.val);
        }
        rightSideView(root.right, visit, h+1);
        rightSideView(root.left, visit, h+1);
    }
}
