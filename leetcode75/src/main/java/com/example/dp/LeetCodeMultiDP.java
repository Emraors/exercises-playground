package com.example.dp;

public class LeetCodeMultiDP {

	public int uniquePaths(int m, int n) {
		if (n == 0 || m == 0)
			return 0;

		int[][] mem = new int[m + 1][n + 1];
		mem[1][1] = 1;

		for (int i = 1; i <= m; i++) {
			mem[i][1] = 1;
		}

		for (int j = 1; j <= n; j++) {
			mem[1][j] = 1;
		}

		for (int i = 2; i <= m; i++) {
			for (int j = 2; j <= n; j++) {
				mem[i][j] = mem[i - 1][j] + mem[i][j - 1];
			}
		}

		return mem[m][n];
	}
}
