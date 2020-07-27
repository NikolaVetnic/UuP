class Izraz2 {
  public static void main(String[] args) {
    int p = 1;
    
    int n = Svetovid.in.readInt("Unesite prirodan broj: ");
    
    for (int i = 1; i < (n + 1); i++) { p = p * i; }
    
    Svetovid.out.println("Faktorijel broja " + n + " je: " + p);
  }
}