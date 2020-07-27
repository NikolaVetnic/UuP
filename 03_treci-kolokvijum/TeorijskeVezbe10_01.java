class TeorijskeVezbe10_01 {
  
  static final int nMin = 0, nMax = 40;
  
  // (a) rekurzivno, definicija
  static int fRec1(int n) {
    if (n == 0)
      return 1;
    else if (n == 1)
      return 3;
    else if (n == 2)
      return 2;
    else if (n % 2 == 1)
      return fRec1(n - 1) - 2 * fRec1(n - 2);
    else
      return fRec1(n - 2) + 3 * fRec1(n - 3);
  }
  
  // (b) rekurzivno, preko akumulirajuceg parametra
  static int ff(int f2, int f1, int f0, int i, int n) {
    if (i > n)
      return f2;
    else if (i % 2 == 1)
      return ff(f2 - 2 * f1, f2, f1, i + 1, n);
    else
      return ff(f1 + 3 * f0, f2, f1, i + 1, n);
  }
  
  static int fRec2(int n) {
    if (n == 0)
      return 1;
    else if (n == 1)
      return 3;
    else if (n == 2)
      return 2;
    else
      return ff(2, 3, 1, 3, n);
  }
  
  // (c) iterativno, prostorno neefikasno
  static int fItr1(int n) {
    int[] f = new int[nMax + 1];
    f[0] = 1; f[1] = 3; f[2] = 2;
    
    for (int i = 3; i <= n; i++) {
      if (i % 2 == 1)
        f[i] = f[i-1] - 2 * f[i-2];
      else
        f[i] = f[i-2] + 3 * f[i-3];
    }
    return f[n];
  }
  
  // (d) iterativno, efikasno
  static int fItr2(int n) {
    int fn = 0, f2 = 2, f1 = 3, f0 = 1;
    
    if (n == 0)
      fn = f0;
    else if (n == 1)
      fn = f1;
    else if (n == 2)
      fn = f2;
    else {
      for (int i = 3; i <= n; i++) {
        if (i % 2 == 1)
          fn = f2 - 2 * f1;
        else
          fn = f1 + 3 * f0;
        f0 = f1;
        f1 = f2;
        f2 = fn;
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
