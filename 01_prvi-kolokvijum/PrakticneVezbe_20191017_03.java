class PrakticneVezbe_20191017_03 {
  public static void main(String[] args) {
    int iznos;
    
    do {
      iznos = Svetovid.in.readInt("Unesite iznos kao prirodan broj: ");
      
      if (iznos <= 0) {
        Svetovid.out.println("Greska. Ponovite unos.");
      }
    } while (iznos <= 0);
    
    int apoen100 = iznos / 100;
    if (apoen100 > 0) {
      iznos = iznos % (apoen100 * 100);
    }
    
    int apoen50 = iznos / 50;
    if (apoen50 > 0) {
      iznos = iznos % (apoen50 * 50);
    }
    
    int apoen20 = iznos / 20;
    if (apoen20 > 0) {
      iznos = iznos % (apoen20 * 20);
    }
    
    int apoen10 = iznos / 10;
    if (apoen10 > 0) {
      iznos = iznos % (apoen10 * 10);
    }
    
    int apoen5 = iznos / 5;
    if (apoen5 > 0) {
      iznos = iznos % (apoen5 * 5);
    }
    
    int apoen2 = iznos / 2;
    if (apoen2 > 0) {
      iznos = iznos % (apoen2 * 2);
    }
    
    int apoen1 = iznos / 1;
    if (apoen1 > 0) {
      iznos = iznos % apoen1;
    }
    
    Svetovid.out.println("Isplata: ");
    Svetovid.out.println("100din x " + apoen100);
    Svetovid.out.println("50din x " + apoen50);
    Svetovid.out.println("20din x " + apoen20);
    Svetovid.out.println("10din x " + apoen10);
    Svetovid.out.println("5din x " + apoen5);
    Svetovid.out.println("2din x " + apoen2);
    Svetovid.out.println("1din x " + apoen1);
  }
}
