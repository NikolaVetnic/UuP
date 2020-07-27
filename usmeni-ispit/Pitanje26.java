class Pitanje26_06 {
  
  static double f(int n) {
    return 1.0 / n;
  }
  
  static double recVr(int n) {
    double value = 0.0;
    
    for (int i = 1; i <= n; i++)
      value += f(i);
    
    return value;
  }
  
  static int g(int n) {
    return n * n;
  }
  
  static int sumKv(int n) {
    int value = 0;
    
    for (int i = 1; i <= n; i++)
      value += g(i);
    
    return value;
  }
  
  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      System.out.print(String.format("%.2f", recVr(i)) + "\t");
    }
    System.out.println();
    
    for (int i = 1; i <= 10; i++) {
      System.out.print(sumKv(i) + "\t");
    }
    System.out.println();
  }
}