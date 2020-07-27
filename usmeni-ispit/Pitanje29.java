class Pitanje29_04 {
  
  static int sqr(int a) {
    return a * a;
  }
  
  static int rec(int a, int n) {
    if (n == 1) return a;
    else if (n % 2 == 1) return a * rec(sqr(a), n / 2);
    else return rec(sqr(a), n / 2);
  }
  
  static int f(int a, int n) {
    if (n == 0) return 1;
    else return rec(a, n);
  }
  
  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      System.out.print(f(2, i) + "\t");
    }
  }
}