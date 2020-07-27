class Polinom {
  public static void main(String[] args) {
    int n;
    
    do {
      n = Svetovid.in.readInt("Unesite red polinoma: ");
      if (n <= 0) { System.out.println("Greska. Ponovite unos."); }
    } while (n <= 0);
    
    double[] koefArray = new double[n + 1];
    
    for (int i = 0; i <= n; i++) {
      koefArray[i] = Svetovid.in.readDouble("Unesite koeficijent " + i + " polinoma: ");
    }
    
    System.out.print("\n");
    
    double xMin = Svetovid.in.readDouble("Unesite x(min): ");
    double xMax = Svetovid.in.readDouble("Unesite x(max): ");
    double dx = Svetovid.in.readDouble("Unesite dx: ");
    double x;
    
    System.out.print("\n");
    
    System.out.print("P(x) =");    
    for (int i = n; i >= 0; i--) {
      System.out.print("+ (" + koefArray[i] + ") * x^" + i + "\t");
    }
    
    System.out.print("\n\n");
    
    for (x = xMin; x <= xMax; x += dx) {
      double p = 0.0;
      for (int i = 0; i <= n; i++) {
        p += koefArray[i] * Math.pow(x, i);
      }
      System.out.print("x = " + x + "; \tP(x) = " + p + ";\n");
    }
    
  }
}