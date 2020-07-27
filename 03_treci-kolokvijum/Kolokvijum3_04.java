class Kolokvijum3_04 {
  
  static final int nMin = 0, nMax = 30;
  static final int rMin = 5, rMax = 15;
  
  // (a)
  static int fRec1(int n, int r) {
    if (n < r)
      return r - n;
    else if (n >= 10)
      return -2 * fRec1(n-1, r) + gRec1(n-1, r) - 4 * gRec1(n-r+1, r) + gRec1(n-r, r);
    else
      return fRec1(n-r+3, r) + gRec1(n-r+2, r) - 5 * fRec1(n-r, r);
  }
  
  static int gRec1(int n, int r) {
    if (n < r) 
      return r + n;
    else if (n % 5 == 0)
      return -gRec1(n-r+1, r) + fRec1(n-2, r);
    else
      return 3 * fRec1(n-r+2, r) - 4 * (gRec1(n-2, r) + fRec1(n-r, r));
  }
  
  // (b)
  static int fg(int[] f, int[] g, int i, int n, int r) {
    if (i > n)
      return f[r];
    else {
      if (i >= 10)
        f[r] = -2 * f[r-1] + g[r-1] - 4 * g[1] + g[0];
      else
        f[r] = f[3] + g[2] - 5 * f[0];
      
      if (i % 5 == 0)
        g[r] = -g[1] + f[r-2];
      else
        g[r] = 3 * f[2] - 4 * (g[r-2] + f[0]);
      
      for (int j = 0; j < r; j++) {
        f[j] = f[j+1];
        g[j] = g[j+1];
      }
    }
    return fg(f, g, i+1, n, r);
  }
  
  static int fRec2(int n, int r) {
    int[] f = new int[r + 1];
    int[] g = new int[r + 1];
    
    for (int i = 0; i < r; i++) {
      f[i] = r - i;
      g[i] = r + i;
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
      f[i] = r - i;
      g[i] = r + i;
    }
    
    for (int i = r; i <= n; i++) {
      if (i >= 10)
        f[i] = -2 * f[i-1] + g[i-1] - 4 * g[i-r+1] + g[i-r];
      else
        f[i] = f[i-r+3] + g[i-r+2] - 5 * f[i-r];
      
      if (i % 5 == 0)
        g[i] = -g[i-r+1] + f[i-2];
      else
        g[i] = 3 * f[i-r+2] - 4 * (g[i-2] + f[i-r]);
    }
    return f[n];
  }
  
  // (d)
  static int fItr2(int n, int r) {
    int[] f = new int[r + 1];
    int[] g = new int[r + 1];
    
    for (int i = 0; i < r; i++) {
      f[i] = r - i;
      g[i] = r + i;
    }
    
    if (n < r)
      return f[n];
    else {
      for (int i = r; i <= n; i++) {
        if (i >= 10)
          f[r] = -2 * f[r-1] + g[r-1] - 4 * g[1] + g[0];
        else
          f[r] = f[3] + g[2] - 5 * f[0];
        
        if (i % 5 == 0)
          g[r] = -g[1] + f[r-2];
        else
          g[r] = 3 * f[2] - 4 * (g[r-2] + f[0]);
        
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
