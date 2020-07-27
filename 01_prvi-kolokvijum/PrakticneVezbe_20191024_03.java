/**
 * Da li su cifre proste?
 */

class PrakticneVezbe_20191024_03 {
  public static void main(String[] args) {
    int n;
    
    do {
      n = Svetovid.in.readInt("Unesite prirodan broj: ");
      if (n <= 0) { System.out.println("Greska. Ponovite."); }
    } while (n <= 0);
    
    do {
      if (n % 10 == 2 || n % 10 == 3 || n % 10 == 5 || n % 10 == 7) {
        System.out.println("Cifra " + (n % 10) + " je prosta.");
      }
      else { System.out.println("Cifra " + (n % 10) + " nije prosta."); }
      n = n / 10;
    } while (n > 0);
  }
}
