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

	public int longestCommonSubsequence(String text1, String text2) {
		if (text1.isEmpty() || text2.isEmpty()) {
			return 0;
		}
		int m = text1.length();
		int n = text2.length();

		int[][] mem = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				mem[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1)
						? mem[i - 1][j - 1] + 1
						: Math.max(mem[i - 1][j], mem[i][j - 1]);
			}
		}

		return mem[m][n];
	}

	public int maxProfit(int[] prices, int fee) {
		int length = prices.length;
		if (length == 0)
			return 0;

		int[] memOwn = new int[length];
		int[] memNOwn = new int[length];

		memNOwn[0] = 0;
		memOwn[0] = -prices[0];

		for (int i = 1; i < length; i++) {
			memOwn[i] = Math.max(memOwn[i - 1], memNOwn[i - 1] - prices[i]);
			memNOwn[i] = Math.max(memNOwn[i - 1], memOwn[i - 1] + prices[i] - fee);
		}
		return memNOwn[length - 1];
	}

	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();

		if (m == 0)
			return n;
		if (n == 0)
			return m;

		int[][] mem = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			mem[i][0] = i;
		}
		for (int j = 0; j <= n; j++) {
			mem[0][j] = j;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				mem[i][j] = Math.min(
						Math.min(mem[i - 1][j] + 1, mem[i][j - 1] + 1),
						mem[i - 1][j - 1] +
								(word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1)
				);
			}
		}

		return mem[m][n];
	}
}
