class TeorijskeVezbe07_01 {
  
  static int[][] inputArray(int n, int m) {
    int[][] A = new int[n][m];
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        A[i][j] = Svetovid.in.readInt("[" + i + ", " + j + "] = ");
      }
    }
    return A;
  }
  
  static int[][] multiplyArray(int[][] A, int[][] B) {
    if (A[0].length != B.length) {
      System.out.println("Zadate matrice je nemoguce pomnoziti.");
      return null;
    }
    else {
      int[][] C = new int[A.length][B[0].length];
      for (int i = 0; i < A.length; i++) {
        for (int k = 0; k < B[0].length; k++) {
          C[i][k] = 0;
          for (int j = 0; j < A[0].length; j++) {
            C[i][k] += A[i][j] * B[j][i];
          }
        }
      }
      return C;
    }
  }
  
  static void printArray(int[][] A) {
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        System.out.print(A[i][j] + "\t");
      }
      System.out.println();
    }
  }
  
  public static void main(String[] args) {
    final int dim1 = 3;
    final int dim2 = 4;
    final int dim3 = 5;
    
    System.out.println("Unos matrice A: ");
    int[][] A = inputArray(dim1, dim2);
    System.out.println("Unos matrice B: ");
    int[][] B = inputArray(dim2, dim3);
    
    int[][] C = multiplyArray(A, B);
    
    System.out.println("Matrica A: ");
    printArray(A);
    System.out.println("Matrica B: ");
    printArray(B);
    System.out.println("Matrica C: ");
    printArray(C);
  }
}
