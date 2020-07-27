class PrakticneVezbe_20191128_01 {
  
  static int[][] inputArray() {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite n: ");
      if (n <= 0) System.out.println("Greska. Ponovite.");
    } while (n < 2);
    
    int[][] A = new int[n][n];
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        A[i][j] = Svetovid.in.readInt("A[" + i + ", " + j + "] = ");
      }
    }
    return A;
  }
  
  static void checkMain(int[][] A) {
    boolean check = false;
    
    for (int i = 0; i < A.length - 1; i++) {
      int j = A[0].length - 1;
      
      while (j > i && !check) {
        if (A[i][j] != A[j][i]) check = true;
        j--;
      }
    }
    if (!check) System.out.println("Matrica jeste simetricna po glavnoj dijagonali.");
    else System.out.println("Matrica nije simetricna po glavnoj dijagonali.");
  }
  
  static void checkOther(int[][] A) {
    boolean check = false;
    
    for (int i = 0; i < A.length - 1; i++) {
      int j = 0;
      
      while (j < (A[0].length - i - 1) && !check) {
        // System.out.println("A[" + i + ", " + j + "]");
        if (A[i][j] != A[A.length - 1 - i][A[0].length - 1 - j]) check = true;
        j++;
      }
    }
    if (!check) System.out.println("Matrica jeste simetricna po sporednoj dijagonali.");
    else System.out.println("Matrica nije simetricna po sporednoj dijagonali.");
  }
  
  public static void main(String[] args) {
    int[][] A = inputArray();
    checkMain(A);
    checkOther(A);
  }
}
