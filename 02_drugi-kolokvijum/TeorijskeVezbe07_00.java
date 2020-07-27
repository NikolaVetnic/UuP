class TeorijskeVezbe07_00 {
  static int[][] inputMatrix() {
    int[][] A = new int[3][4];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) {
        A[i][j] = Svetovid.in.readInt("Element[" + i + ", " + j + "] = ");
      }
    }
    return A;
  }
  
  static int[][] addMatrix(int[][] A, int[][] B) {
    int[][] C = new int[A.length][A[0].length];
    
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) {
        C[i][j] = A[i][j] + B[i][j];
      }
    }
    return C;
  }
  
  static void printMatrix(int[][] A) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) System.out.print(A[i][j] + "\t");
      System.out.println();
    }
  }
  
  public static void main(String[] args) {
    System.out.println("Input A: ");
    int[][] A = inputMatrix();
    System.out.println("Input B: ");
    int[][] B = inputMatrix();
    
    int[][] C = addMatrix(A, B);
    System.out.println("A + B: ");
    printMatrix(C);
  }
}
