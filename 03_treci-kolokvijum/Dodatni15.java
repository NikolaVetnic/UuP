/* Napisati program koji za unete cele brojeve n i r, 0 <= n <= 30, i 5
 * <= r <= 15, izračunati vrednost celobrojnog niza f_n rekurzivno pre-
 * ko definicije i iterativno vodeći računa o efikasnosti. 
 *  
 * f_n = 4*f_n-r+1 + g_n-r+2 + 2*f_n-r, 
 * 						n >= r, poslednja cifra od n je 1, 2, 3 
 * f_n = |-f_(n-r)+ g_(n-r+1)|, 
 * 						n >= r, poslednja cifra od n nije 1, 2, 3 
 * f_n = r + 10 - n, n<r 
 *  
 * g_n = g_n-r+3 + f_n-4, n >= r,n deljivo sa 5 
 * g_n = 5*f_n-r+1 - 3*(g_n-2 - f_n-r), n >= r, n nije deljivo sa 5 
 * g_n = r - 10 + n, n<r 
 *  
 * Primer:
 * 1) za n = 7 i r = 5 -> f_n = 15, 
 * 2) za n = 25, r = 10 -> f_n = 521, 
 * 3) za n = 17, r = 5 -> f_n = 904 
 */

class Dodatni15 {
  
  static final int nMin = 0, nMax = 30;
  static final int rMin = 5, rMax = 15;
  
  // (a)
  static int fRec1(int n, int r) {
    if (n < r)
      return r + 10 - n;
    else if (n % 10 == 1 || n % 10 == 2 || n % 10 == 3)
      return 4 * fRec1(n-r+1, r) + gRec1(n-r+2, r) + 2 * fRec1(n-r, r);
    else
      return Math.abs(-fRec1(n-r, r) + gRec1(n-r+1, r));
  }
  
  static int gRec1(int n, int r) {
    if (n < r)
      return r - 10 + n;
    else if (n % 5 == 0)
      return gRec1(n-r+3, r) + fRec1(n-4, r);
    else
      return 5 * fRec1(n-r+1, r) - 3 * (gRec1(n-2, r) - fRec1(n-r, r));
  }
  
  // (b)
  static int fg(int[] f, int[] g, int i, int n, int r) {
    if (i > n)
      return f[r];
    else {
      if (i % 10 == 1 || i % 10 == 2 || i % 10 == 3)
        f[r] = 4 * f[1] + g[2] + 2 * f[0];
      else
        f[r] = Math.abs(-f[0] + g[1]);
      
      if (i % 5 == 0)
        g[r] = g[3] + f[r-4];
      else
        g[r] = 5 * f[1] - 3 * g[r-2] - f[0];
      
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
      f[i] = r + 10 - i;
      g[i] = r - 10 + i;
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
      f[i] = r + 10 - i;
      g[i] = r - 10 + i;
    }
    
    for (int i = r; i <= n; i++) {
      if (i % 10 == 1 || i % 10 == 2 || i % 10 == 3)
        f[i] = 4 * f[i-r+1] + g[i-r+2] + 2 * f[i-r];
      else
        f[i] = Math.abs(-f[i-r] + g[i-r+1]);
      
      if (i % 5 == 0)
        g[i] = g[i-r+3] + f[i-4];
      else
        g[i] = 5 * f[i-r+1] - 3 * g[i-2] - f[i-r];
    }
    return f[n];
  }
  
  static int fItr2(int n, int r) {
    int[] f = new int[n + 1];
    int[] g = new int[n + 1];
    
    for (int i = 0; i < r; i++) {
      f[i] = r + 10 - i;
      g[i] = r - 10 + i;
    }
    
    if (n < r)
      return f[n];
    else {
      for (int i = r; i <= n; i++) {
        if (i % 10 == 1 || i % 10 == 2 || i % 10 == 3)
          f[r] = 4 * f[1] + g[2] + 2 * f[0];
        else
          f[r] = Math.abs(-f[0] + g[1]);
        
        if (i % 5 == 0)
          g[r] = g[3] + f[r-4];
        else
          g[r] = 5 * f[1] - 3 * g[r-2] - f[0];
        
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
