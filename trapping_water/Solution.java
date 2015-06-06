package trapping_water;

public class Solution {
	public int trap(int[] A) {
		if (A == null || A.length == 0) return 0;
        int result = 0;int pivot = A[0];
        int sum = 0;
        for (int i=0;i < A.length - 1;i++) {
        	if (pivot > A[i+1]) {
        		sum += (pivot - A[i+1]);
        	} else {
        		pivot = A[i+1];
        		result += sum;
        		sum = 0;
        	}
        }
        sum = 0;pivot = A[A.length - 1];
        for (int i=A.length - 1;i > 0;i--) {
        	if (pivot > A[i-1]) {
        		sum += (pivot - A[i-1]);
        	} else if (pivot != A[i-1]) {
        		pivot = A[i-1];
        		result += sum;
        		sum = 0;
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
		/*int A[] = new int[12];
		A[0] = 0;A[1] = 1;A[2] = 0;A[3] = 2;
		A[4] = 1;A[5] = 0;A[6] = 1;A[7] = 3;
		A[8] = 2;A[9] = 1;A[10] = 2;A[11] = 1;*/
		int A[] = new int[3];
		A[0] = 2;A[1] = 0;A[2] = 2;
		System.out.println(s.trap(A));
	}

}
