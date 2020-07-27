class TeorijskeVezbe03_05 {
  public static void main(String[] args) {
    int n;
    
    do {
      n = Svetovid.in.readInt("Unesite prirodan broj: ");
      if (n <= 0) { System.out.println("Greska. Ponovite unos."); }
    } while (n <= 0);
    
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.print(j * i + "\t");
      }
      System.out.println();
    }
  }
}
