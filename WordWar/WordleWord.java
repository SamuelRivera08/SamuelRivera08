public class WordleWord extends WordGame{
    
    String lettersGuessed;
    String lettersContained;
    public WordleWord(String wordString){
        super(wordString, 1);
        lettersGuessed = "";
        lettersContained = "";
    }

    public String wordle(String str){
        super.addGuess();
        String newString = "";
        String wordString = super.getWordString();
        for(int i = 0; i< wordString.length();i++){
            if(wordString.indexOf(str.substring(i,i+1)) >=0 ){
                
                if(lettersContained.indexOf(str.substring(i, i+1)) < 0){
                    lettersContained += str.substring(i, i+1)+ " ";
                }


                if(wordString.indexOf(str.substring(i,i+1)) == i){
                    newString += wordString.substring(i,i+1);
                }else{
                    newString += "*";
                }
            }else{
                super.addLetter(str.substring(i, i+1));
                newString += "_";
            }
        }
        super.setDashString(newString);
         return "Your guess was " + str + ". Heres what that got you: " + super.getDashString();
    }
    
    
    public String powerUpWordle(String str){
        String newString = "";
        int distFromLetter = 0;
        String wordString = super.getWordString();
        for(int i = 0; i< wordString.length();i++){
            if(wordString.indexOf(str.substring(i,i+1)) >=0 ){
                if(wordString.indexOf(str.substring(i,i+1)) == i){
                    newString += wordString.substring(i,i+1);
                }else{
                    distFromLetter = wordString.indexOf(str.substring(i,i+1)) - i;
                    newString += distFromLetter;
                }
            }else{
                newString += "-";
            }
        }
        return "Your guess was " + str + ". Heres what that got you: " + newString;
    }

    
    public String getLettersContained(){
        return lettersContained;
    }





}