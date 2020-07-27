class Izraz3 {
  public static void main(String[] args) {
    int n = 0, s = 0, p = 1;
    n = Svetovid.in.readInt("Unesite broj clanova niza: ");
    
    for (int i = 1; i < (n + 1); i++) {
      p = p * i;
      s = s + p;
    }
    
    Svetovid.out.println("Suma je: " + s);
  }
}