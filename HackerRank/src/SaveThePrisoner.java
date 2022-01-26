public class SaveThePrisoner {
    /*
     * Complete the 'saveThePrisoner' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n : prisoners
     *  2. INTEGER m : candies
     *  3. INTEGER s : starting chair
     */
    //5 2 1 -> 2
    // 5 2 2 -> 3
    // 5 2 4 -> 5
    // 5 6 4 -> 4
    // 5 7 4 -> 5

    public static int saveThePrisoner(int n, int m, int s) {
        int answer = (s - 1 + m) % n;
        if (answer == 0) {
            return n;
        }
        return answer;
    }

    public static void main(String[] args) {
        SaveThePrisoner.saveThePrisoner(5, 7, 3);
    }
}
