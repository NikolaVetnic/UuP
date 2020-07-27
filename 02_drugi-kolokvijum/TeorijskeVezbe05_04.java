class TeorijskeVezbe05_04 {
  
  static int[] inputArray(int duz) {
    int[] A = new int[duz];
    for (int i = 0; i < duz; i++) {
      A[i] = Svetovid.in.readInt("Element[" + i + "] = ");
    }
    return A;
  }
  
  static void searchArray(int[] A, int [] B) {
    for (int i = 0; i < A.length; i++) {
      int j = 0;
      boolean found = false;
      
      while (j < B.length && !found) {
        if (B[j] == A[i]) found = true;
        j++;
      }
      
      if (found) System.out.println("B[" + j + "] found at A[" + i + "].");
    }
  }
  
  public static void main(String[] args) {
    int len;
    do {
      len = Svetovid.in.readInt("Input array length: ");
      if (len <= 0) System.out.println("Error. Repeat.");
    } while (len <= 0);
    
    System.out.println("Input 1st array: ");
    int[] A = inputArray(len);
    System.out.println("Input 2nd array: ");
    int[] B = inputArray(len);
    
    searchArray(A, B);
  }
}
