/**
 * 2. B Za unetu matricu stringova A, dimenzija n x m, napraviti matri-
 * cu B dimenzije m x n, koja predstavlja rotiranu matricu A na sledeci
 * nacin: poslednja kolona postaje prvi red, pretposlednja kolona post-
 * aje drugi red, itd. Svaki string u B treba da bude sa velikim slovi-
 * ma, ukoliko taj string pocinje samoglasnikom. Odstampati B.
 */

class Kolokvijum2_03 {
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
  
  static String[][] rotateArray(String[][] A) {
    String[][] B = new String[A[0].length][A.length];
    
    for (int j = 0; j < A[0].length; j++) {
      for (int i = 0; i < A.length; i++) {
        B[j][i] = A[i][A[0].length - j - 1];
        if (Character.toLowerCase(B[j][i].charAt(0)) == 'a' ||
            Character.toLowerCase(B[j][i].charAt(0)) == 'e' ||
            Character.toLowerCase(B[j][i].charAt(0)) == 'i' ||
            Character.toLowerCase(B[j][i].charAt(0)) == 'o' ||
            Character.toLowerCase(B[j][i].charAt(0)) == 'u')
          B[j][i] = B[j][i].toUpperCase();
      }
    }
    return B;
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
    String[][] B = rotateArray(A);
    
    System.out.println("Matrica A: ");
    printArray(A);
    System.out.println("Matrica B: ");
    printArray(B);
  }
}
