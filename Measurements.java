public class Measurements {
  
  //Instansvariabler.....................................................................
  private double[] values;
  private int changed;
  
  //Konstruktorer........................................................................
  public Measurements(int max) {
    values = new double[max];
    changed = 0;
  }
  
  public Measurements(double[] inValues) {
    values = new double[inValues.length];
    changed = inValues.length;
    for(int i = 0; i < changed; i++) {
      values[i] = inValues[i];
    }    
  }
  
  //Metoder..............................................................................
  
  //toString returnerar en textrepresentation av de inmatade varderna i arrayen values.
  public String toString() {
    String printvalues = "<";
    for (int i = 0; i < changed; i++) {
      if (i == (changed-1)) {
        printvalues += values[i] + ">";
      }
      else {
      printvalues += values[i] + ", ";
      }
    }
    return printvalues;    
  }
  
  public void set(double in, int index){
    values[index] = in;
  }
  
  //add lagger till varden p� elementen i arraen samt okar vardet p� changed, vilken agerar raknare.
  public void add(double value) {
    if (changed < values.length) {
      values[changed] = value;
      changed++;
    }
    else {
      double[] temporary = new double[2*values.length];
      for (int i = 0; i < values.length; i++) {
        temporary[i] = values[i];        
      }
      values = temporary;  
      values[changed] = value;
      changed++;    
    }
    
  }
  
  //stored returnerar antalet lagrade varden
  public int stored() {
    return changed;
  }
  
  //get
  public double get(int index){
    return values[index];
  }
  
  //mean beraknar medelvardet av de lagrade varderna
  public double mean() {
    double tot = 0;
    for (int i = 0; i < changed; i++){
      tot += values[i];
    }
    return tot/changed;
  }
  
  //min returnerar det minsta av de lagrade varderna
  public double min() {
    double count = Double.POSITIVE_INFINITY;
    for (int i = 0; i < changed; i++) {
      if (values[i] < count) {
        count = values[i];
      }      
    }
    return count;
  }
  
  //max returnerar det storsta av de lagrade varderna
  public double max() {
    double count = 0;
    for (int i = 0; i < changed; i++) {
      if (values[i] > count) {        
        count = values[i];
      }      
    }
    return count;
  }
  
  //stdDev returnerar standardavvikelsen for de lagrade varderna
  public double stdDev() {
    double numerator = 0;
    double sub = mean();
    for (int i = 0; i < changed; i++) {
      double xi = values[i];
      numerator += Math.pow((xi - sub), 2);
    }
    return Math.sqrt(numerator/changed);
  }
  
  //get returnerar en array med de lagrade varderna
  public double[] get() {
    double[] saved = new double[changed];
    for (int i = 0; i < changed; i++) {
      saved[i] = values[i];
    }
    return saved;
  }
  
  //smooth skapar ett Measurements med utjamnade varden.
  public Measurements smooth() {    
    double[] smoothTemp = new double[changed];
    for (int i = 0; i < changed; i++) {
      if (i == 0 || i == changed-1) {
        smoothTemp[i] = values[i];
      }
      else {
        smoothTemp[i] = (((values[i - 1]) + values[i] + (values[i + 1])) / 3);
      }
    }
    Measurements smooth = new Measurements(smoothTemp);
    return smooth;
  }
  
  /*public static void main(String[] args) {
   Measurements m = new Measurements(5);
    m.add(0);
    m.add(-2);
    m.add(2);
    System.out.println("toString: " + m.toString());
    System.out.println("stored  : " + m.stored());
    System.out.println("mean    : " + m.mean());
    System.out.println("stdDev  : " + m.stdDev());
    System.out.println("arrayGet: " + java.util.Arrays.toString(m.get()));
    double[] a = {2, 1, 6, 5, 4, 9, 2};
    m = new Measurements(a);
    System.out.println("new m   : " + m.toString());
    System.out.println("smooth  : " + m.smooth().toString());
  }*/
}