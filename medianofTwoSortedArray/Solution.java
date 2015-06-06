package medianofTwoSortedArray;

public class Solution {
	private double findMedianSortedArrays (int A[], int startA, int endA, 
										  int B[], int startB, int endB, int k) {
		if (endA - startA < 0) return B[startB + k]; 
		if (endB - startB < 0) return A[startA + k];
		if (k == 0) return Math.min(A[startA], B[startB]);
		
		int midA = (endA - startA) / 2;
		int midB = (endB - startB) / 2;
		int indexA = startA + midA;
		int indexB = startB + midB;
		// |        A(1)                    |          A(2)        |          
		// A[startA] A[startA+1] ..A[indexA] , A[indexA+1] ..A[endA]
		// |        B(1)                    |          B(2)        |
		// B[startB] B2[startB+1]..B[indexB] , B[indexB+1] ..B[endB]
		if (midA + midB >= k) {
			if (A[indexA] <= B[indexB]) {
				//drop B(2)
				return findMedianSortedArrays(A, startA, endA, B, startB, 
											  indexB == endB ? indexB - 1 : indexB, k);
			} else {
				//drop A(2)
				return findMedianSortedArrays(A, startA, 
											  indexA == endA ? indexA - 1 : indexA, B, startB, endB, k);
			}
		} else {
			if (A[indexA] <= B[indexB]) {
				//drop A(1)
				return findMedianSortedArrays(A, indexA+1, endA, B, startB, endB, 
											  k - (indexA - startA + 1));
			} else {
				//drop B(1)
				return findMedianSortedArrays(A, startA, endA, B, indexB+1, endB, 
											  k - (indexB - startB + 1));
			}
		}
	}
	
	public double findMedianSortedArrays(int A[], int B[]) {
        int startA = 0; int endA = A.length - 1;
        int startB = 0; int endB = B.length - 1;
        if ((A.length + B.length) % 2 == 0) {
        	return (findMedianSortedArrays(A, startA, endA, B, startB, endB, 
        								 (A.length + B.length) / 2 - 1) + 
        		    findMedianSortedArrays(A, startA, endA, B, startB, endB, 
        								 (A.length + B.length) / 2)) * 0.5;
        } else {
        	return findMedianSortedArrays(A, startA, endA, B, startB, endB, 
					 (A.length + B.length) / 2);
        }
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] =new int[4];
		int B[] =new int[4];
		A[0] = 1;A[1] = 1; A[2] = 3;A[3] = 3;
		B[0] = 1;B[1] = 1; B[2] = 3;B[3] = 3;
		Solution s = new Solution();
		System.out.println(s.findMedianSortedArrays(A, B));
	}

}
