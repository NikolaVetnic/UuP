/**
 * Ucitava n < 100 i n celih brojeva, racuna prosek.
 */

class Prosek {
  public static void main(String[] args) {
    int n;
    
    do {
      n = Svetovid.in.readInt("Unesite duzinu niza: ");
      if (n <= 0) System.out.println("Greska. Ponovite unos.");
    } while (n <= 0);
    
    int[] arr = new int[n];
    int sum = 0;
    
    for (int i = 0; i < n; i++) {
      arr[i] = Svetovid.in.readInt("a[" + i + "] = ");
      sum += arr[i];
    }
    
    System.out.println("Prosek niza: " + ((double)sum / n));


  }
}
