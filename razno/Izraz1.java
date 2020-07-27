class Izraz1 {
  public static void main(String[] args) {
    int n, sum = 0;
    
    do {
      n = Svetovid.in.readInt("Unesite broj clanova niza: ");
      if (n <= 0) {
        Svetovid.out.println("Greska. Ponovite unos.");
      }
    } while (n <= 0);
    
    for (int i = 0; i < (n + 1); i++) {
      sum = sum + i;
    }
    
    Svetovid.out.println("Suma clanova niza je: " + sum + ".");
  }
}