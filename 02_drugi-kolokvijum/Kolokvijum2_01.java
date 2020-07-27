/**
 * 9.10h-2. Program ucitava prirodne brojeve n i m (1 <= n, m <= 20), i
 * matricu A stringova formata n x m, te proverava koliko elemenata ma-
 * trice pocinje samoglasnikom, ispisuje najkraci string i njegovu duz-
 * inu, te ispisuje matrice malim slovima.
 */

class Kolokvijum2_01 {
  static String[][] inputArray() {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite n: ");
    } while (n < 1);
    
    int m;
    do {
      m = Svetovid.in.readInt("Unesite m: ");
    } while (m < 1);
    
    String[][] A = new String[n][m];
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        A[i][j] = Svetovid.in.readLine("A[" + i + ", " + j + "] = ");
      }
    }
    return A;
  }
  
  static void analyzeArray(String[][] A) {
    int vowelFirst = 0;
    
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        if (Character.toLowerCase(A[i][j].charAt(0)) == 'a' ||
            Character.toLowerCase(A[i][j].charAt(0)) == 'e' ||
            Character.toLowerCase(A[i][j].charAt(0)) == 'i' ||
            Character.toLowerCase(A[i][j].charAt(0)) == 'o' ||
            Character.toLowerCase(A[i][j].charAt(0)) == 'u')
          vowelFirst++;
      }
    }
    
    System.out.println("Pocinje samoglasnikom: " + vowelFirst);
    
    String shortestString = A[0][0];
    
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        if (A[i][j].length() < shortestString.length()) shortestString = A[i][j];
      }
    }
    
    System.out.println("Najkraci string: " + shortestString + " (karaktera: " + shortestString.length() + ")");
    
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        A[i][j] = A[i][j].toLowerCase();
      }
    }
  }
  
  static void printArray(String[][] A) {
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        System.out.print(A[i][j] + "\t");
      }
      System.out.println();
    }
  }
  
  public static void main(String[] args) {
    String[][] A = inputArray();
    analyzeArray(A);
    printArray(A);
  }
}
