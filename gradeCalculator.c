#include <stdio.h>
#include <stdlib.h>

// Function to compare two elements for qsort
int compare(const void * a, const void * b) {
    return ( *(float*)a - *(float*)b );
}

int main() {
    int numQuizzes;
    printf("How many quizzes have you taken? ");
    scanf("%d", &numQuizzes);

    float Quizzes[numQuizzes];
    float sum = 0;

    int drops;
    printf("How many quizzes are getting dropped? ");
    scanf("%d", &drops);

    printf("Enter your quiz grades: \n");
    for (int i = 0; i < numQuizzes; i++) {
        printf("Quiz #%d: ", i + 1);
        scanf("%f", &Quizzes[i]);
        sum += Quizzes[i];
    }

    // Drop the lowest 'drops' quizzes
    qsort(Quizzes, numQuizzes, sizeof(float), compare);
    for (int i = 0; i < drops; i++) {
        sum -= Quizzes[i];
        numQuizzes--;
    }

    float grade = sum / numQuizzes;

    printf("Quiz Average: %.2f%%\n", grade);

    return 0;
}

