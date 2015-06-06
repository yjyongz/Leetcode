package sum_three;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();	
        Arrays.sort(num);
        
        for (int i= 0; i< num.length;i++) {
        	if (num[i] > 0) break;
        	int j= i + 1;
        	int end = num.length - 1;
        	while (j < end) {
        		if (num[i] + num[j] + num[end] == 0) {
        			ArrayList<Integer> arr = new ArrayList<Integer>();
        			arr.add(num[i]);arr.add(num[j]);arr.add(num[end]);
        			result.add(arr);
        			j++;end--;
        			while (j < end && num[j] == num[j-1]) j++;
        			while (j < end && num[end] == num[end + 1]) end--;
        		} else if (num[i] + num[j] + num[end] > 0) {
        			end--;
        		} else if (num[i] + num[j] + num[end] < 0) {
        			j++;
        		}
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
		//S = {-1 0 1 2 -1 -4}
		Solution s = new Solution();
		int num[] = new int[6];
		num[0] = -1;num[1] = -1; num[2] = -1;
		num[3] = -1; num[4] = -1;num[5] = 2;
		ArrayList<ArrayList<Integer>> result = s.threeSum(num);
		System.out.println(result);
	}

}
