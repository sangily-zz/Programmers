import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public int[] solution(int[] answers) {
		ArrayList<Integer> first = new ArrayList<Integer>();
		ArrayList<Integer> second = new ArrayList<Integer>();

		int i = 1;
		int idx = 0;
		while (true) {
			if (i % 6 != 0)
				first.add(i % 6);
			if (idx == 12500)
				break;
			idx++;
			i++;
		}

		i = 1;
		idx = 0;
		int special = 1;
		while (true) {
			if (i % 2 != 0)
				second.add(2);
			else {
				if (special > 5) {
					special = 1;
				}
				second.add(special);
				if (special == 1) {
					special += 2;
				} else {
					special++;
				}
			}
			if (idx == 10000)
				break;
			idx++;
			i++;
		}

		ArrayList<Integer> third = new ArrayList<Integer>();
		i = 1;
		idx = 0;
		special = 3;
		int cnt = 1;
		while (true) {
			if (cnt > 2) {
				if (special == 3) {
					special = 1;
				} else if (special == 2) {
					special += 2;
				} else if (special == 5) {
					special = 3;
				} else {
					special++;
				}
				cnt = 1;
			}
			third.add(special);
			cnt++;
			if (idx == 10000)
				break;
			idx++;
			i++;
		}

		int ans[] = new int[3];

		int max = 0;
		for (int j = 0; j < answers.length; j++) {
			int temp = answers[j];
			if (first.get(j) == temp) {
				ans[0]++;
			}
			if (second.get(j) == temp) {
				ans[1]++;
			}
			if (third.get(j) == temp) {
				ans[2]++;
			}
		}

		for (int ii = 0; ii < 3; ii++) {
			max = Math.max(max, ans[ii]);
		}

		int index = 0;

		for (int ii = 0; ii < 3; ii++) {
			if (max == ans[ii]) {
				index++;
			}
		}

		int[] answer = new int[index];

		index = 0;
		for (int ii = 0; ii < 3; ii++) {
			if (max == ans[ii]) {
				answer[index] = ii + 1;
				index++;
			}
		}

		return answer;
	}
}