class Pitanje32_04 {
  
  static int fibonacci2(int n) {
    if (n <= 1) return n;
    else return fibonacci2(n - 1) + fibonacci2(n - 2);
  }
  
  static int f(int f1, int f0, int i, int n) {
    if (i > n)
      return f1;
    else
      return f(f1 + f0, f1, i + 1, n);
  }
  
  static int fibonacci3(int n) {
    if (n <= 1)
      return n;
    else
      return f(1, 0, 2, n);
  }
  
  public static void main(String[] args) {
    for (int i = 0; i <= 10; i++) {
      System.out.print(fibonacci2(i) + "\t");
    }
    System.out.println();
    
    for (int i = 0; i <= 10; i++) {
      System.out.print(fibonacci3(i) + "\t");
    }
    System.out.println();
  }
}