class PrakticneVezbe_20191121_03 {
  
  static int[][] inputArray() {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite n: ");
      if (n <= 1 || n > 20) System.out.println("Greska. Ponovite.");
    } while (n <= 1 || n > 20);
    
    int[][] A = new int[n][n];
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        A[i][j] = Svetovid.in.readInt("A[" + i + ", " + j + "] = ");
      }
    }
    return A;
  }
  
  static int[][] transposeArray(int[][] A) {
    for (int i = 0; i < A.length - 1; i++) {
      for (int j = A[0].length - 1; j > i; j--) {
        int tmp = A[i][j];
        A[i][j] = A[j][i];
        A[j][i] = tmp;
      }
    }
    return A;
  }
  
  static int[][] rotateArray(int[][] A) {
    int[][] B = new int[A.length][A[0].length];
    int k = 0;
    
    for (int i = 0; i < B.length; i++) {
      for (int j = 0; j < B[0].length; j++) {
        B[i][j] = A[j][A.length - i - 1];
      }
    }
    return B;
  }
  
  static void printArray(int[][] A) {
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        System.out.print(A[i][j] + "\t");
      }
      System.out.println();
    }
  }
  
  static int maxElement(int[][] A) {
    int max = A[0][0];
    
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        if (A[i][j] > max) max = A[i][j];
      }
    }
    return max;
  }
  
  public static void main(String[] args) {
    int[][] A = inputArray();
    System.out.println("Najveci element: " + maxElement(A));
    
    System.out.println("Originalna matrica: ");
    printArray(A);
    System.out.println("Transponovana matrica: ");
    printArray(transposeArray(A));
    System.out.println("Rotirana matrica: ");
    printArray(rotateArray(A));
    
  }
}
