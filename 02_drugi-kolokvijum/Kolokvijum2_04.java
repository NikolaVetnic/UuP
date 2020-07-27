/**
 * 11:30 - 12:30h (A) Za unetu matricu celih brojeva formata n x n isp-
 * itati da li je heterogena, homogena ili poluhomogena. Matrica je po-
 * luhomogena ukoliko su joj svi elementi na glavnoj dijagonali jednaki
 * nekom broju A, a svi elementi van glavne dijagonale jednaki nekom b-
 * roju B pri cemu je A != B. Ako je A = B matrica je homogena (svi el-
 * ementi u matrici su identicni). Matrica je heterogena ako nije ni h-
 * omogena ni poluhomogena. Matrica sa tacno jednim elementom je homog-
 * ena.
 */

class Kolokvijum2_04 {
  static int[][] inputArray() {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite n: ");
    } while (n <= 0);
    
    int[][] A = new int[n][n];
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        A[i][j] = Svetovid.in.readInt("A[" + i + ", " + j + "] = ");
      }
    }
    return A;
  }
  
  static void analyzeArray(int[][] A) {
    if (A.length == 1) {
      System.out.println("Matrica je homogena.");
    }
    else {
      int a = A[0][0], b = A[0][1];
      int i = 0, j = A[0].length - 1;
      boolean checkA = false, checkB = false;
      
      while (i < A.length && !checkA) {
        if (A[i][i] != a) checkA = true;
        i++;
      }
      
      i = 0;
      
      while (i < A.length - 1 && !checkB) {
        j = A[0].length - 1;
        
        while (j > i && !checkB) {
          if (A[i][j] != b) checkB = true;
          j--;
        }
        i++;
      }
      
      if (!checkA && !checkB) {
        if (a == b) System.out.println("Matrica je homogena.");
        else System.out.println("Matrica je poluhomogena.");
      }
      else System.out.println("Matrica je heterogena.");
    }
  }
  
  public static void main(String[] args) {
    int[][] A = inputArray();
    analyzeArray(A);
  }
}
