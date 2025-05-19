
import java.awt.Color;
import java.util.ArrayList;

/**
 * Write a description of class Lion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tiger extends Critter
{
    private boolean hasEaten; //if tiger has eaten
    ArrayList<Direction> clockwise = new ArrayList<>(); // list of directions that gets progresed through
    //when the lion is moving, randomly chosen from for tiger
    int cycle;// indexes cloakcwise
    int counter; //how many times tiger has moven in one direction
    int hunger; //how many times tiger will eat
    public Tiger( int hunger){
        this.hunger = hunger;
        cycle = (int)(Math.random() * 4);
        counter = 0;
         hasEaten= false;
         clockwise.add(Direction.SOUTH);
         clockwise.add(Direction.WEST);
         clockwise.add(Direction.NORTH);
         clockwise.add(Direction.EAST);
    }
     
    
    /*
     * @override eat method from critter
     * returns true hunger times it gets called
     * 
     * 
     */
    
    
    public boolean eat(){
        if(hunger > 0){
            hunger--;
            return true;
        }else{
            return false;
        }
    }
    
    /*
     * @override
     * returns scratch only if can eat, otherwise returns pounce
     */
    
    public Attack fight(String opponent){
        if(hunger > 0){
            return Attack.SCRATCH;   
        }else{
            return Attack.POUNCE;
        }
    }
    
    /*
     * @override 
     * returns the color yellow
     */
    public Color getColor(){
        return Color.YELLOW;
    }
    /*
     * @overide moves in a direction 3 times before choosing other random direction
     */
    public Direction getMove(){
        counter ++;
        if(counter>=3){
            cycle = (int)(Math.random() * 4);
            counter = 0;
        }
        
        return clockwise.get(cycle);
    }
    
    /*
     * @override returns how many times tiger can eat
     */
    public String toString(){
        String str = hunger +"";
        return str.substring(0,1);
    }
}