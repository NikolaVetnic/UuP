class TeorijskeVezbe05_01 {
  static int[] unos(int duz) {
    int[] A = new int[duz];
    for (int i = 0; i < duz; i++) {
      A[i] = Svetovid.in.readInt("A[" + i + "] = ");
    }
    return A;
  }
  
  static void linTra(int[] A, int broj) {
    boolean found = false;
    int i = 0;
    
    while (i < A.length && !found) {
      if (A[i] == broj) found = true;
      else i++;
    }
    
    if (found) System.out.println("Broj je pronadjen na " + i + ". poziciji.");
    else System.out.println("Broj nije pronadjen.");
  }
  
  public static void main(String[] args) {
    int duz;
    do {
      duz = Svetovid.in.readInt("Duzina niza: ");
      if (duz <= 0) System.out.println("Greska. Ponoviti.");
    } while (duz <= 0);
    
    int[] A = unos(duz);
    
    int broj = Svetovid.in.readInt("Broj za pretragu: ");
    
    linTra(A, broj);
  }
}
