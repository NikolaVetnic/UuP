class Statist {
  public static void main(String[] args) {
    int n = 1;
    
    while (n > 0) {
      n = Svetovid.in.readInt("Unesite broj clanova niza: ");
      
      double sum = 0.0;
      double d = 0.0;
      
      if (n > 0) {
        for (int i = 0; i < n; i++) {
          double a = Svetovid.in.readDouble("Unesite " + i + ". clan: ");
          sum = sum + a;
          d = d + a * a;
        }      
        System.out.println("Aritmeticka sredina niza je: " + (sum / n));
        System.out.println("Standardna devijacija niza je: " + Math.sqrt((d / n) - Math.pow(sum / n, 2)));
      }
    }
  }
}