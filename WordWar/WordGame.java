public class WordGame extends Word{
    private String dashString; //printed to show mystery word and number of characters
    private int guesses;//how many guesses a player has made
    private String lettersGuessed;//the letters a player has incorrectly guessed



    public WordGame(String wordString, int category){
        super(wordString, category);
        guesses = 0;
        dashString = "";
        lettersGuessed = "";

        //constructs dashstring to be made up of dashes for letters and spaces for spaces
        //prerequisite wordString does not contain punctuation or numbers
        for(int i = 0; i < wordString.length(); i++){
            if(wordString.substring(i, i+1).equals(" ")){
                dashString += " ";
            }else{
                dashString += "_";
            }
        }
    }
    
    /*
     * adds to the string of letters a player has already guessed
     * @param the letter a character guessed
     * 
     */
    
    public void addLetter(String character){
        if(lettersGuessed.indexOf(character) < 0){
            lettersGuessed += character + " ";
        }
        }
    
    public String getDashString(){
        return dashString;
    }

    public void setDashString(String str){
        dashString = str;
    }

    public void addGuess(){
        guesses++;
    }
    public int getGuesses(){
        return guesses;
    }


     /*
     * @override
     * adds if player has used up their guesses for conditions to end a game, whereas otehr 
     * word games may only require one guess 
     * @return if player is out of guesses or 
     * 
     */
    
    public boolean isFinished(){
        boolean outOfGuesses = guesses >=Database.MAX_GUESSES;

        return outOfGuesses || super.isFinished(dashString);
    }

    public String getLettersGuessed(){
        return lettersGuessed;
    }

    public boolean hasWon(){
        return super.isFinished(dashString);
    }
    
}
