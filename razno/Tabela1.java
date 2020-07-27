class Tabela1 {
  public static void main(String[] args) {
    Svetovid.out.print("Unesite x_min, x_max i dx: ");
    double xmin = Svetovid.in.readDouble(),
           xmax = Svetovid.in.readDouble(),
           dx = Svetovid.in.readDouble();
    
    System.out.println("\nx\t\ty");
    System.out.println("=====\t\t=====");
    for (double x = xmin; x <= xmax; x += dx) {
      System.out.print(String.format("%.2f", x));
      System.out.println("\t\t" + String.format("%.2f", ((x * x - 2 * x - 2) / (x * x + 1))));
    }
  }
}