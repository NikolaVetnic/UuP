class TeorijskeVezbe07_03 {
  static int[][] inputArray() {
    int brS;
    do {
      brS = Svetovid.in.readInt("Unesite broj studenata: ");
      if (brS <= 0) System.out.println("Greska. Ponovite.");
    } while (brS <= 0);
    
    int brP;
    do {
      brP = Svetovid.in.readInt("Unesite broj predmeta: ");
      if (brP <= 0) System.out.println("Greska. Ponovite.");
    } while (brP <= 0);
    
    int[][] A = new int[brS][brP];
    
    for (int i = 0; i < brS; i++) {
      System.out.println("Unos ocena za studenta br. " + (i+1) + ": ");
      for (int j = 0; j < brP; j++) {
        A[i][j] = Svetovid.in.readInt("Ocena br. " + (j+1) + ": ");
      }
    }
    return A;
  }
  
  static void prosecnaOcena(int[][] A) {
    for (int i = 0; i < A.length; i++) {
      int sum = 0, count = 0;
      for (int j = 0; j < A[0].length; j++) {
        if (A[i][j] > 5) {
          sum += A[i][j];
          count++;
        }
      }
      System.out.println("Prosecna ocena studenta br. " + i + " je: " + ((double)sum / count));
    }
  }
  
  static void prolaznostIspita(int[][] A) {
    for (int j = 0; j < A[0].length; j++) {
      int count = 0;
      for (int i = 0; i < A.length; i++) {
        if (A[i][j] > 5) count++;
      }
      System.out.print("Ispit br. " + j + " polozilo je " + count + " studenata. "); 
      System.out.println("Prolaznost ispita: " + String.format("%.2f", (double)count / (A[0].length - 1) * 100) + "%");
    }
  }
  
  public static void main(String[] args) {
    int[][] A = inputArray();
    prosecnaOcena(A);
    prolaznostIspita(A);
  }
}
