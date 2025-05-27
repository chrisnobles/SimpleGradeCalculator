import java.util.*;

public class Crypt_GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float[] homework = new float[4];
        float[] tests = new float[3];

        for (int i = 0; i < 4; i++) {
            System.out.print("Enter Homework " + (i + 1) + " score (0-100): ");
            homework[i] = scanner.nextFloat();
        }

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter Exam " + (i + 1) + " score (0-100): ");
            tests[i] = scanner.nextFloat();
        }

        System.out.print("Enter Final Exam score (0-100): ");
        float finalExam = scanner.nextFloat();

        System.out.print("Enter Term Paper score (0-100): ");
        float termPaper = scanner.nextFloat();

        // Option 1
        float hwAvg1 = averageBestN(homework, 3);
        float examAvg1 = averageAll(tests);
        float total1 = hwAvg1 * 0.45f + examAvg1 * 0.45f + termPaper * 0.10f;

        // Option 2
        float hwAvg2 = averageBestN(homework, 3);
        float examAvg2 = averageBestN(tests, 2);
        float total2 = hwAvg2 * 0.45f + examAvg2 * 0.30f + termPaper * 0.10f + finalExam * 0.15f;

        // Option 3
        float hwAvg3 = averageBestN(homework, 2);
        float examAvg3 = averageAll(tests);
        float total3 = hwAvg3 * 0.30f + examAvg3 * 0.45f + termPaper * 0.10f + finalExam * 0.15f;

        // Option 4
        float hwAvg4 = averageAll(homework);
        float examAvg4 = averageBestN(tests, 2);
        float total4 = hwAvg4 * 0.60f + examAvg4 * 0.30f + termPaper * 0.10f;

        // Results
        System.out.printf("\nGrade by Option 1: %.2f%%\n", total1);
        System.out.printf("Grade by Option 2: %.2f%%\n", total2);
        System.out.printf("Grade by Option 3: %.2f%%\n", total3);
        System.out.printf("Grade by Option 4: %.2f%%\n", total4);

        scanner.close();
    }

    private static float averageAll(float[] arr) {
        float sum = 0;
        for (float v : arr) sum += v;
        return sum / arr.length;
    }

    private static float averageBestN(float[] arr, int n) {
        float[] copy = arr.clone();
        Arrays.sort(copy);
        float sum = 0;
        for (int i = copy.length - n; i < copy.length; i++) {
            sum += copy[i];
        }
        return sum / n;
    }
}
