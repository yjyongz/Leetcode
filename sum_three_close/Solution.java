package sum_three_close;

import java.util.Arrays;

public class Solution {
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int abs = Integer.MAX_VALUE;int ret = num[0];
        for (int i= 0; i< num.length;i++) {
        	int j= i + 1;
        	int end = num.length - 1;
        	while (j < end) {
        		if (num[i] + num[j] + num[end] == target) {
        			return target;
        		} else if (num[i] + num[j] + num[end] > target) {
        			if (abs > Math.abs(num[i] + num[j] + num[end] - target)) {
        				abs = num[i] + num[j] + num[end] - target;
        				ret = num[i] + num[j] + num[end];
        			}
        			end--;
        		} else if (num[i] + num[j] + num[end] < target) {
        			if (abs > Math.abs(target - (num[i] + num[j] + num[end]))) {
        				abs = target - (num[i] + num[j] + num[end]);
        				ret = num[i] + num[j] + num[end];
        			}
        			j++;
        		}
        	}
        	//while (i+1 < num.length && num[i] == num[i+1]) i++;
        }
        return ret;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int num[] = new int[4];
		num[0] = 0;num[1] = 2; num[2] = 1;
		num[3] = -3;
		int result = s.threeSumClosest(num, 1);
		System.out.println(result);
	}

}
