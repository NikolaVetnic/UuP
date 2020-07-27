/**
 * Napisati program koji za unete cele brojeve n i r, 0 <= n <= 25, gde
 * je 5 <= r <= 20, izračunati vrednost celobrojnog niza f_n rekurzivno
 * preko definicije i iterativno vodeći računa o efikasnosti. 
 *  
 * f_n = (-1)^n*(f_n-2 + g_n-1), n >= r, poslednja cifra n veća od 5 
 * f_n = -f_n-r + g_n-r+1, n >= r, poslednja cifra n strogo manja od 5 
 * f_n = r + 10 - 2*n, n<r 
 *  
 * g_n = 2*(g_n-r+3 - f_n-4), n >= r, n deljivo sa 3 
 * g_n = 4f_n-r + 6*(g_n-2 - f_n-r), n >= r, n nije deljivo sa 3 
 * g_n = r - 10 + 2*n, n<r 
 *  
 * Primer: 
 * 1) za n = 7 i r = 5 -> f_n = 28,
 * 2) za n = 25, r = 10 -> f_n = -570,
 * 3) za n = 17, r = 5 -> f_n = 29057.
 */

class Dodatni13 {
  
  static final int nMin = 0, nMax = 25;
  static final int rMin = 5, rMax = 20;
  
  // (a)
  static int fRec1(int n, int r) {
    if (n < r)
      return r + 10 - 2 * n;
    else if (n % 10 >= 5)
      return (int)Math.pow(-1, n) * (fRec1(n-2, r) + gRec1(n-1, r));
    else
      return -fRec1(n-r, r) + gRec1(n-r+1, r);
  }
  
  static int gRec1(int n, int r) {
    if (n < r)
      return r - 10 + 2 * n;
    else if (n % 3 == 0)
      return 2 * (gRec1(n-r+3, r) - fRec1(n-4, r));
    else
      return 4 * fRec1(n-r, r) + 6 * (gRec1(n-2, r) - fRec1(n-r, r));
  }
  
  // (b)
  static int fg(int[] f, int[] g, int i, int n, int r) {
    if (i > n)
      return f[r];
    else {
      if (i % 10 >= 5)
        f[r] = (int)Math.pow(-1, i) * (f[r-2] + g[r-1]);
      else
        f[r] = -f[0] + g[1];
      
      if (i % 3 == 0)
        g[r] = 2 * (g[3] - f[r-4]);
      else
        g[r] = 4 * f[0] + 6 * (g[r-2] - f[0]);
      
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
      f[i] = r + 10 - 2 * i;
      g[i] = r - 10 + 2 * i;
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
      f[i] = r + 10 - 2 * i;
      g[i] = r - 10 + 2 * i;
    }
    
    for (int i = r; i <= n; i++) {
      if (i % 10 >= 5)
        f[i] = (int)Math.pow(-1, i) * (f[i-2] + g[i-1]);
      else
        f[i] = -f[i-r] + g[i-r+1];
      
      if (i % 3 == 0)
        g[i] = 2 * (g[i-r+3] - f[i-4]);
      else
        g[i] = 4 * f[i-r] + 6 * (g[i-2] - f[i-r]);
    }
    return f[n];
  }
  
  // (d)
  static int fItr2(int n, int r) {
    int[] f = new int[r + 1];
    int[] g = new int[r + 1];
    
    for (int i = 0; i < r; i++) {
      f[i] = r + 10 - 2 * i;
      g[i] = r - 10 + 2 * i;
    }
    
    if (n < r)
      return f[n];
    else {
      for (int i = r; i <= n; i++) {
        if (i % 10 >= 5)
          f[r] = (int)Math.pow(-1, i) * (f[r-2] + g[r-1]);
        else
          f[r] = -f[0] + g[1];
        
        if (i % 3 == 0)
          g[r] = 2 * (g[3] - f[r-4]);
        else
          g[r] = 4 * f[0] + 6 * (g[r-2] - f[0]);
        
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
