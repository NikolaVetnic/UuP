class TeorijskeVezbe07_02 {
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
    int tmp = 0;
    
    for (int i = 0; i < A.length - 1; i++) {
      for (int j = A[0].length - 1; j > i; j--) {
        tmp = A[i][j];
        A[i][j] = A[j][i];
        A[j][i] = tmp;
      }
    }
    return A;
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
    int[][] A = inputArray();
    A = transposeArray(A);
    printArray(A);
  }
}
