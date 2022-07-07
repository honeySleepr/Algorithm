import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 모든 아나그램 찾기
// idea) map key : {a, b, c} == {c, a, b}
public class P0404 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");
		String[] target = br.readLine().split("");

		HashMap<String, Integer> targetMap = new HashMap<>();
		/*
		 target = [a,l,l]이면
		 targetMap = {a,1}, {l,2} 가 된다
		 */
		for (int i = 0; i < target.length; i++) {
			targetMap.put(target[i], targetMap.getOrDefault(target[i], 0) + 1);
		}
		HashMap<String, Integer> map = new HashMap<>();

		int l = 0;
		int answer = 0;
		for (int r = 0; r < arr.length; r++) {
			map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

			if (r - l + 1 > target.length) {
				if (map.get(arr[l]) > 1) {
					map.replace(arr[l], map.get(arr[l]) - 1);
				} else {
					map.remove(arr[l]);
				}
				l++;
			}
			if (targetMap.equals(map)) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
