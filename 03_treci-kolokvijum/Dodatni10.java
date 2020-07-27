/* Napisati program koji za date cele brojeve n, 0 <= n <= 40, i r, gde
 * je 1 <= r <= 10, ispisuje vrednost elementa rekurentnog niza f_n. N-
 * iz je definisan na sledeci nacin: 
 * 
 * f_n = f_n-1 + f_n-2 + ... + f_n-r, n >= r 
 * f_n = n, 0 <= n < r 
 * 
 * Element f_n izracunati: 
 *  (a) rekurzivno preko definicije, 
 *  (b) rekurzivno pomocu akumulirajuceg parametra, 
 *  (c) iterativno. 
 * U slucajevima (b) i (c) voditi racuna o efikasnosti resenja. 
 */

class Dodatni10 {
  
  static final int nMin = 0, nMax = 40;
  static final int rMin = 1, rMax = 10;
  
  // (a)
  static int fRec1(int n, int r) {
    if (n < r)
      return n;
    else {
      int fn = 0;
      
      for (int i = 1; i <= r; i++)
        fn = fn + fRec1(n-i, r);
      
      return fn;
    }
  }
  
  // (b)
  static int ff(int[] f, int i, int n, int r) {
    if (i > n)
      return f[r];
    else {
      f[r] = 0;
      
      for (int j = 1; j <= r; j++)
        f[r] = f[r] + f[r-j];
      
      for (int j = 0; j < r; j++)
        f[j] = f[j+1];
      
      return ff(f, i+1, n, r);
    }
  }
  
  static int fRec2(int n, int r) {
    int[] f = new int[r + 1];
    
    if (n < r)
      return f[n];
    else {
      for (int i = 0; i < r; i++) {
        f[i] = i;
      }
      return ff(f, r, n, r);
    }
  }
  
  // (c)
  static int fItr1(int n, int r) {
    int[] f = new int[n + 1];
    
    if (n < r)
      return n;
    else {
      for (int i = 0; i < r; i++)
        f[i] = i;
      
      for (int i = r; i <= n; i++) {
        f[i] = 0;
        
        for (int j = 1; j <= r; j++)
          f[i] = f[i] + f[i-j];
      }
    }
    return f[n];
  }
  
  // (d)
  static int fItr2(int n, int r) {
    int[] f = new int[r + 1];
    
    if (n < r)
      return n;
    else {
      for (int i = 0; i < r; i++)
        f[i] = i;
      
      for (int i = r; i <= n; i++) {
        f[r] = 0;
        
        for (int j = 1; j <= r; j++)
          f[r] = f[r] + f[r-j];
        
        for (int j = 0; j < r; j++)
          f[j] = f[j+1];
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
