class Kolokvijum3_02 {
  
  static final int nMin = 0, nMax = 35;
  static final int rMin = 5, rMax = 20;
  
  // (a)
  static int fRec1(int n, int r) {
    if (n < r)
      return -n;
    else if (gRec1(n-1, r) % 3 == 0)
      return fRec1(n-r, r) - 2 * fRec1(n-r+3, r) + 3 * gRec1(n-r+1, r);
    else
      return gRec1(n-r, r) - 2 * gRec1(n-r+3, r) + 3 * fRec1(n-r+1, r);
  }
  
  static int gRec1(int n, int r) {
    if (n < r)
      return 5 * n;
    else if (n % 2 == 0)
      return gRec1(n-r+2, r) - 2 * n;
    else
      return fRec1(n-3, r) + 3 * n;
  }
  
  // (b)
  static int fg(int[] f, int[] g, int i, int n, int r) {
    if (i > n)
      return f[r];
    else {
      if (g[r-1] % 3 == 0)
        f[r] = f[0] - 2 * f[3] + 3 * g[1];
      else
        f[r] = g[0] - 2 * g[3] + 3 * f[1];
      
      if (i % 2 == 0)
        g[r] = g[2] - 2 * i;
      else
        g[r] = f[r-3] + 3 * i;
      
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
      f[i] = -i;
      g[i] = 5 * i;
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
      f[i] = -i;
      g[i] = 5 * i;
    }
    
    for (int i = r; i <= n; i++) {
      if (g[i-1] % 3 == 0)
        f[i] = f[i-r] - 2 * f[i-r+3] + 3 * g[i-r+1];
      else
        f[i] = g[i-r] - 2 * g[i-r+3] + 3 * f[i-r+1];
      
      if (i % 2 == 0)
        g[i] = g[i-r+2] - 2 * i;
      else
        g[i] = f[i-3] + 3 * i;
    }
    return f[n];
  }
  
  // (d)
  static int fItr2(int n, int r) {
    int[] f = new int[r + 1];
    int[] g = new int[r + 1];
    
    for (int i = 0; i < r; i++) {
      f[i] = -i;
      g[i] = 5 * i;
    }
    
    if (n < r)
      return f[n];
    else {
      for (int i = r; i <= n; i++) {
        if (g[r-1] % 3 == 0)
          f[r] = f[0] - 2 * f[3] + 3 * g[1];
        else
          f[r] = g[0] - 2 * g[3] + 3 * f[1];
        
        if (i % 2 == 0)
          g[r] = g[2] - 2 * i;
        else
          g[r] = f[r-3] + 3 * i;
        
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
