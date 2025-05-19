import java.awt.Color;
import java.util.ArrayList;

/**
 * Write a description of class Fartbuckle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Samuel_Fartbuckle extends Critter
{
    // instance variables - replace the example below with your own
    private ArrayList<Direction> clockwise = new ArrayList<>(); //list of 4 directions
    public static ArrayList<Attack> quadAttacks = new ArrayList<>(); //list of 4 attacks, accessed when fighting,
    //fartbuckle will attack differently based on quadrant
    public static int quadWin;// most recent quadrant that fartbuckle has won a fight
    private String fightString;
    public static String[] winString; //three creatures fartbuckle has recently won against
    //int cycle;
    //int counter;
    int startX;
    int startY;
    //where fartbuckle instance spawns
    
    
    public Samuel_Fartbuckle(){
        for(int i = 0; i< 4; i++){
            int random = (int)(Math.random()*3 + 1);
            if(random == 1){
                quadAttacks.add(Attack.SCRATCH);
            }else if(random == 2){
                quadAttacks.add(Attack.POUNCE);
            }else{
                quadAttacks.add(Attack.ROAR);
            }
        }
        winString = new String[3];
        //cycle = 0;
        //counter = 0;

         clockwise.add(Direction.SOUTH);
         clockwise.add(Direction.WEST);
         clockwise.add(Direction.NORTH);
         clockwise.add(Direction.EAST);
        startX = getX();
        startY = getY();
    }
     
    /*
     * @param quadrant the quadrant a creature was in when method is called, which quadrant needs a 
     * new attack
     * Changes attack in a certain quadrant to different one, called when creature loses fight
     * 
     */
    public void setNewAttack(int quadrant){
        Attack attack = null;
        Attack oldAttack = quadAttacks.get(quadrant);
            do{
                int random =(int)(Math.random() * 3 + 1);
                if(random == 1){
                    attack = Attack.SCRATCH;
                }else if(random == 2){
                    attack = Attack.POUNCE;
                }else{
                    attack = Attack.ROAR;
                } 
            } while(attack == oldAttack); //chooses random attack other than the one that
            //didn't work
            
        quadAttacks.set(quadrant, attack);
    }
    
    
    
    //@override eats if safe and nothing right next to creature to kill it while its asleep
    public boolean eat(){
       return safe();
    }
    
    
    /*
     * makes sure creature has no immediate enemies
     * @return that there are no enemies
     */
    public boolean safe(){
        boolean noAnimal = true;
        for(Direction direction:clockwise){
            if(!(getNeighbor(direction).equals(" ") || getNeighbor(direction).equals(".") || getNeighbor(direction).equals("F"))){
                noAnimal = false;
            }
        }
        return noAnimal;
    }
       
    
    
    /*
     * overloaded void that checks one direction
     * @param direction the direction to check
     * @return if direction has no enemies
     */
    
    
    public boolean safe(Direction direction){
        boolean noAnimal = true;
            if(!(getNeighbor(direction).equals(" ") || getNeighbor(direction).equals(".") || getNeighbor(direction).equals("F"))){
                noAnimal = false;
            }
        return noAnimal;
    }
    
    
    /*
     * divides arena into 4 sections 
     * @return the quarter of the arena fartbuckle instance is in
     * 
     * 
     */
    
    public int getQuadrant(){
        boolean left = super.getX() <= super.getWidth()/2;
        boolean up = super.getY() <= super.getHeight()/2;
        if(left && up){
            return 1;
        }else if((!left) && up){
            return 2;
        }else if(left && (!up)){
            return 3;
        }else{
            return 4;
        }
    }
    
    
    /*
     * @ovveride attacks depending on the quadrant fartbuckle is in, attack database shared across
     * fartbuckles
     * @param opponent the toString of the creature fartbuckle battles
     * @return the attack fartbuckle chooses
     */
    public Attack fight(String opponent){
        fightString = opponent;
        return quadAttacks.get(getQuadrant() - 1);
    }
    /*
     * @ ovveride returns the color orange
     */
    public Color getColor(){
        return Color.ORANGE;
    }
    
    
    /*
     * @param neighbor the creature being checked for if fartbuckle gota recent win against the.
     * @return if fartbuckle won against them recently
     */
    private boolean likelyWin(String neighbor){
        for(String str:winString){
            if( str != null && str.equals(neighbor)){
                return true;
            }
        }
        return false;
    }
    
    
    /*
     * @override moves to enemies if has won recently, otherwise moves in a random direction
     * @return the direction fartbuckle is moving
     * 
     */
    public Direction getMove(){
        for(Direction direction: clockwise){
            boolean enemy = !safe(direction);
            if(getQuadrant() == quadWin ){//|| likelyWin(getNeighbor(direction))){
                return direction;
            }
        }
        
        int random = (int)(Math.random()*4);
        return clockwise.get(random);
    }
    
    
    /*
     * @override shows up as F on the arena
     */
    public String toString(){
        return "F";
    }
    
    /*
     * changes attack in a certain quadrant if it isn't working out
     */
    public void lose() {
        setNewAttack(getQuadrant());
    }
    
    /*
     * Records recent wins in an array, removing the oldest win
     */
    public void win(){
        quadWin = getQuadrant();
        winString[2] = winString[1];
        winString[1] = winString[0];
        winString[0] = fightString;
    }
}
