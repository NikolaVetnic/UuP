/**
 * Napisati program koji za unete cele brojeve n i r, 0 <= n <= 35, gde
 * je 5 <= r <= 20, izračunati vrednost celobrojnog niza f_n rekurzivno
 * preko definicije i rekurzivno pomoću akumulirajućih parametara vode-
 * ći računa o efikasnosti. 
 * 
 * f_n = 2*f_n-r+1 - f_n-r+2 - g_n-r+1 ,n >= r, g_n-r  pozitivno
 * f_n = f_n-1 - g_n-2 + 3*g_n-r+1, n >= r,g_n-r strogo negativno
 * f_n = n-5, n<r
 * 
 * g_n = 3*g_n-r+1 - 2*f_n-2, n >= r,n parno
 * g_n = -f_n-r+1 + g_n-r+2, n >= r,n neparno
 * g_n = (3-n)^3, n<r
 * 
 * Primer:
 * 1) za n = 7 i r = 5 -> f_n = -3, 
 * 2) za n = 25, r = 10 -> f_n = -444, 
 * 3) za n = 17, r = 6 -> f_nn = -100. 
 */

class Dodatni14 {
  
  static final int nMin = 0, nMax = 35;
  static final int rMin = 5, rMax = 20;
  
  // (a)
  static int fRec1(int n, int r) {
    if (n < r)
      return n - 5;
    else if (gRec1(n-r, r) >= 0)
      return 2 * fRec1(n-r+1, r) - fRec1(n-r+2, r) - gRec1(n-r+1, r);
    else
      return fRec1(n-1, r) - gRec1(n-2, r) + 3* gRec1(n-r+1, r);
  }
  
  static int gRec1(int n, int r) {
    if (n < r)
      return (int)Math.pow(3-n, 3);
    else if (n % 2 == 0)
      return 3 * gRec1(n-r+1, r) - 2 * fRec1(n-2, r);
    else
      return -fRec1(n-r+1, r) + gRec1(n-r+2, r);
  }
  
  // (b)
  static int fg(int[] f, int[] g, int i, int n, int r) {
    if (i > n)
      return f[r];
    else {
      if (g[0] >= 0)
        f[r] = 2 * f[1] - f[2] - g[1];
      else
        f[r] = f[r-1] - g[r-2] + 3 * g[1];
      
      if (i % 2 == 0)
        g[r] = 3 * g[1] - 2 * f[r-2];
      else
        g[r] = -f[1] + g[2];
      
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
      f[i] = i - 5;
      g[i] = (int)Math.pow(3-i, 3);
    }
    
    if (n < r)
      return f[n];
    else
      return fg(f, g, r, n, r);
  }
  
  static int fItr1(int n, int r) {
    int[] f = new int[n + 1];
    int[] g = new int[n + 1];
    
    for (int i = 0; i < r; i++) {
      f[i] = i - 5;
      g[i] = (int)Math.pow(3-i, 3);
    }
    
    for (int i = r; i <= n; i++) {
      if (g[i-r] >= 0)
        f[i] = 2 * f[i-r+1] - f[i-r+2] - g[i-r+1];
      else
        f[i] = f[i-1] - g[i-2] + 3 * g[i-r+1];
      
      if (i % 2 == 0)
        g[i] = 3 * g[i-r+1] - 2 * f[i-2];
      else
        g[i] = -f[i-r+1] + g[i-r+2];
    }
    return f[n];
  }
  
  // (d)
  static int fItr2(int n, int r) {
    int[] f = new int[r + 1];
    int[] g = new int[r + 1];
    
    for (int i = 0; i < r; i++) {
      f[i] = i - 5;
      g[i] = (int)Math.pow(3-i, 3);
    }
    
    if (n < r)
      return f[n];
    else {
      for (int i = r; i <= n; i++) {
        if (g[0] >= 0)
          f[r] = 2 * f[1] - f[2] - g[1];
        else
          f[r] = f[r-1] - g[r-2] + 3 * g[1];
        
        if (i % 2 == 0)
          g[r] = 3 * g[1] - 2 * f[r-2];
        else
          g[r] = -f[1] + g[2];
        
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
