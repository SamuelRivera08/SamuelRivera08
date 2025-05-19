import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class Tester here.
 *
 * @author Samuel Rivera
 * @version 1.0
 */
public class Tester
{
   public static int lives = 3;
   public static void main(String[] args) {
      Database database = new Database();
      int[] gamesPlayedList = new int[3];
      for(int i = 0 ; i < 3; i++){
         gamesPlayedList[i] =0;
      }
      int score= 0;

      while(lives > 0){


         System.out.println("Lives remaining: " + lives);
         int random1 = (int)(Math.random() * 3  + 1); //1, 2 or 3
         int random2;
         gamesPlayedList[random1 - 1] +=1;
         switch (random1){
            case 1:
               random2 = (int)(Math.random() * Database.getLength(random1));  //random int between 0 and 1 less than the length of list being accessed
               playWordle(Database.getWordleWord(random2));
               score+=10;
               Database.resetWord(1,random2);
            case 2:
               random2 = (int)(Math.random() * Database.getLength(random1)); //random int between 0 and 1 less than the length of list being accessed
               playQuiz(Database.getQuizWord(random2));
               score +=5;
               Database.resetWord(2,random2);
            case 3:
               random2 = (int)(Math.random() * Database.getLength(random1)); //random int between 0 and 1 less than the length of list being accessed
               playHangman(Database.getHangmanWord(random2));
               score +=10;
               Database.resetWord(3,random2);
         }

      }
      System.out.println("GAME OVER");
      System.out.println("Score: " + score);
      for(int i = 0; i < 3; i++){
         switch (i){
            case 1:
               System.out.print("Games of wordle: "  );
            case 2:
               System.out.print("Quiz questions: ");
            case 3:
               System.out.print("Games of hangman: ");
         }
         System.out.println(gamesPlayedList[i]);
      }


   }


   public static void playHangman(HangmanWord word){

      System.out.println("Let's play Hangman!");
      System.out.println();
      System.out.println( word.getDashString());
      while(!word.isFinished()){
         String character = getInput(1);
         
         System.out.println(word.hangman(character));
         
         
         System.out.println("Your hangman:");
         word.makeHangman(word.getGuesses());
         System.out.println();
         System.out.println("Guesses remaining:" + (Database.MAX_GUESSES - word.getGuesses()) );
         if(word.getLettersGuessed().length() > 0){
            System.out.println("Your incorrectly guessed letters: " + word.getLettersGuessed());
         }else{
            System.out.println("Your incorrectly guessed letters: none");
         }
         

      }
      if(word.hasWon()){
         System.out.println("Good job!");
      }else{
         System.out.println("Better luck next time!");
         lives--;
      }
      System.out.println();


   }
   public static void playWordle(WordleWord word){

      System.out.println("Let's play Wordle!");
      System.out.println();
      String guess = "";
      while(!word.isFinished()){
         guess = getInput(word.getWordString().length());
         
         System.out.println(word.wordle(guess));
         
         System.out.println("Guesses remaining:" + (Database.MAX_GUESSES - word.getGuesses()) );
         if(word.getLettersGuessed().length() > 0){
            System.out.println("Your incorrectly guessed letters: " + word.getLettersGuessed());
         }else{
            System.out.println("Your incorrectly guessed letters: none");
         }
         if(word.getLettersContained().length() > 0){
            System.out.println("Your correctly guessed letters: " + word.getLettersContained());
         }else{
            System.out.println("Your correctly guessed letters: none");
         }

      }
      if(word.hasWon()){
         System.out.println("Nice!");
      }else{
         System.out.println("Dang!");
         lives--;
      }
      System.out.println();
   }

   public static void playQuiz(QuizWord word){
      int choice = 0;
      word.printQuestion();
      choice = getIntInput(4);
      if(word.hasWon(choice)){
         System.out.println("Correct! " + word.getFullAnswer() );
      }else{
         System.out.println("Wrong! The correct answer was " + word.getWordString());
         lives--;
      }
      System.out.println();
   }


   public static int getIntInput(int max){
      int choice = 0;
      Scanner input = new Scanner(System.in);
      while(choice == 0){
         
         System.out.println("Please select a number");
         try {
            choice = input.nextInt();
            input.nextLine();
            if(choice > max || max <=0){
            System.out.println("Please guess a number from 1 to " + max);
            choice = 0;
            }
         }catch (Exception e) {
            System.out.println("input a lowercase letter");
         }
         
      }
      return choice;
   }






   public static String getInput(int length){
      String line = "";
      Scanner input = new Scanner(System.in);
      while(line.equals("")){
         
         if(length == 1){
            System.out.println("Please guess a character");
         }else{
            System.out.println("Try to guess a word " + length + " letters long!");
         }
         
         
         line = input.nextLine();
         
         if(line.length() != length && length > 0){
            if(length == 1){
               System.out.println("Please input a single letter");
            }else{
               System.out.println("Please input a word of length " + length);
            }
            line = "";
         
         }
         if(line.compareTo("a") < 0 || line.compareTo("z") > 0){
            line = "";
            System.out.println("input a lowercase letter");
            
         }
      }
      return line;
   }



}
