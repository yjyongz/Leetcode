package removeDuplicatesfromSortedArray;

public class Solution {
	public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int start = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[start] == A[i]) {
                continue;
            }
            A[++start] = A[i];
        }
        return start+1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = new int[4];
		A[0] = A[1] = 1;
		A[2] = A[3] = 2;
		Solution s = new Solution();
		int len = s.removeDuplicates(A);
		for (int i= 0; i < len; i++) {
			System.out.println(A[i]);
		}
	}

}
