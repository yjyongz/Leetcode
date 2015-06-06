package twosum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int[] result = new int[2];
        for (int i=0;i<numbers.length;i++) {
            map.put(numbers[i], new ArrayList<Integer>());
        }
        for (int i=0;i<numbers.length;i++) {
        	map.get(numbers[i]).add(i+1);
            map.put(numbers[i], map.get(numbers[i]));
        }
        
        for (int i=0;i<numbers.length; i++) {
        	ArrayList<Integer> arr = map.get(target - numbers[i]);
        	if (arr == null) continue;
        	Iterator<Integer> it = arr.iterator();
        	while (it.hasNext()) {
        		int index = it.next();
	            if (index != i + 1 && map.containsKey(target - numbers[i])) {
	            	int min = i+1 > index ? index : i + 1;
	            	int max = i+1 > index ? i+1 : index;
	                result[0] = min;
	                result[1] = max;
	            }
        	}
        }
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int arr[] = new int[4];
		arr[0] = 0;arr[1] = 4;arr[2] = 3;arr[3] = 0;
		int result[] = s.twoSum(arr, 0);
		System.out.println(result[0] + " " + result[1]);
	}

}
