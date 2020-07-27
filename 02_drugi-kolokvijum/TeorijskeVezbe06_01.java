class TeorijskeVezbe06_01 {
  
  static int[] inputArray() {
    int len1;
    do {
      len1 = Svetovid.in.readInt("Unesite len1: ");
    } while (len1 <= 0);
    
    int[] A = new int[51];
    A[50] = len1;
    
    for (int i = 0; i < A[50]; i++) {
      A[i] = Svetovid.in.readInt("A[" + i + "] = ");
    }
    return A;
  }
  
  static int[] removeDuplicates(int[] A) {
    int[] B = new int[51];
    B[50] = 0;
    
    for (int i = 0; i < A[A.length-1]; i++) {
      boolean found = false;
      int j = 0;
      
      while (!found && j < i) {
        if (A[j] == A[i]) found = true;
        j++;
      }
      if (!found) B[B[50]++] = A[i];
    }
    return B;
  }
  
  static void printArray(int[] A) {
    for (int i = 0; i < A[50]; i++) {
      System.out.print(A[i] + "\t");
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    int[] A = inputArray();
    int[] B = removeDuplicates(A);
    
    printArray(A);
    printArray(B);
  }
}
