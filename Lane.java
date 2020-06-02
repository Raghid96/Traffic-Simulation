/**
 * Represents a lane as an array of Vehicles. A position in the lane may be occupied
 * by a vehicle or free (contains null). Vehicles enter the lane at the high index of 
 * the array end exit from index 0.
 */
import java.util.ArrayList;
public class Lane {

  private Vehicle[] theLane;
  private int laneLength;

    /**
     * Constructs a lane with a specified capacity.
     * @param length The length (capacity) of the lane in number of vehicles
     */
    public Lane(int length) {
      theLane = new Vehicle[length];
      laneLength = length;
    }
    

    /**
     * A string representation of the lane.
     * @return The string representation
     */
    public String toString() {
      ArrayList<Character> repres = new ArrayList<Character>();
      for(int i = 0 ; i < laneLength; i++){
        if(theLane[i] == null){
          repres.add('.');
        }
        else{
          repres.add(theLane[i].getDestination());
        }
      }
      return "<" + repres + ">";
    }

    /**
     * Advances all except the first vehicle one position provided the 
     * target position is free. The process starts in the low end (i. e.
     * at index 1).
     * <p>
     * <b>Example:</b> The follwing two lines shows the result of
     * a call to <code>toString</code> before and after a call to 
     * <code>step()</code>
     * <pre>
     *    &lt;XX  X   X X X  XX&gt;
     *    &lt;XX X   X X X  XX &gt;
     * </pre>
     * 
     */
    public void step() {
      for(int i = 0; i < laneLength - 1 ; i++){
        if(theLane[i] == null && theLane[i+1] != null){
          theLane[i] = theLane[i + 1];
          theLane[i+1] = null;
        }
      }
    }

    /**
     * Removes the first vehicle (index 0) from the lane and makes it empty.
     * @return The removed vehicle or <code>null</code> if the position was empty
     */
    public Vehicle removeFirst() {
       Vehicle first = theLane[0];
       theLane[0] = null;
       return first;
    }

    /**
     * Access method for the vehicle in the first position.
     * @return A reference to the vehicle in the first position
     */
    public Vehicle getFirst() {
      return theLane[0];
    }

    /**
     * Checks if the last position is free.
     * @return <code>true</code> if the last position is free (null) 
     * else <code>false<code>.
     */
    public boolean lastFree() {
      if(theLane[theLane.length-1] == null){//Om den sista positionen är tom
        return true;
      }
      else{
        return false;
      }
    }

    /**
     * Put a vehicle in the last position.
     * @param v Vehicle to be put in the last position
     * @throws RuntimeException if the last position is not free
     */
    public void putLast(Vehicle v) {
      if(this.lastFree() == false){
        throw new RuntimeException("The last position is taken");
      }
      else{
        theLane[theLane.length -1] =v;
      }
    }
  
  
    /**
     * Counts the number of Vehicles on the lane.
     * @return The number of Vehicles 
     */
    public int numberOfVehicles() {
     int count = 0;
      for(int i = 0; i < laneLength; i++) {
        if (theLane[i] != null){
        count ++;  
        }
      }
      return count;
    }
    
}
