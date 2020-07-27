class TeorijskeVezbe09_03 {
  static final int granica = 30;
  
  // (a) rekurzivno preko definicije
  static int fRec1(int n) {
    if (n <= 2) return n;
    else return 2 * fRec1(n - 1) - fRec1(n - 2) + fRec1(n - 3);
  }
  
  // (b) rekurzivno preko akumulirajuceg parametra
  static int ff(int f2, int f1, int f0, int n) {
    if (n == 0) return f0;
    else return ff(2 * f2 - f1 + f0, f2, f1, n - 1);
  }
  
  static int fRec2(int n) {
    return ff(2, 1, 0, n);
  }
  
  // (c) iterativno, prostorno neefikasno
  static int fItr1(int n) {
    int[] f = new int[n + 1];
    f[0] = 0;
    f[1] = 1;
    f[2] = 2;
    for (int i = 3; i <= n; i++) {
      f[i] = 2 * f[i-1] - f[i-2] + f[i-3];
    }
    return f[n];
  }
  
  // (d) iterativno, efikasno
  static int fItr2(int n) {
    int fn;
    int f0 = 0;
    int f1 = 1;
    int f2 = 2;
    
    if (n == 0) fn = f0;
    else if (n == 1) fn = f1;
    else if (n == 2) fn = f2;
    else {
      fn = 0;
      for (int i = 3; i <= n; i++) {
        fn = 2*f2 - f1 + f0;
        f0 = f1;
        f1 = f2;
        f2 = fn;
      }
    }
    return fn;
  }
  
  public static void main(String[] args) {
    System.out.println("fRec1(3) = " + fRec1(3));
    System.out.println("fRec1(15) = " + fRec1(15));
    System.out.println();
    
    System.out.println("fRec2(3) = " + fRec2(3));
    System.out.println("fRec2(15) = " + fRec2(15));
    System.out.println();
    
    System.out.println("fItr1(3) = " + fItr1(3));
    System.out.println("fItr1(15) = " + fItr1(15));
    System.out.println();
    
    System.out.println("fItr2(3) = " + fItr2(3));
    System.out.println("fItr2(15) = " + fItr2(15));
    System.out.println();
    
  }
}
