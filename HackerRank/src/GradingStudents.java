import java.util.ArrayList;
import java.util.List;

public class GradingStudents {
    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> newGrades = new ArrayList<>();

        for (Integer grade : grades) {
            if (grade < 38 || grade % 5 == 0 || grade % 5 < 3) {
                newGrades.add(grade);
                continue;
            }
            newGrades.add(grade + (5 - (grade % 5)));
        }

        return newGrades;
    }
}
