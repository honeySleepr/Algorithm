package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * <h1><a href="https://www.acmicpc.net/problem/7662">이중 우선순위 큐</a></h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎︎</h2>
 * <h2>날짜 : 2022/11/07</h2>
 * <br><h2>comment : Tree Map 사용법을 배웠다</h2>
 */
public class BJ7662 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			TreeMap<Integer, Integer> map = new TreeMap<>();
			int k = Integer.parseInt(br.readLine());

			for (int j = 0; j < k; j++) {
				String[] split = br.readLine().split("\\s");

				if (split[0].equals("I")) {
					int num = Integer.parseInt(split[1]);
					map.put(num, map.getOrDefault(num, 0) + 1);
					continue;
				}

				if (split[0].equals("D") && !map.isEmpty()) {
					Entry<Integer, Integer> entry;
					if (split[1].equals("-1")) {
						entry = map.firstEntry();
					} else {
						entry = map.lastEntry();
					}

					Integer key = entry.getKey();
					Integer value = entry.getValue();
					if (value - 1 == 0) {
						map.remove(key);
					} else {
						map.replace(key, value - 1);
					}
				}
			}

			if (map.isEmpty()) {
				sb.append("EMPTY").append("\n");
				continue;
			}
			sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
		}
		System.out.println(sb);
	}

}
