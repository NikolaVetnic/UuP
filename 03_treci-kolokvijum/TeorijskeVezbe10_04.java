class TeorijskeVezbe10_04 {
  
  static final int nMin = 0, nMax = 50;
  static final int rMin = 2, rMax = 20;
  
  // (a) rekurzivno, definicija
  static int fRec1(int n, int r) {
    if (n < r)
      return 1;
    else
      return fRec1(n-1, r) - gRec1(n-2, r) + fRec1(n-r, r) - gRec1(n-r, r);
  }
  
  static int gRec1(int n, int r) {
    if (n < r)
      return 2;
    else
      return gRec1(n-1, r) + fRec1(n-2, r) - fRec1(n-r, r) - gRec1(n-r, r);
  }
  
  // (b) rekurzivno, akumulirajuci
  static int fg(int[] f, int[] g, int i, int n, int r) {
    if (i > n)
      return f[r];
    else {
      f[r] = f[r-1] - g[r-2] + f[0] - g[0];
      g[r] = g[r-1] + f[r-2] - f[0] - g[0];
      
      for (int j = 0; j < r; j++) {
        f[j] = f[j+1];
        g[j] = g[j+1];
      }
      return fg(f, g, i + 1, n, r);
    }
  }
  
  static int fRec2(int n, int r) {
    int[] f = new int[r + 1];
    int[] g = new int[r + 1];
    
    if (n < r)
      return 1;
    else {
      for (int i = 0; i < r; i++) {
        f[i] = 1; g[i] = 2;
      }
      return fg(f, g, r, n, r);
    }
  }
  
  // (c) iterativno, neefikasno
  static int fItr1(int n, int r) {
    int[] f = new int[n + 1];
    int[] g = new int[n + 1];
    
    for (int i = 0; i <= n; i++) {
      if (i < r) {
        f[i] = 1; 
        g[i] = 2;
      }
      else {
        f[i] = f[i-1] - g[i-2] + f[i-r] - g[i-r];
        g[i] = g[i-1] + f[i-2] - f[i-r] - g[i-r];
      }
    }
    return f[n];
  }
  
  // (d) iterativno, efikasno
  static int fItr2(int n, int r) {
    int[] f = new int[r + 1];
    int[] g = new int[r + 1];
    
    for (int i = 0; i < r; i++) {
      f[i] = 1; g[i] = 2;
    }
    
    if (n < r)
      return f[n];
    else {
      for (int i = r; i <= n; i++) {
        f[r] = f[r-1] - g[r-2] + f[0] - g[0];
        g[r] = g[r-1] + f[r-2] - f[0] - g[0];
        
        for (int j = 0; j < r; j++) {
          f[j] = f[j+1];
          g[j] = g[j+1];
        }
      }
    }
    return f[r];
  }
  
  public static void main(String[] args) {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite n, n ∈ [" + nMin + ", " + nMax + "]: ");
    } while (n < nMin || n > nMax);
    
    int r;
    do {
      r = Svetovid.in.readInt("Unesite r, r ∈ [" + rMin + ", " + rMax + "]: ");
    } while (r < rMin || r > rMax);
    
    System.out.println("fRec1(" + n + ", " + r + ") = " + fRec1(n, r));
    System.out.println("fRec2(" + n + ", " + r + ") = " + fRec2(n, r));
    System.out.println("fItr1(" + n + ", " + r + ") = " + fItr1(n, r));
    System.out.println("fItr2(" + n + ", " + r + ") = " + fItr2(n, r));
  }
}
