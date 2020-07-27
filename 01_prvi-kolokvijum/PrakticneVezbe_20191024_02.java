/**
 * Utvrdjuje da li je ucitan broj prost.
 */

class PrakticneVezbe_20191024_02 {
  public static void main(String[] args) {
    int n, brojDelilaca = 0;
    
    do {
      n = Svetovid.in.readInt("Unesite prirodan broj: ");
      if (n <= 0) { System.out.println("Greska. Ponovite unos."); }
    } while (n <= 0);
    
    for (int i = 2; i <= n / 2; i++) {
      if (n % i == 0) { brojDelilaca++; }
    }
    
    if (brojDelilaca > 0) { System.out.println("Broj ima " + brojDelilaca + " delilaca i nije prost."); }
    else { System.out.println("Broj je prost."); }
  }
}
