/**
 * Ucitava cele a i b, sekvencu iz [a, b] (unos se prekida kada se iza-
 * dje iz int) i ispisuje koliko je uneto i minimum.
 */

class CeliBrojevi {
  public static void main(String[] args) {
    int a = Svetovid.in.readInt("Unesite donju granicu intervala: ");
    
    int b;
    
    do {
      b = Svetovid.in.readInt("Unesite gornju granicu niza: ");
      if (b <= a) System.out.println("Gornja granica je manja od donje. Ponovite.");
    } while (b <= a);
    
    int i = a;
    int temp, sum = 0, count = 0, min;
    
    temp = Svetovid.in.readInt("Unesite vrednost: ");
    sum += temp;
    count++;
    min = temp;
    
    do {
      temp = Svetovid.in.readInt("Unesite vrednost: ");
      sum += temp;
      count++;
      if (temp < min) min = temp;
    } while (temp >= a && temp <= b);
    
    System.out.println("Uneto je " + (count - 1) + " brojeva od kojih je minimum " + min + ".");
  }
}
