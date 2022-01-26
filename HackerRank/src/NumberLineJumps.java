public class NumberLineJumps {
    //Kangaroo problem

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        if (v1 < v2) {
            return "NO";
        }
        if (v1 == v2 && x1 < x2) {
            return "NO";
        }

        int i = 1;
        while (true) {
            if ((x1 + v1 * i) > (x2 + v2 * i)) {
                return "NO";
            }
            if ((x1 + v1 * i) == (x2 + v2 * i)) {
                return "YES";
            }
            i++;
        }
    }

    public static void main(String[] args) {
        NumberLineJumps.kangaroo(0, 2, 1, 3);
    }

}
