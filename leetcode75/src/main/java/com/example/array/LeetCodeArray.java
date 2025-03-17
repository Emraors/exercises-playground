package com.example.array;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCodeArray {

	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		OptionalInt max = Arrays.stream(candies).max();
		int asInt = max.orElse(0);

		return Arrays.stream(candies).mapToObj(candy -> candy + extraCandies >= asInt)
				.collect(Collectors.toList());
	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		List<Integer> planted = new ArrayList<>();

		for (int i = 0; i < flowerbed.length; i++) {
			if (isPlantable(flowerbed, i)) {
				flowerbed[i] = 1;
				planted.add(i);
			}
		}

		return planted.size() >= n;
	}

	public boolean isPlantable(int[] flowerbed, int index) {
		if (flowerbed.length == 1) {
			return flowerbed[0] == 0;
		}
		int left = (index == 0) ? 0 : flowerbed[index - 1];
		int right = (index == flowerbed.length - 1) ? 0 : flowerbed[index + 1];

		return (flowerbed[index] + left + right == 0);
	}

	public String reverseVowels(String s) {
		if (s.isEmpty())
			return "";

		List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

		char[] charArray = s.toCharArray();
		int left = 0, right = charArray.length - 1;
		while (left < right) {
			boolean isLeftVowel = vowels.contains(charArray[left]);
			boolean isRightVowel = vowels.contains(charArray[right]);

			if (isLeftVowel && isRightVowel) {
				char temp = charArray[left];
				charArray[left] = charArray[right];
				charArray[right] = temp;
				left++;
				right--;
			} else if (!isLeftVowel) {
				left++;
			} else {
				right--;
			}
		}
		return new String(charArray);
	}

	public String reverseWords(String s) {
		String[] words = s.isBlank() ? new String[] {} : s.trim().split("\\s+");
		StringBuilder builder = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			builder.append(words[i]).append(" ");
		}
		return builder.toString().trim();
	}

	public boolean increasingTriplet(int[] nums) {
		int length = nums.length;
		if (length < 3)
			return false;

		int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE, index = 0;
		while (index < length) {
			int num = nums[index];
			if (num < first) {
				first = num;
			}
			if (first < num && num < second) {
				second = num;
			}
			if (first < num && second < num) {
				return true;
			}
			index++;
		}
		return false;
	}

	public boolean increasingTripletWithMaps(int[] nums) {
		int n = nums.length;
		if (n < 3)
			return false;

		Map<Integer, Integer> leftMinMap = new HashMap<>();
		int currentMin = nums[0];
		leftMinMap.put(0, currentMin);
		for (int i = 1; i < n; i++) {
			currentMin = Math.min(currentMin, nums[i]);
			leftMinMap.put(i, currentMin);
		}

		Map<Integer, Integer> rightMaxMap = new HashMap<>();
		int currentMax = nums[n - 1];
		rightMaxMap.put(n - 1, currentMax);
		for (int i = n - 2; i >= 0; i--) {
			currentMax = Math.max(currentMax, nums[i]);
			rightMaxMap.put(i, currentMax);
		}

		for (int i = 1; i < n - 1; i++) {
			if (leftMinMap.get(i) < nums[i] && nums[i] < rightMaxMap.get(i)) {
				return true;
			}
		}
		return false;
	}

	public int compress(char[] chars) {
		int index = 0, counter = 0, moving = 0, length = chars.length;
		while (index < length) {
			char c = chars[index];
			while (index < length && c == chars[index]) {
				counter++;
				index++;
			}
			chars[moving++] = c;
			if (counter > 1)
				for (char digit : Integer.toString(counter).toCharArray())
					chars[moving++] = digit;
			counter = 0;
		}
		return moving;
	}
}
