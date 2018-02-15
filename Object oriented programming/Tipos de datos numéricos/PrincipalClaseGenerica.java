public class PrincipalClaseGenerica {

  public static void main(String args[]) {
 
    ClaseGenerica<Integer> intObj = new ClaseGenerica<Integer>(88);
    intObj.classType();
 
    ClaseGenerica<String> strObj = new ClaseGenerica<String>("Test");
    strObj.classType();

    ClaseGenerica<Double> dbObj = new ClaseGenerica<Double>(10.1);
    dbObj.classType();
 
  }
}