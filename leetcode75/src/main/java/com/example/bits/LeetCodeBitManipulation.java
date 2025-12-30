package com.example.bits;

public class LeetCodeBitManipulation {

	public int[] countBits(int n) {
		int[] res = new int[n + 1];

		int lastPowerOfTwo = 1;
		for (int i = 1; i <= n; i++) {
			if ((i & (i - 1)) == 0) {
				lastPowerOfTwo = i;
				res[i] = 1;
			} else {
				res[i] = 1 + res[i - lastPowerOfTwo];
			}
		}
		return res;
	}

	public int singleNumber(int[] nums) {
		int xor = 0;
		for (int num : nums) {
			xor ^= num;
		}
		return xor;
	}

	public int minFlips(int a, int b, int c) {
		int flips = 0;

		while (a != 0 || b != 0 || c != 0) {
			int abit = a & 1;
			int bbit = b & 1;
			int cbit = c & 1;

			if (cbit == 1) {
				if ((abit | bbit) == 0)
					flips += 1;
			} else {
				flips += abit + bbit;
			}

			a >>>= 1;
			b >>>= 1;
			c >>>= 1;
		}

		return flips;
	}
}
