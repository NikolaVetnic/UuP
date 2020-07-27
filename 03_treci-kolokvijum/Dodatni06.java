/* Napisati program koji za dati ceo broj n, 0 <= n <= 42, ispisuje vr-
 * ednost elementa rekurentnog niza f_n. Niz je definisan na sledeci n-
 * acin:
 * 
 * f_n = f_n-1 + f_n-3 - 2f_n-4, n >= 4, poslednja cifra n je >= 5
 * f_n = 3f_n-1 - f_n-2 - f_n-4, n >= 4, poslednja cifra n je < 5
 * 
 * f_3 = 1, f_2 = 2, f_1 = 3, f_0 = 1
 * 
 * Element f_n izracunati: 
 *  (a) rekurzivno preko definicije, 
 *  (b) rekurzivno pomocu akumulirajuceg parametra, 
 *  (c) iterativno. 
 * U slucajevima (b) i (c) voditi racuna o efikasnosti resenja. 
 */

class Dodatni06 {
  
  static final int nMin = 0, nMax = 42;
  
  // (a)
  static int fRec1(int n) {
    if (n == 0)
      return 1;
    else if (n == 1)
      return 3;
    else if (n == 2)
      return 2;
    else if (n == 3)
      return 1;
    else if (n % 10 == 5)
      return fRec1(n-1) + fRec1(n-3) - 2 * fRec1(n-4);
    else
      return 3 * fRec1(n-1) - fRec1(n-2) - fRec1(n-4);
  }
  
  // (b)
  static int ff(int f3, int f2, int f1, int f0, int i, int n) {
    if (i > n)
      return f3;
    else if (i % 10 == 5)
      return ff(f3 + f1 - 2 * f0, f3, f2, f1, i+1, n);
    else
      return ff(3 * f3 - f2 - f0, f3, f2, f1, i+1, n);
  }
  
  static int fRec2(int n) {
    if (n == 0)
      return 1;
    else if (n == 1)
      return 3;
    else if (n == 2)
      return 2;
    else if (n == 3)
      return 1;
    else 
      return ff(1, 2, 3, 1, 4, n);
  }
  
  // (c)
  static int fItr1(int n) {
    int[] f = new int[n + 1];
    
    f[0] = 1; f[1] = 3; f[2] = 2; f[3] = 1;
    
    for (int i = 4; i <= n; i++) {
      if (i % 10 == 5)
        f[i] = f[i-1] + f[i-3] - 2 * f[i-4];
      else
        f[i] = 3 * f[i-1] - f[i-2] - f[i-4];
    }
    return f[n];
  }
  
  // (d)
  static int fItr2(int n) {
    int f0 = 1, f1 = 3, f2 = 2, f3 = 1, fn = 0;
    
    if (n == 0)
      return f0;
    else if (n == 1)
      return f1;
    else if (n == 2)
      return f2;
    else if (n == 3)
      return f3;
    else {
      for (int i = 4; i <= n; i++) {
        if (i % 10 == 5)
          fn = f3 + f1 - 2 * f0;
        else
          fn = 3 * f3 - f2 - f0;
        
        f0 = f1;
        f1 = f2;
        f2 = f3;
        f3 = fn;
      }
    }
    return fn;
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
