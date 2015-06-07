class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findkth(nums, 0, nums.length - 1, nums.length - k);
    }
  
    public void swap (int[] nums, int s, int e) {
        int t = nums[e];
        nums[e] = nums[s];
        nums[s] = t;
    } 

    public int findkth(int[] nums, int s, int e, int k) {
        int ran = s;
        swap(nums, ran, e);
        int index = s;
        for (int i = s; i < e; i++) {
            if (nums[i] < nums[e]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, index, e);
        /*for (int i=s;i<=e;i++) {
            System.out.println("k:"+k+" index: " + index + " num["+i+"]: " + nums[i]);
        }
        System.out.println("========================");*/
        if (index == k + s) return nums[s + k];
        if (index < k + s) {
            /*
             * right search
             */
            return findkth(nums, index + 1, e, (k + s)  - index -1);
        } else {
            /*
             * left search
             */
            return findkth(nums, s, index - 1, k);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int num[] = new int[1];
        for (int i = 0; i < num.length; i++) {
            num[i] = i;
        }
        for (int i = 1; i <= num.length; i++) {
                for (int j = 0; j < num.length; j++) {
                        num[j] = j;
                }
                System.out.println(i+ " "+ s.findKthLargest(num, i));
        }
    }
}
