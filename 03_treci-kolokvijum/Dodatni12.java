/* Napisati program koji za unete cele brojeve n i r, 0 <= n <= 32, gde
 * je 4 <= r <= 16, izračunati vrednost celobrojnog niza f_n rekurzivno
 * preko definicije i rekurzivno pomoću akumulirajućih parametara vode-
 * ći računa o efikasnosti. 
 *  
 * f_n = 3*f_n-3 + 2*g_n-2 - 8*f_n-r, n >= r, n je deljivo sa 5 
 * f_n = 8*g_n-3+2*f_n-2 - 3*g_n-r+2, n >= r, n nije deljivo sa 5 
 * f_n = 4*n, n < r 
 *  
 * g_n = 6*f_n-r + 5*f_n-r+1 + 4*f_n-r+2, 
 *             n >= r, poslednja cifra od n je prosta 
 * g_n = g_n-r+3 - g_n-r - g_n-r+1,
 *             n >= r, poslednja cifra od n nije prosta 
 * g_n = 2+f_n, n<r 
 *  
 * Primer: 
 * 1) za n = 9 i r = 4 -> f_n = -758,
 * 2) za n = 10 i r = 6 -> f_n = 294,
 * 3) za n = 21 i r = 16 -> f_n = 2026. 
 */

class Dodatni12 {
  
  static final int nMin = 0, nMax = 32;
  static final int rMin = 4, rMax = 16;
  
  // (a)
  static int fRec1(int n, int r) {
    if (n < r)
      return 4 * n;
    else if (n % 5 == 0)
      return 3 * fRec1(n-3, r) + 2 * gRec1(n-2, r) - 8 * fRec1(n-r, r);
    else
      return 8 * gRec1(n-3, r) + 2 * fRec1(n-2, r) - 3 * gRec1(n-r+2, r);
  }
  
  static int gRec1(int n, int r) {
    if (n < r)
      return 2 + fRec1(n, r);
    else if (n % 10 == 2 || n % 10 == 3 || n % 10 == 5 || n % 10 == 7)
      return 6 * fRec1(n-r, r) + 5 * fRec1(n-r+1, r) + 4 * fRec1(n-r+2, r);
    else
      return gRec1(n-r+3, r) - gRec1(n-r, r) - gRec1(n-r+1, r);
  }
  
  // (b)
  static int fg(int[] f, int[] g, int i, int n, int r) {
    if (i > n)
      return f[r];
    else {
      if (i % 5 == 0)
        f[r] = 3 * f[r-3] + 2 * g[r-2] - 8 * f[0];
      else
        f[r] = 8 * g[r-3] + 2 * f[r-2] - 3 * g[2];
      
      if (i % 10 == 2 || i % 10 == 3 || i % 10 == 5 || i % 10 == 7)
        g[r] = 6 * f[0] + 5 * f[1] + 4 * f[2];
      else
        g[r] = g[3] - g[0] - g[1];
      
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
      f[i] = 4 * i;
      g[i] = 2 + f[i];
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
      f[i] = 4 * i;
      g[i] = 2 + f[i];
    }
    
    for (int i = r; i <= n; i++) {
      if (i % 5 == 0)
        f[i] = 3 * f[i-3] + 2 * g[i-2] - 8 * f[i-r];
      else
        f[i] = 8 * g[i-3] + 2 * f[i-2] - 3 * g[i-r+2];
      
      if (i % 10 == 2 || i % 10 == 3 || i % 10 == 5 || i % 10 == 7)
        g[i] = 6 * f[i-r] + 5 * f[i-r+1] + 4 * f[i-r+2];
      else
        g[i] = g[i-r+3] - g[i-r] - g[i-r+1];
    }
    return f[n];
  }
  
  // (d)
  static int fItr2(int n, int r) {
    int[] f = new int[n + 1];
    int[] g = new int[n + 1];
    
    for (int i = 0; i < r; i++) {
      f[i] = 4 * i;
      g[i] = 2 + f[i];
    }
    
    if (n < r)
      return f[n];
    else {
      for (int i = r; i <= n; i++) {
        if (i % 5 == 0)
          f[r] = 3 * f[r-3] + 2 * g[r-2] - 8 * f[0];
        else
          f[r] = 8 * g[r-3] + 2 * f[r-2] - 3 * g[2];
        
        if (i % 10 == 2 || i % 10 == 3 || i % 10 == 5 || i % 10 == 7)
          g[r] = 6 * f[0] + 5 * f[1] + 4 * f[2];
        else
          g[r] = g[3] - g[0] - g[1];
        
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
