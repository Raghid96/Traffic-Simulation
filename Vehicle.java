/*import java.lang.Object.clone;
import java.lang.Object.equals;
import java.lang.Object.finalize;
import java.lang.Object.getClass;
import java.lang.Object.hashCode;
import java.lang.Object.notify;
import java.lang.Object.notifyAll;
import java.lang.Object.wait;*/

public class Vehicle {
//Instansvariabler........................................................................
 private char destination;
 private int createtime;
  
//Konstruktorer...........................................................................
  public Vehicle(char destination) {
    this.destination = destination;
    createtime = Simulation.getTime();
  }
  
//Metoder.................................................................................

  public int getTime() {
    return createtime;
  }
  
  
  public char getDestination() {
    return destination;
  }
  
  public String toString() {
    return "" + destination;
  }

}