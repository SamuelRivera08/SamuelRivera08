import java.awt.Color;
import java.util.ArrayList;

/**
 * Write a description of class Lion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lion extends Critter
{
   
    private boolean hasFought; //if last action of lion was fighting and not eating
    ArrayList<Direction> clockwise = new ArrayList<>();//list of 4 directions iterated through for movement
    int cycle;//iterates clockwise
    int counter;//counts number of moves, checked to see if code should iterate cycle
    public Lion(){
        cycle = 0;
        counter = 0;
         hasFought = false;
         clockwise.add(Direction.SOUTH);
         clockwise.add(Direction.WEST);
         clockwise.add(Direction.NORTH);
         clockwise.add(Direction.EAST);
    }
     /*
      * @override Returns true only if has fought without eating
      */
    public boolean eat(){
        if(hasFought){
          hasFought = false;
          return true;
        }else{
            return false;
        }
    }
    
    /*
     * @override Guaruntees win against bears and tigers that are not hungry, loses to hungry tigers
     */
    public Attack fight(String opponent){
        hasFought = true;
        if(opponent.equals("B")){
            return Attack.ROAR;
        }else{
            return Attack.POUNCE;
        }
    }
    /*
     * @ ovveride sets tiger color to red
     */
    public Color getColor(){
        return Color.RED;
    }
    
    /*
     *@override moves in pattern of clockwise square
     */
    public Direction getMove(){
        cycle++;
        counter ++;
        if(counter >= 5){
            cycle++;
            counter = 0;
        }
        if(cycle >= 4){
            cycle = 0;
        }
        return clockwise.get(cycle);
    }
    
    /*
     * @override Appears as L on board
     */
    public String toString(){
        return "L";
    }
}
