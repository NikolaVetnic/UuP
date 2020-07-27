class TeorijskeVezbe03_03 {
  public static void main(String[] args) {
    int n;
    
    do {
      n = Svetovid.in.readInt("Unesite prirodan broj: ");
      if (n <= 0) {
        System.out.println("Greska. Ponovite unos.");
      }
    } while (n <= 0);
    
    do {
      if (((n % 10) % 2) == 0) { System.out.println("Cifra " + (n % 10) + " je parna."); }
      else { System.out.println("Cifra " + (n % 10) + " je neparna."); }
      n = n / 10;
    } while (n > 0);
  }
}
