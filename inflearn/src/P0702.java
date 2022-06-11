import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P0702 {

	private static void solution(int num) {
		if (num == 1) {
			System.out.print(1);
			return;
		}
		int binary = num % 2;
		num = num / 2;
		solution(num);

		System.out.print(binary);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		solution(num);
	}

}
