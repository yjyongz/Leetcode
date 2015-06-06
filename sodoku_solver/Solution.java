package sodoku_solver;

public class Solution {
	private int getIndex (int row, int col) {
		if (row >= 0 && row <= 2) {
			if (col >= 0 && col <= 2) {
				return 0;
			}
			if (col >= 3 && col <= 5) {
				return 1;
			}
			if (col >= 6 && col <= 8) {
				return 2;
			}
		}
		if (row >= 3 && row <= 5) {
			if (col >= 0 && col <= 2) {
				return 3;
			}
			if (col >= 3 && col <= 5) {
				return 4;
			}
			if (col >= 6 && col <= 8) {
				return 5;
			}
		}
		if (row >= 6 && row <= 8) {
			if (col >= 0 && col <= 2) {
				return 6;
			}
			if (col >= 3 && col <= 5) {
				return 7;
			}
			if (col >= 6 && col <= 8) {
				return 8;
			}
		}
		return 0;
	}
	public boolean isValidSudoku(char[][] board) {
        boolean ret = true;
        int row[] = new int[9];
        int col[] = new int[9];
        int mat[] = new int[9];
        
        for (int i=0;i < board.length;i++) {
        	for (int j=0; j < board[i].length;j++) {
        		if (board[i][j] != '.') {
        			if ((row[i] & (1 << (int)(board[i][j] - '0'))) != 0) {
        				return false;
        			}
        			if ((col[j] & (1 << (int)(board[i][j] - '0'))) != 0) {
        				return false;
        			}
        			if ((mat[getIndex(i,j)] & (1 << (int)(board[i][j] - '0'))) != 0) {
        				return false;
        			}
        			row[i] |= 1 << (board[i][j] - '0');
        			col[j] |= 1 << (board[i][j] - '0');
        			mat[getIndex(i,j)] |= 1 << (board[i][j] - '0');
        		}
        	}
        }
        return ret;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char mat [][] = new char[9][9];
		mat[0][0] = '.';mat[0][1] = '.';mat[0][2] = '4';mat[0][3] = '.';mat[0][4] = '.';mat[0][5] = '.';mat[0][6] = '6';mat[0][7] = '3';mat[0][8] = '.';
		mat[1][0] = '.';mat[1][1] = '.';mat[1][2] = '.';mat[1][3] = '.';mat[1][4] = '.';mat[1][5] = '.';mat[1][6] = '.';mat[1][7] = '.';mat[1][8] = '.';
		mat[2][0] = '5';mat[2][1] = '.';mat[2][2] = '.';mat[2][3] = '.';mat[2][4] = '.';mat[2][5] = '.';mat[2][6] = '.';mat[2][7] = '9';mat[2][8] = '.';
		mat[3][0] = '.';mat[3][1] = '.';mat[3][2] = '.';mat[3][3] = '5';mat[3][4] = '6';mat[3][5] = '.';mat[3][6] = '.';mat[3][7] = '.';mat[3][8] = '.';
		mat[4][0] = '4';mat[4][1] = '.';mat[4][2] = '3';mat[4][3] = '.';mat[4][4] = '.';mat[4][5] = '.';mat[4][6] = '.';mat[4][7] = '.';mat[4][8] = '1';
		mat[5][0] = '.';mat[5][1] = '.';mat[5][2] = '.';mat[5][3] = '7';mat[5][4] = '.';mat[5][5] = '.';mat[5][6] = '.';mat[5][7] = '.';mat[5][8] = '.';
		mat[6][0] = '.';mat[6][1] = '.';mat[6][2] = '.';mat[6][3] = '5';mat[6][4] = '.';mat[6][5] = '.';mat[6][6] = '.';mat[6][7] = '.';mat[6][8] = '1';
		mat[7][0] = '.';mat[7][1] = '.';mat[7][2] = '.';mat[7][3] = '.';mat[7][4] = '.';mat[7][5] = '.';mat[7][6] = '.';mat[7][7] = '.';mat[7][8] = '.';
		mat[8][0] = '.';mat[8][1] = '.';mat[8][2] = '.';mat[8][3] = '.';mat[8][4] = '.';mat[8][5] = '.';mat[8][6] = '.';mat[8][7] = '.';mat[8][8] = '.';
		Solution s = new Solution();
		System.out.println(s.isValidSudoku(mat));
	}

}
