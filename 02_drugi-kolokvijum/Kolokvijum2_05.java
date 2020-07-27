/**
 * Napisati program koji ucitava prirodan broj n (1 <= n <= 20) i celo-
 * brojnu matricu A formata n x n, te potom ispituje da li je matrica A
 * retka. Matrica je retka ako sadrzi vise nula elemenata od ne-nula e-
 * lemenata.
 */

class Kolokvijum2_05 {
  
  static int[][] inputArray() {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite n: ");
    } while (n < 1 || n > 20);
    
    int[][] A = new int[n][n];
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        A[i][j] = Svetovid.in.readInt("A[" + i + ", " + j + "] = ");
      }
    }
    return A;
  }
  
  static void analyzeArray(int[][] A) {
    int countZeros = 0, countOther = 0;
    
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        if (A[i][j] == 0) countZeros++;
        else countOther++;
      }
    }
    
    if (countZeros > countOther) System.out.println("Matrica je retka.");
  }
  
  public static void main(String[] args) {
    int[][] A = inputArray();
    analyzeArray(A);
  }
}
