class Kolokvijum3_03 {
  
  static final int nMin = 0, nMax = 32;
  static final int rMin = 4, rMax = 16;
  
  // (a)
  static int fRec1(int n, int r) {
    if (n < r)
      return n - r;
    else if ((n-r) % 2 == 0)
      return Math.abs(fRec1(n-3, r) - gRec1(n-2, r)) + 2 * fRec1(n-r, r);
    else
      return gRec1(n-1, r) + Math.abs(fRec1(n-r+2, r)  - 3 * gRec1(n-r+1, r));
  }
  
  static int gRec1(int n, int r) {
    if (n < r)
      return r + 7;
    else if ((n+r) % 7 == 0)
      return 4 * (fRec1(n-r, r) - gRec1(n-r+1, r) + gRec1(n-2, r));
    else
      return 3 * (gRec1(n-3, r) - gRec1(n-r, r) + fRec1(n-1, r));
  }
  
  // (b)
  static int fg(int[] f, int[] g, int i, int n, int r) {
    if (i > n)
      return f[r];
    else {
      if ((i-r) % 2 == 0)
        f[r] = Math.abs(f[r-3] - g[r-2]) + 2 * f[0];
      else
        f[r] = g[r-1] + Math.abs(f[2] - 3 * g[1]);
      
      if ((i+r) % 7 == 0)
        g[r] = 4 * (f[0] - g[1] + g[r-2]);
      else
        g[r] = 3 * (g[r-3] - g[0] + f[r-1]);
      
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
    
    for (int i = 0; i < r; i++) {
      f[i] = i - r;
      g[i] = r + 7;
    }
    
    if (n < r)
      return f[n];
    else
      return fg(f, g, r, n, r);
  }
  
  // (c)
  static int fItr1(int n, int r) {
    int[] f = new int[n + 1];
    int[] g = new int[n + 1];
    
    for (int i = 0; i < r; i++) {
      f[i] = i - r;
      g[i] = r + 7;
    }
    
    for (int i = r; i <= n; i++) {
      if ((i-r) % 2 == 0)
        f[i] = Math.abs(f[i-3] - g[i-2]) + 2 * f[i-r];
      else
        f[i] = g[i-1] + Math.abs(f[i-r+2] - 3 * g[i-r+1]);
      
      if ((i+r) % 7 == 0)
        g[i] = 4 * (f[i-r+0] - g[i-r+1] + g[i-2]);
      else
        g[i] = 3 * (g[i-3] - g[i-r+0] + f[i-1]);
    }
    return f[n];
  }
  
  // (d)
  static int fItr2(int n, int r) {
    int[] f = new int[r + 1];
    int[] g = new int[r + 1];
    
    for (int i = 0; i < r; i++) {
      f[i] = i - r;
      g[i] = r + 7;
    }
    
    if (n < r)
      return f[n];
    else {
      for (int i = r; i <= n; i++) {
        if ((i-r) % 2 == 0)
          f[r] = Math.abs(f[r-3] - g[r-2]) + 2 * f[0];
        else
          f[r] = g[r-1] + Math.abs(f[2] - 3 * g[1]);
        
        if ((i+r) % 7 == 0)
          g[r] = 4 * (f[0] - g[1] + g[r-2]);
        else
          g[r] = 3 * (g[r-3] - g[0] + f[r-1]);
        
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
