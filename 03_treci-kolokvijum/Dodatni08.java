/* Napisati program koji za dati ceo broj n, 0 <= n <= 40, ispisuje vr-
 * ednost elementa rekurentnog niza realnih brojeva f_n. Niz je defini-
 * san na sledeci nacin:
 * 
 * f_n = 2 + f_n-1 / g_n-2, n >= 2
 * g_n = 1 + g_n-1 / f_n-2, n >= 2
 * 
 * f_1 = 1, f_0 = 2
 * g_1 = 2, g_0 = 1
 * 
 * Element f_n izracunati: 
 *  (a) rekurzivno preko definicije, 
 *  (b) rekurzivno pomocu akumulirajuceg parametra, 
 *  (c) iterativno. 
 * U slucajevima (b) i (c) voditi racuna o efikasnosti resenja. 
 */

class Dodatni08 {
  
  static final double nMin = 0.0, nMax = 40.0;
  
  // (a)
  static double fRec1(int n) {
    if (n == 0)
      return 2.0;
    if (n == 1)
      return 1.0;
    else
      return 2.0 + fRec1(n-1) / gRec1(n-2);
  }
  
  static double gRec1(int n) {
    if (n < 2)
      return n + 1.0;
    else
      return 1 + gRec1(n-1) / fRec1(n-2);
  }
  
  // (b)
  static double fg(double f1, double f0, double g1, double g0, int i, int n) {
    if (i > n)
      return f1;
    else
      return fg(2.0 + f1 / g0, f1, 1.0 + g1 / f0, g1, i+1, n);
  }
  
  static double fRec2(int n) {
    if (n == 0)
      return 2.0;
    else if (n == 1)
      return 1.0;
    else
      return fg(1, 2, 2, 1, 2, n);
  }
  
  // (c)
  static double fItr1(int n) {
    double[] f = new double[n + 1];
    double[] g = new double[n + 1];
    
    f[0] = 2.0; f[1] = 1.0;
    g[0] = 1.0; g[1] = 2.0;
    
    for (int i = 2; i <= n; i++) {
      f[i] = 2 + f[i-1] / g[i-2];
      g[i] = 1 + g[i-1] / f[i-2];
    }
    return f[n];
  }
  
  // (d)
  static double fItr2(int n) {
    double f0 = 2.0, f1 = 1.0, g0 = 1.0, g1 = 2.0, fn = 0.0, gn = 0.0;
    
    if (n == 0)
      fn = f0;
    else if (n == 1)
      fn = f1;
    else {
      for (int i = 2; i <= n; i++) {
        fn = 2.0 + f1 / g0;
        gn = 1.0 + g1 / f0;
        
        f0 = f1; f1 = fn; g0 = g1; g1 = gn;
      }
    }
    return fn;
  }
  
  public static void main(String[] args) {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite n, n ∈ [" + nMin + ", " + nMax + "]: ");
    } while (n < nMin || n > nMax);
    
    System.out.println("fRec1(" + n + ") = " + fRec1(n));
    System.out.println("fRec2(" + n + ") = " + fRec2(n));
    System.out.println("fItr1(" + n + ") = " + fItr1(n));
    System.out.println("fItr2(" + n + ") = " + fItr2(n));
  }
}
