import java.awt.Color;
/**
 * Write a description of class Bear here.
 *
 * @author Samuel
 * @version (a version number or a date)
 */
public class Bear extends Critter
{
    boolean grizzly; //if color is different
    boolean wasWest; //if last move was west
    public Bear(boolean grizzly){
         this.grizzly =grizzly;       
         wasWest = false;
    }
     
    
    /*
     * @override always eats by always returning true
     */
    public boolean eat(){
        return true;
    }
    /*
     * @override returns scratch attack
     */
    public Attack fight(String opponent){
        return Attack.SCRATCH;
    }
    /*
     * @ override returns brown if grizzly, black otherwise
     */
    public Color getColor(){
        if(grizzly){
            return new Color(190,110,50);
        }else{
            return Color.BLACK;
        }
    }
    /*
     * @override moves in a pattern of left, then up.
     */
    public Direction getMove(){
        if(wasWest){
            wasWest = false;
            return Direction.NORTH; 
            
        }else{
            wasWest = true;
            return  Direction.WEST; 
            
        }
    }
    /*
     * @ overrode bear shows up as B on board
     */
    public String toString(){
        return "B";
    }
}
