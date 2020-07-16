/* Write a program which, for the input values of n and r, 0 <= n <= 35
 * and 5 <= r <= 20, calculates values of the integer array f_n recurs-
 * ively via definition and recursively via accumulating parameter pay-
 * ing attention to efficiency.
 *   
 * f_n = f_n-r+1 + f_n-r+2 - g_n-r, n >= r, g_n-r+1 positive 
 * f_n = f_n-1 - g_n-3 - g_n-r - g_n-r+1, n >= r, g_n-r+1  negative 
 * f_n = n - 3, n < r 
 *  
 * g_n = g_n-r+2 - f_n-2, n >= r, n divisible by 7 
 * g_n = 5*f_n-4 - 2*g_n-r+3, n >= r, n not divisible by 7 
 * g_n = 3-n, n < r 
 *  
 * Example: 
 * 1) for n = 7, 	r = 5 	-> 	f_n =  0
 * 2) for n = 25, 	r = 10 	-> 	f_n = -155
 * 3) for n = 17, 	r = 6 	-> 	f_n =  126 
 */

class Dodatni16 {
  
  static final int nMin = 0, nMax = 35;
  static final int rMin = 5, rMax = 20;
  
  // (a) recursively via definition
  static int fRec1(int n, int r) {
    if (n < r)
      return n - 3;
    else if (gRec1(n-r+1, r) >= 0)
      return fRec1(n-r+1, r) + fRec1(n-r+2, r) - gRec1(n-r, r);
    else
      return fRec1(n-1, r) - gRec1(n-3, r) - gRec1(n-r, r) - gRec1(n-r+1, r);
  }
  
  static int gRec1(int n, int r) {
    if (n < r)
      return 3 - n;
    else if (n % 7 == 0)
      return gRec1(n-r+2, r) - fRec1(n-2, r);
    else
      return 5 * fRec1(n-4, r) - 2 * gRec1(n-r+3, r);
  }
  
  // (b) recursively via accumulating parameter
  static int fg(int[] f, int[] g, int i, int n, int r) {
    if (i > n)
      return f[r];
    else {
      if (g[1] >= 0)
        f[r] = f[1] + f[2] - g[0];
      else
        f[r] = f[r-1] - g[r-3] - g[0] - g[1];
      
      if (i % 7 == 0)
        g[r] = g[2] - f[r-2];
      else
        g[r] = 5 * f[r-4] - 2 * g[3];
      
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
      f[i] = i - 3;
      g[i] = 3 - i;
    }
    
    if (n < r)
      return f[n];
    else
      return fg(f, g, r, n, r);
  }
  
  // (c) iterrative, inefficient
  static int fItr1(int n, int r) {
    int[] f = new int[n + 1];
    int[] g = new int[n + 1];
    
    for (int i = 0; i < r; i++) {
      f[i] = i - 3;
      g[i] = 3 - i;
    }
    
    for (int i = r; i <= n; i++) {
      if (g[i-r+1] >= 0)
        f[i] = f[i-r+1] + f[i-r+2] - g[i-r];
      else
        f[i] = f[i-1] - g[i-3] - g[i-r] - g[i-r+1];
      
      if (i % 7 == 0)
        g[i] = g[i-r+2] - f[i-2];
      else
        g[i] = 5 * f[i-4] - 2 * g[i-r+3];
    }
    return f[n];
  }
  
  // (d) iterrative, efficient
  static int fItr2(int n, int r) {
    int[] f = new int[r + 1];
    int[] g = new int[r + 1];
    
    for (int i = 0; i < r; i++) {
      f[i] = i - 3;
      g[i] = 3 - i;
    }
    
    if (n < r)
      return f[n];
    else {
      for (int i = r; i <= n; i++) {
        if (g[1] >= 0)
          f[r] = f[1] + f[2] - g[0];
        else
          f[r] = f[r-1] - g[r-3] - g[0] - g[1];
        
        if (i % 7 == 0)
          g[r] = g[2] - f[r-2];
        else
          g[r] = 5 * f[r-4] - 2 * g[3];
        
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
      n = Svetovid.in.readInt("Input n, n ∈ [" + nMin + ", " + nMax + "]: ");
    } while (n < nMin || n > nMax);
    
    int r;
    do {
      r = Svetovid.in.readInt("Input r, r ∈ [" + rMin + ", " + rMax + "]: ");
    } while (r < rMin || r > rMax);
    
    System.out.println("fRec1(" + n + ", " + r + ") = " + fRec1(n, r));
    System.out.println("fRec2(" + n + ", " + r + ") = " + fRec2(n, r));
    System.out.println("fItr1(" + n + ", " + r + ") = " + fItr1(n, r));
    System.out.println("fItr2(" + n + ", " + r + ") = " + fItr2(n, r));
  }
}
