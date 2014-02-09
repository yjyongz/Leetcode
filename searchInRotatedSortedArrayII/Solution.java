package searchInRotatedArrayII;

public class Solution {
	public boolean search(int[] A, int target) {
        int start = 0; int end = A.length -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] == target) return true;
            if (A[start] <= A[mid]) {
                //lower part is sorted
                while (start < mid && A[start] == A[mid]) mid--; 
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            } else {
                //upper part is sorted;
                while (mid < end && A[mid] == A[end]) end--; 
                if (A[mid] <= target && target <=A[end]) {
                    start = mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = new int[5];
		A[0] = A[1] = 2;A[2] = A[3] = 3;A[4] = 1;
		Solution  s = new Solution();
		System.out.println(s.search(A, 1));
	}

}
