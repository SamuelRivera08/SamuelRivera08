import java.util.ArrayList;
public class Database {

    public static final int STARTING_HEALTH = 100;
    private static ArrayList<PowerUp> powerDataBase = new ArrayList<PowerUp>();
    private static ArrayList<QuizWord> quizList = new ArrayList<QuizWord>();
    private static ArrayList<WordleWord> wordleList = new ArrayList<WordleWord>();
    private static ArrayList<HangmanWord> hangList = new ArrayList<HangmanWord>();
    public static final int MAX_GUESSES = 6;



    public Database(){
            powerDataBase.add(new PowerUp("WorldeDistance", "If the letter is in the word and you guess wrong, the distance from its place is shown",
             "wordle"));


             quizList.add(new QuizWord("An egg!", "What has to be broken before you can use it? _"));
             quizList.add(new QuizWord("A candle", "I’m tall when I’m young, and I’m short when I’m old. What am I?\r\n" + //
                                  "_"));
             quizList.add(new QuizWord("A sponge", " What is full of holes but still holds water?_"));
             quizList.add(new QuizWord("Replace the t with an i!", "How do you make easter easier? _"));
             
             quizList.add(new QuizWord("Your age ", " What goes up but never goes down?_"));
             quizList.add(new QuizWord("The government", "I have branches, but no fruit, trunk or leaves. What am I?_"));
             quizList.add(new QuizWord("Darkness", " The more of this there is, the less you see._"));
             quizList.add(new QuizWord("Nectar!", " What do bees collect to make money? _"));
             quizList.add(new QuizWord("Flamboyance", "A _ is a group of flamingos"));
             quizList.add(new QuizWord("Diamond!", "What is the hardest natural substance on Earth?? _"));



             hangList.add(new HangmanWord("a bundle of sticks"));
             hangList.add(new HangmanWord("what goes around comes around"));
             hangList.add(new HangmanWord("when in rome"));
             hangList.add(new HangmanWord("dont stop get it get it"));
             hangList.add(new HangmanWord("happy holidays"));
             hangList.add(new HangmanWord("If you give a mouse a cookie"));
             hangList.add(new HangmanWord("computer science"));

            wordleList.add(new WordleWord("stack"));
            wordleList.add(new WordleWord("carts"));
            wordleList.add(new WordleWord("dazed"));
            wordleList.add(new WordleWord("boxer"));
            wordleList.add(new WordleWord("aback"));
            wordleList.add(new WordleWord("aegis"));
            wordleList.add(new WordleWord("locus"));
            wordleList.add(new WordleWord("youth"));
            wordleList.add(new WordleWord("cycle"));

            wordleList.add(new WordleWord("fleet"));
            wordleList.add(new WordleWord("known"));
            wordleList.add(new WordleWord("north"));
            wordleList.add(new WordleWord("alert"));
            wordleList.add(new WordleWord("given"));
            wordleList.add(new WordleWord("noted"));
            wordleList.add(new WordleWord("prove"));
            wordleList.add(new WordleWord("fresh"));
            wordleList.add(new WordleWord("dream"));

            wordleList.add(new WordleWord("forty"));
            wordleList.add(new WordleWord("found"));
            wordleList.add(new WordleWord("major"));
            wordleList.add(new WordleWord("mouth"));
            wordleList.add(new WordleWord("stuff"));
            wordleList.add(new WordleWord("under"));
            wordleList.add(new WordleWord("great"));
            wordleList.add(new WordleWord("heavy"));
            wordleList.add(new WordleWord("drawn"));
            wordleList.add(new WordleWord("blare"));
    



    }


    public static int getLength(int category){
        switch (category) {
            case 1:
                return wordleList.size();
            case 2:
                return quizList.size();
            case 3:
                return hangList.size();
       
             default: return 1;
        }
        
    
    
    
    }


    public static String[] getRandomAnswers(String actualAnswer){
        String[] strList = new String[3];
        for(int i = 0; i < 3; i++){
            int random = (int)(Math.random() * quizList.size());
            String answer = quizList.get(random).getWordString();
            boolean notDuplicate = true;
            
            for(String str:strList){
                if( str != null && answer.equals(str)){
                    notDuplicate = false;
                }
            }
            if(answer.equals(actualAnswer)){
                notDuplicate = false;
            } //if word already exists in list or will be the answer, repeat until find unique word
            
            
            if(!notDuplicate){
                i--;
            }else{
                strList[i] = answer;
            }
        }
        return strList;
    }

    public static void resetWord(int category, int index){
        switch(category){
            case 1:
                //wordle
                WordleWord word = new WordleWord(wordleList.get(index).getWordString());
                wordleList.set(index, word);
            case 2:
                QuizWord word2 = new QuizWord(quizList.get(index).getWordString(), 
                quizList.get(index).getQuestion());
                quizList.set(index, word2);
                //quiz
            case 3:
                HangmanWord word3 = new HangmanWord(hangList.get(index).getWordString());
                hangList.set(index, word3);
                //hangMan
        }
    }




    public static QuizWord getQuizWord(int i){
        return quizList.get(i);
    }
    public static WordleWord getWordleWord(int i){
        return wordleList.get(i);
    }
    
    public static HangmanWord getHangmanWord(int i){
        return hangList.get(i);
    }

}
