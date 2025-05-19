public class Word {
    protected String wordString;
    private int category;
    public Word(String wordString,int category){
        this.wordString = wordString.toLowerCase();
        this.category = category;
    }
    
    
   
    public String getWordString(){
        return wordString;
    }
    public int getCategory(){
        return category;
    }


     /*
     * called to check if guesssed word is same as wordString
     * @param guess what the guess is
     * @return .equals for param with wordString
     * 
     */
    

    public boolean isFinished(String guess){
        return guess.equals(wordString) ;
    }
    

}
