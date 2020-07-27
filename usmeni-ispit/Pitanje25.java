class Pitanje25_06 {
  
  static int f(int s, int k, int n) {
    return s * (n - k + 1) / k;
  }
  
  static int bk(int k, int n) {
    if (k <= 0 || n <= 0) return -1;
    else if (k > n) return 0;
    else {
      if (k > n - k) k = n - k;
      
      int value = 1;
      
      for (int i = 1; i <= k; i++) {
        value = f(value, i, n);
      }
      return value;
    }
  }
  
  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      System.out.print(bk(i, 10) + "\t");
    }
  }
}