public class P0701 {


	private static void solution(int i) {

		if (i == 0) {
			return;
		}
		solution(i - 1);
		System.out.print(i + " ");
	}

	public static void main(String[] args) {

		solution(3);
	}
}
