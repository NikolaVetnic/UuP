class Izraz4 {
  public static void main(String[] args) {
    int n = 0;
    double numerator = 1.0, denominator = 0.0, sum = 0.0;
    n = Svetovid.in.readInt("Unesite broj clanova niza: ");
    
    for (int i = 1; i < (n + 1); i++) {
      numerator = numerator * i;
      denominator = denominator + (1.0 / (i + 1));
      sum = sum + (numerator / denominator);
    }
    
    Svetovid.out.println("Suma je: " + String.format("%.2f", sum));
  }
}