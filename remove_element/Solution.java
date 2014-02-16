package remove_element;

public class Solution {
	public int removeElement(int[] A, int elem) {
        int len = A.length;
        for (int i = 0; i < len; ) {
            if (A[i] == elem) {
                A[i] = A[--len];
            } else {
                i++;
            }
        }
        return len;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int A[] = new int[3];
		A[0] = 1;A[1] = 1; A[2] = 3;
		int len = s.removeElement(A, 1);
		System.out.print(len);
	}

}
