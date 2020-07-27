class TeorijskeVezbe10_02 {
  
  static final int nMin = 1;
  static final int nMax = 30;
  
  // (a) rekurzivno, definicija
  static int fRec1(int n) {
    if (n == 1)
      return 2;
    else
      return fRec1(n - 1) + gRec1(n - 1);
  }
  
  static int gRec1(int n) {
    if (n == 1)
      return 3;
    else
      return 2 * gRec1(n - 1) - fRec1(n - 1);
  }
  
  // (b) rekurzivno, preko akumulirajuceg parametra
  static int fg(int f1, int g1, int i, int n) {
    if (i > n)
      return f1;
    else
      return fg(f1 + g1, 2 * g1 - f1, i + 1, n);
  }
  
  static int fRec2(int n) {
    if (n == 1)
      return 2;
    else
      return fg(2, 3, 2, n);
  }
  
  // (c) iterativno, prostorno neefikasno
  static int fItr1(int n) {
    int[] f = new int[nMax + 1];
    int[] g = new int[nMax + 1];
    f[1] = 2; g[1] = 3;
    
    for (int i = 2; i <= n; i++) {
      f[i] = f[i-1] + g[i-1];
      g[i] = 2 * g[i-1] - f[i-1];
    }
    return f[n];
  }
  
  // (d) iterativno, efikasno
  static int fItr2(int n) {
    int fn = 0, f1 = 2, gn = 0, g1 = 3;
    
    if (n == 1)
      fn = f1;
    else {
      for (int i = 2; i <= n; i++) {
        fn = f1 + g1;
        gn = 2 * gn - f1;
        f1 = fn;
        g1 = gn;
      }
    }
    return fn;
      
  }
  
  public static void main(String[] args) {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite n, n ∈ [1, 30]: ");
    } while (n < nMin || n > nMax);
    
    System.out.println("fRec1(" + n + ") = " + fRec1(n));
    System.out.println("fRec2(" + n + ") = " + fRec2(n));
    System.out.println("fItr1(" + n + ") = " + fItr1(n));
    System.out.println("fItr2(" + n + ") = " + fItr2(n));
  }
}
