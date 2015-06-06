package next_permutation_kth;


public class Solution {
	private int fac(int n) {
		int sum = 1;
		for (int i=1;i<=n;i++) {
			sum *= i;
		}
		return sum;
	}
	public String getPermutation(int n, int k) {
		StringBuffer buf = new StringBuffer();
		int num = fac(n-1);
		int arr[] = new int[n];
		for (int i = 0;i<n;i++) {
			arr[i] = i+1;
		}
		k = k - 1;
		int j = 1;
		while (buf.length() != n) {
			int index = k / fac(n-j);
			buf.append((char)(arr[index] + '0'));
			for (int i = index;i < n -1;i++) {
				arr[i] = arr[i+1];
			}
			k = k % fac(n-j);
			j++;
		}
		return buf.toString();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s =new Solution();
		for (int i=0;i<6;i++) {
			System.out.println(i+1 + " " + s.getPermutation(3, i+1));
		}

	}

}
