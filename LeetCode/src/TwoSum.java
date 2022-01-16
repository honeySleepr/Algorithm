import java.util.Arrays;

/* 내 solution.. 단순무식 2중 for문.. O(n^2);*/

public class TwoSum {
    public static void main(String[] args) {
        int[] answer = twoSum(new int[] {-3, 4, 2, -4}, 0);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

}
