class Pitanje24_06 {
  
  static int f(int n) {
    return n * 2;
  }
  
  static int even(int n) {
    int value = 0;
    
    for (int i = 1; i <= n; i++) {
      value = f(i);
    }
    return value;
  }
  
  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      System.out.print(even(i) + "\t");
    }
    System.out.println();
  }
}