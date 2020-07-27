class Tabela3 {
  public static void main(String[] args) {
    int n = Svetovid.in.readInt("Unesite prirodan broj: ");
    
    Svetovid.out.print("Unesite x_min, x_max i dx: ");
    double xmin = Svetovid.in.readDouble(),
           xmax = Svetovid.in.readDouble(),
           dx = Svetovid.in.readDouble();
    
    System.out.println("\nx\t\ty");
    System.out.println("=====\t\t=====");
    
    for (double x = xmin; x <= xmax; x += dx) {
      double sum = 0.0;
      
      for (int i = 1; i < n + 1; i++) {
        sum = sum + Math.pow(-1, i - 1) * Math.pow(x, i);
      }
      System.out.println(String.format("%.4f", x) + "\t\t" + String.format("%.4f", sum));
    }
  }
}