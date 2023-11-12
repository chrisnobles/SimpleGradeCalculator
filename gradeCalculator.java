import java.util.Scanner;
import java.util.Arrays;
//This calculator calculates you quiz avg. & automatically drops the lowest 4 quizzes

class Calculator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many quizzes have you taken?");
		float numQuizzes = input.nextFloat();
		float[] Quizzes = new float[(int) numQuizzes];
		float sum = 0;
		
		System.out.println("How many quizzes are getting dropped? ");
		float drops = input.nextFloat();

		System.out.println("Enter your quiz grades: ");
		
		for (int i = 0; i < numQuizzes; i++) {
			System.out.print("Quiz #" + (i+1) + ": ");
			Quizzes[i] = input.nextInt();
			sum += Quizzes[i];
		}
		
		//Drop the lowest 4 quizzes
		Arrays.sort(Quizzes);
		for (int i = 0; i < drops; i++) {
			sum -= Quizzes[i];
			numQuizzes--;
		}
		
		float grade = sum/numQuizzes;
				
		System.out.println("Quiz Average: " + grade + "%");
		
	}

}

