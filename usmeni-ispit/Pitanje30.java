class Pitanje30_01 {
  
  static int fRec1(int r, int n) {
    if (n <= r)
      return n;
    else
      return fRec1(r, n - 3) + fRec1(r, n - 2) + fRec1(r, n - 1);
  }
  
  public static void main(String[] args) {
    int r = 5;
    int n = 7;
    
    System.out.println(fRec1(r, n));
    System.out.println(fRec1(n, r));
  }
}