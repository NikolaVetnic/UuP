class Prost {
  public static void main(String[] args) {
    int n;
    do {
      n = Svetovid.in.readInt("Prirodan broj: ");
      if (n <= 0) System.out.println("Greska. Ponovite");
    } while (n <= 0);
    
    boolean check = true;
    
    for (int i = 2; i <= n / 2; i++) {
      if (n % i == 0) check = false;
    }
    
    if (check) System.out.println("Broj je prost.");
  }
}