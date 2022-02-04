package bronze;

//정수 N개의 합
public class BJ15596 {
    public static void main(String[] args) {

    }

    long sum(int[] a) {
        long sum = 0;
        for (int num : a) {
            sum += num;
        }
        return sum;
    }
}
