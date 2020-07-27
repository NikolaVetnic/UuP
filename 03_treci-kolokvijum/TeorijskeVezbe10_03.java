class TeorijskeVezbe10_03 {
  
  static final int nMin = 0, nMax = 40;
  
  // (a) rekurzivno, definicija
  static int fRec1(int n) {
    if (n <= 1)
      return n - 1;
    else if (n % 10 >= 5)
      return fRec1(n - 1) + gRec1(n - 2);
    else
      return fRec1(n - 2) - gRec1(n - 1);
  }
  
  static int gRec1(int n) {
    if (n <= 1)
      return n;
    else if (n % 2 == 1)
      return gRec1(n - 1) - 2 * fRec1(n - 2);
    else
      return gRec1(n - 2) + 2 * fRec1(n - 1);
  }
  
  // (b) rekurzivno, preko akumulirajuceg parametra
  static int fg(int f1, int g1, int f0, int g0, int i, int n) {
    int fn = 0, gn = 0;
    
    if (i > n)
      return f1;
    else {
      if (i % 10 >= 5)
        fn = f1 + g0;
      else
        fn = f0 - g1;
      if (i % 2 == 1)
        gn = g1 - 2 * f0;
      else
        gn = g0 + 2 * f1;
    }
    return fg(fn, gn, f1, g1, i + 1, n);
  }
  
  static int fRec2(int n) {
    if (n <= 1)
      return n - 1;
    else
      return fg(0, 1, -1, 0, 2, n);
  }
  
  // (c) iterativno, prostorno neefikasno
  static int fItr1(int n) {
    int[] f = new int[nMax + 1];
    int[] g = new int[nMax + 1];
    f[0] = -1; f[1] = 0; g[0] = 0; g[1] = 1;
    
    for (int i = 2; i <= n; i++) {
      if (i % 10 >= 5)
        f[i] = f[i-1] + g[i-2];
      else
        f[i] = f[i-2] - g[i-1];
      if (i % 2 == 1)
        g[i] = g[i-1] - 2 * f[i-2];
      else
        g[i] = g[i-2] + 2 * f[i-1];
    }
    return f[n];
  }
  
  // (d) iterativno, efikasno
  static int fItr2(int n) {
    int fn = 0, gn = 0, f1 = 0, g1 = 1, f0 = -1, g0 = 0;
    
    if (n == 0)
      fn = f0;
    else if (n == 1)
      fn = f1;
    else {
      for (int i = 2; i <= n; i++) {
        if (i % 10 >= 5)
          fn = f1 + g0;
        else
          fn = f0 - g1;
        if (i % 2 == 1)
          gn = g1 - 2 * f0;
        else
          gn = g0 + 2 * f1;
        f0 = f1;
        g0 = g1;
        f1 = fn;
        g1 = gn;
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
