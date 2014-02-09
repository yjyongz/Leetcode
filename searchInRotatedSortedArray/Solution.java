package roatedArray;

public class Solution {
	public int search(int[] A, int target) {
		int start = 0; int end = A.length - 1;
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if (A[mid] == target) return mid;
            if (A[mid] < A[end]) {
                if (A[mid] < target && target <= A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (A[start] <= target && target < A[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                
            }
        }
        return -1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int A[] = new int[2];
		A[0] = 3;A[1] = 1;
		System.out.println(s.search(A, 2));
	}

}
