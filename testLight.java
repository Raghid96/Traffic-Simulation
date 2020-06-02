import junit.framework.TestCase;

public class testLight{
  public static void main(String[] args){ 
    Light s = new Light(5,2);
    assertTrue(s.isGreen());
    s.step();
    
  
  }
  

}