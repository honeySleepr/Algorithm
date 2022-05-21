import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://cote.inflearn.com/contest/10/problem/06-03
// 삽입 정렬
public class P0603 {
	/* solution 함수로 나누는게 확실히 보기 편하다. 그리고 String[] 대신 int[]로 바꿔서 쓰자 */
	private static String[] solution(int n, String[] arr) {

		for (int i = 1; i < n; i++) {
			int target = 0;
			String temp = arr[i];
			for (int j = i - 1; j >= 0; j--) {
				if (Integer.parseInt(arr[j]) > Integer.parseInt(temp)) {
					arr[j + 1] = arr[j];
					target = j;
				} else {
					target = j + 1;
					break;
				}
			}
			arr[target] = temp;
		}//ddd
		return arr;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split("\\s");

		String [] result = solution(n, arr);

		StringBuilder sb = new StringBuilder();
		for (String s : result) {
			sb.append(s).append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);

	}
}
/*
6
11 7 5 6 10 9
11 7 7
5 11 7

1 5 7

6
3 7 1 5 2 9 6

* */
