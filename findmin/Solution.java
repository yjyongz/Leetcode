class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }
    
    public int findMin(int[] nums, int s, int e) {
        if (s == e) return nums[e];
        if (e == s + 1) return Math.min(nums[s], nums[e]);
        int mid = s + (e -s) / 2;
        if (nums[mid] < nums[e] && nums[mid] > nums[s]) return nums[s];
        if (nums[mid] < nums[s] && nums[mid] > nums[e]) return nums[e];
        if (nums[mid] < nums[e] && nums[mid] < nums[s]) {
            return Math.min(findMin(nums, s, mid -1), findMin(nums, mid, e));
        } else {
            return Math.min(findMin(nums, s, mid -1), findMin(nums, mid, e));
        }
    } 

    public static void main (String[] args) {
        Solution s = new Solution();
        int[] nums = new int[5];
        for (int i=0;i<nums.length;i++) {
            nums[i] = i;
        }
        nums[0] = 5;
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 3;
        nums[4] = 4;
        System.out.println(s.findMin(nums)); 
    }
}
