class Pitanje27_04 {
  
  static double f(double a, int n) {
    if (a == 0.0 && n == 0)
      return Double.NaN;
    else {
      if (a == 0.0) return 0.00;
      else if (a == 1.0 || n == 0) return 1.00;
      else {
        if (n < 0) {
          a = 1.0 / a;
          n = Math.abs(n);
        }
        double s = 1.0;
        double x = 1.0 / a;
        double aSq = a * a;
        
        for (int i = 1; i <= n; i++) {
          x *= aSq;
          s *= x;
        }
        return s;
      }
    }
  }
  
  public static void main(String[] args) {
    for (int i = 1; i <= 5; i++) 
      System.out.print(f(2.0, i) + "\t");
    System.out.println();
  }
}