package duplicate;

public class Solution {
	public int removeDuplicates(int[] A) {
        if (A.length == 0 || A.length == 1) return A.length;
        int start = 1;
        for (int i = start+1;i < A.length;i++) {
            if (!(A[i] == A[start] && A[i] == A[start-1])) {
            	A[++start] = A[i];
            }
        }
        return start+1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int [] A = new int[6];
		A[0] = A[1] = A[2] = 1;
		A[3] = 2;A[4] = 2;A[5] = 3;
		/*A = new int[2];
		A[0] = 1; A[1] = 1;*/
		System.out.println(s.removeDuplicates(A));
	}

}
