// Ucitava niz od duz celih brojeva i kreira i
// ispisuje novi niz tako da iz starog niza izbaci
// sve duplikate.

class Duplikati {
  public static void main(String[] args) {
    int duz, duz2, i, j;
    int[] niz = new int[50];
    int[] niz2 = new int[50];
    boolean duplikat;
    
    System.out.print("Unesite broj elemenata u nizu: ");
    duz = Svetovid.in.readInt();
    
    for (i = 0; i < duz; i++) {
      System.out.print("Unesite " + i + ". element niza: ");
      niz[i] = Svetovid.in.readInt();
    }
    
    duz2 = 0;
    int dupli = 0;
    
    for (i = 0; i < duz; i++) {
      duplikat = false;
      j = 0;
      
      while (j < i && !duplikat) {
        if (niz[i] == niz[j]) {
          dupli++;
          duplikat = true;
        }
        else j++;
      }
      if (!duplikat) {
        niz2[duz2] = niz[i];
        duz2++;
      }
    }
    
    int[] niz3 = new int[duz2];
    
    System.out.print("Elementi drugog niza su: ");
    for (i = 0; i < duz2; i++) {
      niz3[i] = niz2[i];
      System.out.print(" " + niz3[i]);
    }
    
    System.out.println();
  }
}