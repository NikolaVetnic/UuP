class PrakticneVezbe_20191219 {
  
  static final int nMin = 0, nMax = 30;
  static final int rMin = 5, rMax = 20;
  
  
  // (a)
  static int fRec1(int n, int r) {
    if (n < r)
      return 2;
    else if (n % 2 == 1) 
      return fRec1(n-2, r) - gRec1(n-1, r) + fRec1(n-r+1, r) - gRec1(n-r, r);
    else
      return -fRec1(n-1, r) + gRec1(n-1, r) - gRec1(n-2, r) - fRec1(n-r, r);
  }
  
  static int gRec1(int n, int r) {
    if (n < r)
      return -1;
    else
      return 2 * gRec1(n-1, r) - 2 * fRec1(n-r, r) + gRec1(n-r+1, r);
  }
  
  // (b)
  static int fg(int[] f, int[] g, int i, int n, int r) {
    if (i > n)
      return f[r];
    else {
      if (i % 2 == 1)
        f[r] = f[r-2] - g[r-1] + f[1] - g[0];
      else
        f[r] = - f[r-1] + g[r-1] - g[r-2] - f[0] + g[0];
      
      g[r] = 2 * g[r-1] - 2 * f[0] + g[0];
      
      for (int j = 0; j < r; j++) {
        f[j] = f[j+1];
        g[j] = g[j+1];
      }
      
      return fg(f, g, i+1, n, r);
    }
  }
  
  static int fRec2(int n, int r) {
    int[] f = new int[r + 1];
    int[] g = new int[r + 1];
    
    if (n < r)
      return 2;
    else {
      for (int j = 0; j < r; j++) {
        f[j] = 2; g[j] = -1;
      }
      return fg(f, g, r, n, r);
    }
  }
  
  // (d)
  static int fItr2(int n, int r) {
    int[] f = new int[r + 1];
    int[] g = new int[r + 1];
    
    for (int i = 0; i < r; i++) {
      f[i] = 2; g[i] = -1;
    }
    
    if (n < r)
      return f[r];
    else {
      for (int i = r; i <= n; i++) {
        if (i % 2 == 1) {
          f[r] = f[r-2] - g[r-1] + f[1] - g[0];
        }
        else {
          f[r] = -f[r-1] + g[r-1] - g[r-2] - f[0] + g[0];
        }
        
        g[r] = 2 * g[r-1] - 2 * f[0] + g[1];
        
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
    // System.out.println("fItr1(" + n + ", " + r + ") = " + fItr1(n, r));
    System.out.println("fItr2(" + n + ", " + r + ") = " + fItr2(n, r));
  }
}
