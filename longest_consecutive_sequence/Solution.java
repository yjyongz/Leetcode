package consecutive_order;

import java.util.HashMap;

public class Solution {
	public int findMax(int num, HashMap<Integer, Boolean> map) {
		int max = 0;
		int temp = num;
		while (map.containsKey(temp)) {
			map.remove(temp);
			max++;
			temp--;
		}
		temp = num + 1;
		while (map.containsKey(temp)) {
			map.remove(temp);
			max++;
			temp++;
		}
		return max;
	}
	public int longestConsecutive(int[] num) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i =0;i<num.length;i++) {
            map.put(num[i], true);
        }
        int max = 0;
        for (int i=0;i<num.length;i++) {
        	max = Math.max(max, findMax(num[i], map));
        }
        return max;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = new int[6];
		num[0] = 100;num[1] = 4;num[2] = 200;
		num[3] = 1;num[4] = 2;num[5] = 3;
		Solution s = new Solution();
		System.out.println(s.longestConsecutive(num));
	}

}
