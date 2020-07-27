/**
 * Ucitava string s i cele brojeve p i n i u string rez kopira n znako-
 * va iz stringa s pocevsi od znaka na poziciji p. Ukoliko to nije mog-
 * uce, ispisati poruku.
 */

class Ucitava {
  public static void main(String[] args) {
    System.out.print("Unesite string: ");
    String s = Svetovid.in.readLine();
    System.out.print("Unesite redni broj prvog znaka: ");
    int p = Svetovid.in.readInt();
    System.out.print("Unesite broj znakova za kopiranje: ");
    int n = Svetovid.in.readInt();
    String rez = "";
    if (p + n <= s.length()) {
      for (int i = p; i < p + n; i++) {
        rez = rez + s.charAt(i);
      }
      System.out.println("Kopirani string izgleda ovako: " + rez);
    }
    else {
      System.out.println("Nije moguce dobiti trazeni string.");
    }
  }
}
