package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StringCoach {
    private static ArrayList<String> listOfWords = new ArrayList();

    public static void practice() {
        loadWords();
        boolean isPlaying = true;
        System.out.println("Welcome to a Unit 2 review app!");
        while(isPlaying == true) {
            System.out.println("Type the number of the topic you want to review: ");
            System.out.println("1 - .subString() Method");
            System.out.println("2 - .length() Method");
            Scanner userPrompt = new Scanner(System.in);
            String userResponse = userPrompt.nextLine();
            if(userResponse.equals("1")) {
                subStringGame();
            }
            else if(userResponse.equals("2")) {
                lengthGuesser();
            }
            else {
                System.out.println("Sorry, I don't understand.");
            }
            System.out.println("Keep playing? Types yes or no");
            userResponse = userPrompt.nextLine();
            if(userResponse.equalsIgnoreCase("yes")) {

            }
            else {
                isPlaying = false;
            }
        }
        System.out.println("Thanks for practicing!");

    }

    public static void loadWords() {
        Scanner s = null;
        try {
            s = new Scanner(new File("WordList.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            listOfWords.add(s.next());
        }
        s.close();
    }

    public static String selectRandomWord() {
        int indexPos = (int) (Math.random()*listOfWords.size()-1)+1;
        String wordSelected = listOfWords.get(indexPos);
        return wordSelected;
    }

    public static void lengthGuesser() {
        Scanner userInput = new Scanner(System.in);
        String wordSelected = selectRandomWord();
        System.out.print("If I run \"" + wordSelected + ".length()\", the return value will be: ");
        int userAnswer = userInput.nextInt();
        if(userAnswer == wordSelected.length()) {
            System.out.println("Correct!");
        }
        else {
            System.out.println("Nope!");
        }
    }

    public static void subStringGame() {
        String word = selectRandomWord();
        String firstHalf = word.substring(0,word.length()/2-1);
        String secondHalf = word.substring(word.length()/2,word.length()-1);
        int firstHalfSub1 = 0;
        int firstHalfSub2 = word.length()/2-1;
        int secondHalfSub1 = word.length()/2;
        int secondHalfSub2 = word.length()-1;
        //Range = (Math.random()*max-min+1)+min
        int randomPos1 = (int)(Math.random()*firstHalfSub2+1);
        int randomPos2 = (int)(Math.random()*secondHalfSub2-secondHalfSub1+1)+secondHalfSub1;
        System.out.println(randomPos1);
        System.out.println(randomPos2);
        System.out.println("What will be the String output of \"" + word + ".subString(" + randomPos1 + "," + randomPos2 + ")\"");
        String answer = word.substring(randomPos1,randomPos2);
        Scanner userGuess = new Scanner(System.in);
        String userResponse = userGuess.nextLine();
        if(userResponse.equals(answer)) {
            System.out.println("Correct!");
        }
        else {
            System.out.println("Incorrect!");
        }
    }


}
