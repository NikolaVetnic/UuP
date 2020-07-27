class Redosled {
  public static void main(String[] args) {
    double sum1 = 0.0, sum2 = 0.0;
    
    System.out.println("input\t\tascend\t\t\tdescend");
    
    int n = Svetovid.in.readInt();
    for (int i = 1; i <= n; i++) {
      sum1 = sum1 + (1 / Math.pow(i, 2));
    }
    for (int i = n; i >= 1; i--) {
      sum2 = sum2 + (1 / Math.pow(i, 2));
    }
    
    System.out.println(n + "\t\t" + String.format("%.20f", sum1) + "\t" + String.format("%.20f", sum2));
  }
}