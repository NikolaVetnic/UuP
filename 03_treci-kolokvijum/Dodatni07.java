/* Napisati program koji za dati ceo broj n, 0 <= n <= 35, ispisuje vr-
 * ednost elementa rekurentnog niza f_n. Niz je definisan na sledeci n-
 * acin:
 * 
 * f_n = -f_n-1 + f_n-2 - 2*f_n-3, n mod 3 = 2, n >= 3
 * f_n = 2f_n-2 - 3*f_n-3, n mod 3 = 1, n >= 3
 * f_n = f_n-1 + f_n-3, n mod 3 = 0, n >= 3
 * 
 * f_2 = 1, f_1 = 2, f_0 = 3
 * 
 * Element f_n izracunati: 
 *  (a) rekurzivno preko definicije, 
 *  (b) rekurzivno pomocu akumulirajuceg parametra, 
 *  (c) iterativno. 
 * U slucajevima (b) i (c) voditi racuna o efikasnosti resenja. 
 */

class Dodatni07 {
  
  static final int nMin = 0, nMax = 35;
  
  // (a)
  static int fRec1(int n) {
    if (n == 0)
      return 3;
    else if (n == 1)
      return 2;
    else if (n == 2)
      return 1;
    else if (n % 3 == 2)
      return -fRec1(n-1) + fRec1(n-2) - 2 * fRec1(n-3);
    else if (n % 3 == 1)
      return 2 * fRec1(n-2) - 3 * fRec1(n-3);
    else
      return fRec1(n-1) + fRec1(n-3);
  }
  
  // (b)
  static int ff(int f2, int f1, int f0, int i, int n) {
    if (i > n)
      return f2;
    else if (i % 3 == 2)
      return ff(-f2 + f1 - 2 * f0, f2, f1, i+1, n);
    else if (i % 3 == 1)
      return ff(2 * f1 - 3 * f0, f2, f1, i+1, n);
    else
      return ff(f2 + f0, f2, f1, i+1, n);
  }
  
  static int fRec2(int n) {
    int f0 = 3, f1 = 2, f2 = 1;
    
    if (n == 0)
      return f0;
    else if (n == 1)
      return f1;
    else if (n == 2)
      return f2;
    else
      return ff(f2, f1, f0, 3, n);
  }
  
  // (c)
  static int fItr1(int n) {
    int[] f = new int[n + 1];
    
    f[0] = 3; f[1] = 2; f[2] = 1;
    
    if (n < 3)
      return f[n];
    else {
      for (int i = 3; i <= n; i++) {
        if (i % 3 == 2)
          f[i] = -f[i-1] + f[i-2] - 2 * f[i-3];
        else if (i % 3 == 1)
          f[i] = 2 * f[i-2] - 3 * f[i-3];
        else
          f[i] = f[i-1] + f[i-3];
      }
    }
    return f[n];
  }
  
  // (d)
  static int fItr2(int n) {
    int f0 = 3, f1 = 2, f2 = 1, fn = 0;
    
    if (n == 0)
      return f0;
    else if (n == 1)
      return f1;
    else if (n == 2)
      return f2;
    else {
      for (int i = 3; i <= n; i++) {
        if (i % 3 == 2)
          fn = -f2 + f1 - 2 * f0;
        else if (i % 3 == 1)
          fn = 2 * f1 - 3 * f0;
        else
          fn = f2 + f0;
        
        f0 = f1; f1 = f2; f2 = fn;
      }
      return fn;
    }
  }
  
  public static void main(String[] args) {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite n, n ∈ [" + nMin + ", " + nMax + "]: ");
    } while (n < nMin || n > nMax);
    
    System.out.println("fRec1(" + n + ") = " + fRec1(n));
    System.out.println("fRec2(" + n + ") = " + fRec2(n));
    System.out.println("fItr1(" + n + ") = " + fItr1(n));
    System.out.println("fItr2(" + n + ") = " + fItr2(n));
  }
}
