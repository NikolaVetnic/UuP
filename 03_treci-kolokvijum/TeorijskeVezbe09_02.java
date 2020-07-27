class TeorijskeVezbe09_02 {
  
  static int nadjiNRP(int[] niz, int index) {
    if (index == 0) return 1;
    else {
      int maxDuzina = 0;
      for (int i = 0; i < index; i++) {
        if (niz[i] < niz[index]) {
          int duzina = nadjiNRP(niz, i);
          if (duzina > maxDuzina) maxDuzina = duzina;
        }
      }
      return maxDuzina + 1;
    }
  }
  
  public static void main(String[] args) {
    int len;
    do {
      len = Svetovid.in.readInt("Unesite duzinu niza: ");
    } while (len <= 0);
    
    int[] A = new int[len];
    
    for (int i = 0; i < A.length; i++) {
      A[i] = Svetovid.in.readInt("A[" + i + "] = ");
    }
    
    int rez = 0;
    for (int i = 0; i < A.length; i++) {
      if (rez < nadjiNRP(A, i)) rez = nadjiNRP(A, i);
    }
    
    System.out.println("Duzina najduzeg rastuceg podniza je: " + rez);
  }
}
