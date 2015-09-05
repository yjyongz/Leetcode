import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
		int cand = 0, k = 0, cand1 = 0, k1 = 0, maj = (nums.length / 3);
        ArrayList<Integer> result = new ArrayList<Integer>();
		for (int j = 0; j < nums.length; j++) {
			if (k == 0) {
				cand = nums[j];k++;continue;
			} else if (k1 == 0 && cand != nums[j]) {
				cand1 = nums[j];k1++;continue;
			}
			if (nums[j] == cand) {
				k++;
			} else if (nums[j] == cand1) {
				k1++;
			} else {
				k--;k1--;
			}
		}
		/* 
		 * make sure cand is majority element, 
		 * if input gurantee there has to one then cand is the one,
		 * but in this case, we are not given such info
		 */
		k = 0;k1 = 0;
		for (int m = 0;m < nums.length;m++) {
			if (nums[m] == cand) {
				k++;
			} else if (nums[m] == cand1) {
				k1++;
			}
		}
		if (k > maj) {
			result.add(cand);
		}
		if (k1 > maj) {
			result.add(cand1);
		}
        return result;    
    }
	public static void main (String[] args) {
		Solution s = new Solution();
		int num[] = new int[4];
		num[0] = 4;
		num[1] = 2;
		num[2] = 1;
		num[3] = 1;
		List<Integer> arr = s.majorityElement(num);
		for (Integer i : arr) {
			System.out.println(i);
		}
	}
}
