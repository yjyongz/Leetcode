import java.util.ArrayList;
import java.util.List;
class TreeNode {
    int s;
    int e;
    TreeNode (int s1,int e1) {
        s = s1;
        e = e1;
        left = null;
        right = null;
    }
    TreeNode left;
    TreeNode right;
}

class RangeTree {
    TreeNode r;
    RangeTree() {
        r = null;
    }

    public void insertPoint(int item) {
        if (r == null) {
            r = new TreeNode(item, item);
            return;
        }
        insertPoint(r, item);
    }

    private TreeNode insertPoint(TreeNode node, int item) {
        if (node == null) {
            node = new TreeNode(item, item);
            return node;
        }
        if (node.e + 1 == item) {
            node.e = item;
            return node;
        }
        TreeNode r = insertPoint(node.right, item); 
        node.right = r;
        return node;
    }

    public List<String> printRange() {
        return printRange(r);
    }

    private List<String> printRange(TreeNode root) {
        List<String> ret = new ArrayList<String>();
        TreeNode node = root;
        while (node!=null) {
            if (node.s == node.e) {
                ret.add(String.valueOf(node.s));
            } else {
                ret.add(String.valueOf(node.s) +"->" +
                        String.valueOf(node.e));
            }
            node = node.right;
        }
        return ret;
    }
}

public class Solution {
    public List<String> summaryRanges (int[] nums) {
        List<String> ret = new ArrayList<String>();    
        RangeTree  tree = new RangeTree();
        for (int i = 0;i < nums.length; i++) {
            tree.insertPoint(nums[i]); 
        }
        ret = tree.printRange();
        return ret;
    }
    public static void main (String args[]) {
        int num[] = new int[4];
        num[0] = 1;
        num[1] = 2;
        num[2] = 4;
        num[3] = 6;
        Solution s = new Solution();
        List<String> ret = s.summaryRanges(num);
        for (int i = 0;i < ret.size(); i ++) {
            System.out.println(ret.get(i).toString());
        }
    }
}
