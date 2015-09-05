public class Solution {
    public int majorityElement(int[] nums) {
		int cand = 0, k = 0;        
		cand = nums[0];k = 1;
		for (int i =1; i< nums.length; i++) {
			if (k == 0) {
				cand = nums[i];
			}
			if (nums[i] == cand) {
				k++;
			} else {
				k--;
			}
		}
		return cand;
    }
}
