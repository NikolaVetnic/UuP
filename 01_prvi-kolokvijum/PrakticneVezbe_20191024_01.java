/**
 * Program koji odredjuje delitelje.
 */

class PrakticneVezbe_20191024_01 {
  public static void main(String[] args) {
    int n, del;
    
    do {
      n = Svetovid.in.readInt("Unesite prirodni broj: ");
      if (n <= 0) { System.out.println("Greska. Ponoviti unos."); }
    } while (n <= 0);
    
    for (int i = 2; i <= n / 2; i++) {
      if (n % i == 0) { System.out.println("Broj " + i + " je delitelj broja " + n + "."); }
    }
  }
}
