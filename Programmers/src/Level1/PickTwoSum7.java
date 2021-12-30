package Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PickTwoSum7 {
	public static void main(String[] args) {
		Solution7 sol = new Solution7();
		sol.solution(new int[] {5, 0, 2, 7});
	}
}

class Solution7 {
	public int[] solution(int[] numbers) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		int[] answer = list.stream().mapToInt(i -> i).toArray();
		return answer;
	}
}
