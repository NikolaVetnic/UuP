/**
 * Ucitava prirodan broj n i stampa jedan par brojeva 1 <= i, j <= n za
 * koje vazi da je i * j jednako zbiru kvadrata svih cifara brojeva i &
 * j.
 */

class TeorijskeVezbe04_06 {
  public static void main(String[] args) {
    System.out.print("Unesite prirodan broj n: ");
    int n = Svetovid.in.readInt();
    int i = 0, j = 0;
    
    glavnaPetlja: for (i = 1; i <= n; i++) {
      unutrasnjaPetlja: for (j = 1; j <= n; j++) {
        int proizvod = i * j;
        int zbir = 0;
        int pom = i;
        while (pom != 0) {
          int cifra = pom % 10;
          zbir += cifra * cifra;
          if (zbir > proizvod)
            continue unutrasnjaPetlja;
          pom /= 10;
        }
        pom = j;
        while (pom != 0) {
          int cifra = pom % 10;
          zbir += cifra * cifra;
          if (zbir > proizvod)
            continue unutrasnjaPetlja;
          pom /= 10;
        }
        if (zbir == proizvod)
          break glavnaPetlja;
      }
    }
    System.out.println("i = " + i + "; j = " + j + "; ");
  }
}
