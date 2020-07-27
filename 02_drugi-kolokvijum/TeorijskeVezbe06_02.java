class TeorijskeVezbe06_02 {
  static int[] inputArray() {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite n: ");
      if (n <= 0) System.out.println("Greska. Ponovite.");
    } while (n <= 0);
    
    int[] A = new int[n];
    
    A[0] = Svetovid.in.readInt("A[0] = ");
    
    for (int i = 1; i < n; i++) {
      do {
        A[i] = Svetovid.in.readInt("A[" + i + "] = ");
        if (A[i] <= A[i-1]) System.out.println("Greska. Niz je strogo rastuci.");
      } while (A[i] <= A[i-1]);
    }
    
    return A;
  }
  
  static void binSearch(int[] A, int num) {
    int lft = 0, rgt = A.length - 1, mid = (lft + rgt) / 2;
    boolean found = false;
    
    while (!found && lft < rgt) {
      if (num == A[mid]) {
        System.out.println("Broj je pronadjen na poziciji: " + mid);
        found = true;
      }
      else if (num < A[mid]) {
        rgt = mid - 1;
        mid = (lft + rgt) / 2;
      }
      else {
        lft = mid + 1;
        mid = (lft + rgt) / 2;
      }
    }
    
    if (!found) System.out.println("Broj nije pronadjen.");
  }
  
  public static void main(String[] args) {
    int[] A = inputArray();
    binSearch(A, 3);
  }
}
