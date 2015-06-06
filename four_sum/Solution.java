package four_sum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		for (int i= 0; i< num.length;i++) {
        	for (int k =i+1;k < num.length;k++) {
	        	int j= k + 1;
	        	int end = num.length - 1;
	        	while (j < end) {
	        		if (num[i] + num[k] + num[j] + num[end]  == target) {
	        			ArrayList<Integer> arr = new ArrayList<Integer>();
	        			arr.add(num[i]);arr.add(num[k]);
	        			arr.add(num[j]);arr.add(num[end]);
	        			result.add(arr);
	        			j++;end--;
	        			while (j < end && num[j] == num[j-1]) j++;
	        			while (j < end && num[end] == num[end + 1]) end--;
	        		} else if (num[i] + num[k] + num[j] + num[end] > target) {
	        			end--;
	        		} else if (num[i] + num[k] + num[j] + num[end] < target) {
	        			j++;
	        		}
	        	}
	        	while (k+1 < num.length && num[k] == num[k+1]) k++;
        	}
        	while (i+1 < num.length && num[i] == num[i+1]) i++;
        }
		return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int num[] = new int[6];
		num[0] = -1;num[1] = -1; num[2] = 0;
		num[3] = -1; num[4] = 1;num[5] = 2;
		ArrayList<ArrayList<Integer>> result = s.fourSum(num, 1);
		System.out.println(result);
	}

}
