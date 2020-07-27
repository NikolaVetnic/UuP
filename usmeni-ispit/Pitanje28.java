class Pitanje28_04 {
  
  static int sqr(int a) {
    return a * a;
  }
  
  static int f(int a, int n) {
    if (n == 0) return 1;
    else if (n == 1) return a;
    else {
      int value = 1;
      
      while (n > 0) {
        if (n % 2 == 1)
          value *= a;
        n /= 2;
        a *= a;
      }
      return value;
    }
  }
  
  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      System.out.print(f(2, i) + "\t");
    }
  }
}