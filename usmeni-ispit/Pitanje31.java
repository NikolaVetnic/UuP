class Pitanje31_03 {
  final static int LIMIT = 50;
  
  static int fibonacci(int n) {
    if (0 <= n && n <= LIMIT) {
      boolean ok = true;
      
      int[] f = new int[3];
      f[0] = 0; f[1] = 1;
      f[2] = f[0] + f[1];
      
      if (n <= 2) return f[n];
      else {
        int i = 3;
        while (i <= n && ok) {
          ok = Integer.MAX_VALUE - f[1] > f[0];
          if (ok) {
            f[0] = f[1];
            f[1] = f[2];
            f[2] = f[1] + f[0];
            i++;
          }
        }
        return f[2];
      }
    }
    else
      return -1;
  }
  
  static int fibonacci1(int n) {
    boolean ok = true;
    int f0 = 0; int f1 = 1;
    
    if (n == 0) return f0;
    else if (n == 1) return f1;
    else {
      int i = 2;
      
      while (i <= n && ok) {
        ok = Integer.MAX_VALUE - f1 - f1 > f0;
        if (ok) {
          f0 = f0 + f1;
          f1 = f0 + f1;
          i += 2;
        }
      }
      if (ok) {
        if (n % 2 == 1)
          return f1;
        else
          return f0;
      }
      else
        return -1;
    }
  }
  
  public static void main(String[] args) {
    for (int i = 0; i <= 10; i++) {
      System.out.print(fibonacci(i) + "\t");
    }
    System.out.println();
    
    for (int i = 0; i <= 10; i++) {
      System.out.print(fibonacci1(i) + "\t");
    }
    System.out.println();
  }
}