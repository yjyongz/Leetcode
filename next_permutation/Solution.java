package next_permutation;

public class Solution {
	private void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	public void nextPermutation(int[] num) {
		int pivot = Integer.MAX_VALUE - 1, pivot1 = 0;
		for (int i = 0; i + 1< num.length; i++) {
			if (num[i] < num[i+1]) {
				pivot = i;
			}
		}
		for (int i = pivot + 1; i < num.length; i++) {
			if (num[pivot] < num[i]) {
				pivot1 = i;
			}
		}
		if (pivot != Integer.MAX_VALUE - 1) {
			swap(num, pivot, pivot1);
		} else {
			pivot = -1;
		}
		for (int i = num.length - 1, j = pivot + 1; j < i;i--,j++) {
			swap(num, j, i);
		}       
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = new int[3];
		num[0] = 1;num[1] = 2;num[2] = 3;
		Solution s =new Solution();
		
		for (int j=0;j < 7;j++) {
			for (int i=0;i<num.length;i++) {
				System.out.print(num[i] + " ");
			}
			s.nextPermutation(num);
			System.out.println();
		}
		System.out.println();
	}

}
