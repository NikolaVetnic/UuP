class PrakticneVezbe_20191128_02 {
  
  static int[] inputArray() {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite n: ");
      if (n < 2) System.out.println("Greska. Ponovite.");
    } while (n < 2);
    
    int[] A = new int[n];
    
    for (int i = 0; i < n; i++) {
      A[i] = Svetovid.in.readInt("Element[" + i + "] = ");
    }
    return A;
  }
  
  static void checkArrays(int[] A, int[] B) {
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < B.length; j++) {
        if (A[i] % B[j] == 0) System.out.println("A[" + i + "] % B[" + j + "] = " + A[i] + " % " + B[j] + " = 0");
      }
    }
  }
  
  public static void main(String[] args) {
    int[] A = inputArray();
    int[] B = inputArray();
    
    checkArrays(A, B);
  }
}
