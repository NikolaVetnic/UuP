/**
 * Stampa sve cele brojeve izmedju 1 i 10000 koji su jednaki zbiru kub-
 * ova svojih cifara.
 */

class TeorijskeVezbe04_04 {
  public static void main(String[] args) {
    System.out.println("Brojevi jednaki zbiru kubova svojih cifara: ");
    glavnaPetlja: for (int n = 1; n <= 10000; n++) {
      int pom = n;
      int zbir = 0;
      while (pom != 0) {
        int cifra = pom % 10;
        zbir += Math.pow(cifra, 3);
        
        if (zbir > n) {
          continue glavnaPetlja;
        }
        
        pom /= 10;
      }
      if (zbir == n) {
        System.out.println(n);
      }
    }
  }
}
