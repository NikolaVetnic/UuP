/**
 * f_n = 2f_n-1 / g_n-2 + f_n-2 / g_n-3, n >= 3, n parno
 * f_n = g_n-1 / f_n-2 + 2g_n-2 / f_n-3, n >= 3, n neparno
 * 
 * g_n = g_n-1 / f_n-1 + g_n-2 / f_n-2 + g_n-3 / f_n-3, n >= 3
 * 
 * f_2 = 1, f_1 = 3, f_0 = 1
 * g_2 = 2, g_1 = 2, g_0 = 2 
 */

class Dodatni09 {
  
  static final int nMin = 0, nMax = 25;
  
  // (a)
  static double fRec1(int n) {
    if (n == 0)
      return 1.0;
    else if (n == 1)
      return 3.0;
    else if (n == 2)
      return 1.0;
    else if (n % 2 == 0)
      return 2 * fRec1(n-1) / gRec1(n-2) + fRec1(n-2) / gRec1(n-3);
    else
      return gRec1(n-1) / fRec1(n-2) + 2 * gRec1(n-2) / fRec1(n-3);
  }
  
  static double gRec1(int n) {
    if (n <= 2)
      return 2.0;
    else
      return gRec1(n-1) / fRec1(n-1) + gRec1(n-2) / fRec1(n-2) + gRec1(n-3) / fRec1(n-3);
  }
  
  // (b)
  static double fg(double f2, double f1, double f0, double g2, double g1, double g0, int i, int n) {
    if (i > n)
      return f2;
    else {
      double fn = 0;
      double gn = 0;
      
      if (i % 2 == 0)
        fn = 2 * f2 / g1 + f1 / g0;
      else
        fn = g2 / f1 + 2 * g1 / f0;
      
      gn = g2 / f2 + g1 / f1 + g0 / f0;
      
      return fg(fn, f2, f1, gn, g2, g1, i+1, n);
    }
  }
  
  static double fRec2(int n) {
    double f0 = 1.0, f1 = 3.0, f2 = 1.0;
    double g0 = 2.0, g1 = 2.0, g2 = 2.0;
    
    if (n == 0)
      return f0;
    else if (n == 1)
      return f1;
    else if (n == 2)
      return f2;
    else
      return fg(f2, f1, f0, g2, g1, g0, 3, n);
  }
  
  public static void main(String[] args) {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite n, n ∈ [" + nMin + ", " + nMax + "]: ");
    } while (n < nMin || n > nMax);
    
    System.out.println("fRec1(" + n + ") = " + fRec1(n));
    System.out.println("fRec2(" + n + ") = " + fRec2(n));
    //System.out.println("fItr1(" + n + ", " + r + ") = " + fItr1(n, r));
    //System.out.println("fItr2(" + n + ", " + r + ") = " + fItr2(n, r));
  }
}
