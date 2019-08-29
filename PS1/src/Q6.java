import java.util.Scanner;

public class Q6 {
    public static void main(String[] args){
        System.out.println("Enter name");
        Scanner keyboard = new Scanner(System.in);
        TestScores scores = new TestScores(keyboard.nextLine());
        System.out.println("Enter score 1 or a negative number to exit");
        double scoreReceived = keyboard.nextDouble();
        int scoreCount = 2;
        while (scoreReceived >= 0){
            scores.addTestScore(scoreReceived);
            System.out.println("Enter score " + scoreCount + " or a negative number to exit");
            scoreReceived = keyboard.nextDouble();
            scoreCount++;
        }

        System.out.println("-- " + scores.getName() + " --");
        System.out.println("Num tests taken: " + scores.getNumTestsTaken());
        System.out.printf("Average: %.1f\n", scores.getAverage());
    }
}
