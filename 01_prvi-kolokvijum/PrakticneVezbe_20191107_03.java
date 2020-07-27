/**
 * Ucitava sekvencu znakova dok se ne unese '.' i ispisuje koliko medju
 * unetim znakovima ima malih slova, velikih slova, cifara, interpunkc-
 * ijskih . , ; : ? ! i ostalih znakova.
 */

class Znakovi {
  public static void main(String[] args) {
    char c;
    int malaSlova = 0, velikaSlova = 0, cifre = 0, interpunkcijski = 0, ostali = 0;
    
    do {
      c = Svetovid.in.readChar("Unesite znak: ");
      if (c >= 'a' && c <= 'z') {
        malaSlova++;
      }
      else if (c >= 'A' && c <= 'Z') {
        velikaSlova++;
      }
      else if (c >= '0' && c <= '9') {
        cifre++;
      }
      else if (c == ',' || c == ';' || c == ':' || c == '?' || c == '!') {
        interpunkcijski++;
      }
      else {
        ostali++;
      }
    } while (c != '.');
    
    System.out.println("UNOS:");
    System.out.println("malaSlova\t" + malaSlova);
    System.out.println("velikaSlova\t" + velikaSlova);
    System.out.println("cifre\t\t" + cifre);
    System.out.println("interpunkcijski\t" + interpunkcijski);
    System.out.println("ostali\t\t" + ostali);
  }
}
