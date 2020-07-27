class Izraz5 {
  public static void main(String[] args) {
    int n = 0;
    double numerator = 0.0, denominator = 0.0, sum = 0.0;
    n = Svetovid.in.readInt("Unesite broj clanova niza: ");
    
    for (int i = 1; i < (n + 1); i++) {
      numerator = numerator + i;
      denominator = denominator + i * i;
      sum = sum + Math.pow(-1, i + 1) * numerator / denominator;
    }
    
    Svetovid.out.println("Suma je: " + String.format("%.4f", sum));
  }
}