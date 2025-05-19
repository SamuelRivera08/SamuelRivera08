public class HangmanWord extends WordGame {
    private String dashString;
    private int guesses;



    public HangmanWord(String wordString){
        super(wordString, 3);
        guesses = 0;
        dashString = super.getDashString();
        String str = super.getWordString();
    }

    public String hangman(String character){
        character = character.toLowerCase();
        String newDashString = dashString;
        String str = super.getWordString();
        if(str.indexOf(character) >=0){
            for(int i = 0; i < str.length(); i++){
                if(character.equals(str.substring(i,i+1))){
                        newDashString = newDashString.substring(0,i) + character + dashString.substring(i+1);
                }
            }
            dashString = newDashString;
            return dashString;
        }else{
            super.addGuess();
            super.addLetter(character);
            return dashString;
            
        }
    }
    public String getDashString(){
        return dashString;
    }



    public boolean isFinished(){
        boolean guyHung = guesses >=6;

        return guyHung || super.isFinished(dashString);
    }

    public void makeHangman(int guesses){
        if(guesses == 0){

        }else if(guesses == 1){
            System.out.println(" 0 ");
        }else if(guesses == 2){
            makeHangman(guesses - 1);
            System.out.print("/");
        }else if(guesses == 3){
            makeHangman(guesses - 1);
            System.out.print("|");
    
        }else if(guesses == 4){
            makeHangman(guesses - 1);
            System.out.println("'\'' ");
        }else if(guesses == 5){
            makeHangman(guesses - 1);
            System.out.print("/ ");
        }else if(guesses == 6){
            makeHangman(guesses - 1);
            System.out.println("'\'");
        }
    }
    

    public boolean hasWon(){
        return dashString.equals(super.getWordString());
    }

}
