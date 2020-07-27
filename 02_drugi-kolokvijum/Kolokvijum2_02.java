/**
 * 9.10h-1. Program ucitava prirodan broj n (1 <= n <= 20) i matricu c-
 * elih brojeva A formata n x n. Neka je m maksimalni element iznad gl-
 * avne dijagonale matrice A. Program treba da ispise koliko se puta t-
 * aj element javlja na glavnoj dijagonali matrice A.
 */

class Kolokvijum2_02 {
  static int[][] inputArray() {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite n: ");
    } while (n < 1);
    
    int[][] A = new int[n][n];
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        A[i][j] = Svetovid.in.readInt("A[" + i + ", " + j + "] = ");
      }
    }
    return A;
  }
  
  static void analyzeArray(int[][] A) {
    int max = A[0][1];
    
    for (int i = 0; i < A.length - 1; i++) {
      for (int j = A[0].length - 1; j > i; j--) {
        if (A[i][j] > max) max = A[i][j];
      }
    }
    
    int count = 0;
    
    for (int i = 0; i < A.length; i++) {
      if (A[i][i] == max) count++;
    }
    
    System.out.println("Maksimalni element iznad glavne dijagonale: " + max);
    System.out.println("Na glavnoj dijagonali se pojavljuje puta: " + count);
  }
  
  public static void main(String[] args) {
    int[][] A = inputArray();
    analyzeArray(A);
  }
}
