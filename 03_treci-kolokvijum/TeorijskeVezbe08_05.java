class TeorijskeVezbe08_05 {
  static int binTraRec(int[] A, int boundL, int boundR, int num) {
    if (boundL > boundR) return -1;
    else {
      if (num == A[(boundL + boundR) / 2]) return (boundL + boundR) / 2;
      else if (num < A[(boundL + boundR) / 2]) return binTraRec(A, boundL, (boundL + boundR) / 2 - 1, num);
      else return binTraRec(A, (boundL + boundR) / 2 + 1, boundR, num);
    }
  }
  
  public static void main(String[] args) {
    int len;
    do {
      len = Svetovid.in.readInt("Unesite duzinu niza: ");
    } while (len <= 0);
    
    int[] A = new int[len];
    
    A[0] = Svetovid.in.readInt("A[0] = ");
    
    for (int i = 1; i < A.length; i++) {
      do {
        A[i] = Svetovid.in.readInt("A[" + i + "] = ");
      } while (A[i] <= A[i - 1]);
    }
    
    int num;
    do {
      num = Svetovid.in.readInt("Unesite broj za pretragu: ");
    } while (num <= 0);
    
    System.out.println("Broj je pronadjen na poziciji: " + binTraRec(A, 0, A.length - 1, num));
  }
}
