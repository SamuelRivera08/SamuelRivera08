

public class QuizWord extends Word{
    private String question;
    private int random;
    public QuizWord(String wordString, String question){
        super(wordString, 2);
        this.question =question;
    }

    public String getQuestion(){
        return question;
    }

    public void printQuestion(){
        String printedQuestion;
        int i = question.indexOf("_");
        printedQuestion = question.substring(0,i) + question.substring(i+1);
        System.out.println(printedQuestion);
        System.out.println(getOptions() );


    }

    /*
     * @return 4-line String containing 3 random andwers and one random
     * answer formatted as the options in a quiz
     * 
     * 
     */
    public boolean hasWon(int choice){
       return choice == random;
    }

    private String getOptions(){
        String[] randomAnswers = Database.getRandomAnswers(super.getWordString());
        //the three answers that are not true
        String optionString = "";
        //will be returned
        random = (int)(Math.random() * 4) + 1;
        //the number of the answer
        int counter = 0;
        //which of the untrue answers to put, selected from random answers
        //loop happens 4 times, one of those times will trigger random == i if statement
        //other 3 times will get one of the three random answers   
    
        for(int i = 1; i <=4; i++){
            //loop 4 times, not used to index anything
            optionString += "" + i + ".)";
            if(random == i){
                optionString += super.getWordString();
                //add true answer
            }else{
                optionString += randomAnswers[counter];
                //add untrue answer, then next time an untrue must be added add a 
                // different one
                counter++;
            }
            optionString += "\n";
            //next line of optionString
        }

        return optionString;
    }


    public String getFullAnswer(){
        String fullAnswer;
        int i = question.indexOf("_");
        fullAnswer = question.substring(0,i) + super.getWordString() + question.substring(i+1);
        return fullAnswer;
    }

}
