class Iznos {
  public static void main(String[] args) {
    int iznos;
    do {
      iznos = Svetovid.in.readInt("Unesite iznos: ");
      if (iznos <= 0) System.out.println("Iznos mora biti prirodan broj.");
    } while (iznos <= 0);
    
    int br100 = 0, br50 = 0, br20 = 0, br10 = 0, br5 = 0, br2 = 0, br1 = 0;
    
    if (iznos >= 100) {
      br100 = iznos / 100;
      iznos %= 100;
    }
    
    if (iznos >= 50) {
      br50 = iznos / 50;
      iznos %= 50;
    }
    
    if (iznos >= 20) {
      br20 = iznos / 20;
      iznos %= 20;
    }
    
    if (iznos >= 10) {
      br10 = iznos / 10;
      iznos %= 10;
    }
    
    if (iznos >= 5) {
      br5 = iznos / 5;
      iznos %= 5;
    }
    
    if (iznos >= 2) {
      br2 = iznos / 2;
      iznos %= 2;
    }
    
    if (iznos >= 1) {
      br10 = iznos / 1;
      iznos %= 1;
    }
    
    System.out.println("Apoeni:\n100:\t" + br100 + "\n50:\t" + 
                       br50 + "\n20:\t" + br20 + "\n10:\t" + br10 + "\n5:\t" + 
                       br5 + "\n2:\t" + br2 + "\n1:\t" + br1);
  }
}