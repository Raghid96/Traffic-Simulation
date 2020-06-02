/**
 * Represents a traffic light. 
 */
public class Light {
  private int periodtime;
  private int greentime;
  private int time;
  private boolean green;

  /**
   * Constructs and initializes a light.
   * @param period the total period
   * @param green the number of time steps the signal is green
   */
  public Light(int period, int green) {
    time = 0;
    periodtime = period -1;
    greentime = green;
    this.green = true;
  }
  
  /**
   * Advances the internal clock.
   */
  public void step() {
    if(time == periodtime){
      time = 0;
      green = true;
    }
    else{
      time ++;
    }
    if(time == greentime){
      green = false;
    }
  }
  
  /**
   * Checks if the light is green.
   * @return true if the light is green else false
   */
  public boolean isGreen() {
    return green;
  }
  
  /**
   * Returns a string representation of the signal. 
   * The representation indicates if the signal is green or red. 
   * @return a string representation
   */
  public String toString() {
      if(green == true){
        return "The light is green";
      }
      else{
        return "The light is red";
      }
    }
  
  /**
   * Demonstrates the stepping of a signal.
   */
}
