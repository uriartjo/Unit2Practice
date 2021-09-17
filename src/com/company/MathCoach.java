package com.company;

import java.util.Scanner;

public class MathCoach {

    public static void randomRange() {
        /*
         * (int)(Math.random()*range) + min moves the random number into a range starting from a minimum number.
         * The range is the (max number - min number + 1).
         */
        boolean isPlaying = true;
        while(isPlaying) {
            Scanner userInput = new Scanner(System.in);
            boolean correct = true;
            int number1 = (int)(Math.random()*11);
            int number2 = (int)(Math.random()*81)+20;
            int answerValue1 = number2-number1+1;
            int answerValue2 = number1;
            System.out.println("You want to generate a random number between " + number1 + " and " + number2 +" (inclusive)");
            System.out.println("What two values go in the following line. ");
            System.out.println("int x = (int)(Math.random()*VALUE1) + "+ "VALUE2");
            System.out.print("Value1 should be: " );
            int userAnswer1 = userInput.nextInt();
            System.out.print("Value2 should be: " );
            int userAnswer2 = userInput.nextInt();
            if(userAnswer1 == answerValue1 && userAnswer2 ==answerValue2) {
                System.out.println("Correct!");
            }
            else {
                System.out.println("Incorrect!");
                System.out.println("Value1 should have been: " + answerValue1);
                System.out.println("Value2 should have been: " + answerValue2);

            }
            System.out.println("Play again? Type yes or no");
            Scanner playPrompt = new Scanner(System.in);
            String playAnswer = playPrompt.nextLine();
            if(playAnswer.equalsIgnoreCase("yes")) {

            }
            else {
                isPlaying = false;
            }
        }

    }
}
