class TeorijskeVezbe03_02 {
  public static void main(String[] args) {
    double a, b, bPow = 1.0;
    int n = 0;
    
    do {
      a = Svetovid.in.readDouble("Unesite broj a: ");
      if (a <= 1) {
        System.out.println("Greska. Ponovite unos.");
      }
    } while (a <= 1);
    
    do {
      b = Svetovid.in.readDouble("Unesite broj b: ");
      if (b <= 1) {
        System.out.println("Greska. Ponovite unos.");
      }
    } while (b <= 1);
    
    do {
      n++;
      bPow *= b;
    } while (a > bPow);
    
    System.out.println("Stepen je: " + (n - 1));
  }
}
