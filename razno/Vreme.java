class Vreme {
  public static void main(String[] args) {
    short godina;
    byte mesec, dan, sat, minut;
    
    do {
      godina = Svetovid.in.readShort("Unesite godinu: ");
      if (godina <= 0 || 4000 <= godina) {
        System.out.println("Greska. Ponovite unos.");
      }
    } while (godina <= 0 || 4000 <= godina);
    
    do {
      mesec = Svetovid.in.readByte("Unesite mesec: ");
      if (mesec <= 0 || 12 <= mesec) {
        System.out.println("Greska. Ponovite unos.");
      }
    } while (mesec <= 0 || 12 <= mesec);
    
    do {
      dan = Svetovid.in.readByte("Unesite dan: ");
      if (((mesec == 1 || mesec == 3 || mesec == 5 || mesec == 7 || mesec == 8 || mesec == 10 || mesec == 12) && (dan <= 0 || 31 < dan)) ||
          ((mesec == 4 || mesec == 6 || mesec == 9 || mesec == 11)                                            && (dan <= 0 || 30 < dan)) ||
          ((mesec == 2)                                                                                       && (dan <= 0 || 29 < dan) 
             && ((godina % 4 == 0) && (godina % 100 == 0) && (godina % 400 == 0))) ||
          ((mesec == 2)                                                                                       && (dan <= 0 || 28 < dan)
             && (godina % 4 != 0))) {
        System.out.println("Greska. Ponovite unos.");
      }
    } while (((mesec == 1 || mesec == 3 || mesec == 5 || mesec == 7 || mesec == 8 || mesec == 10 || mesec == 12) && (dan <= 0 || 31 < dan)) ||
             ((mesec == 4 || mesec == 6 || mesec == 9 || mesec == 11)                                            && (dan <= 0 || 30 < dan)) ||
             ((mesec == 2)                                                                                       && (dan <= 0 || 29 < dan) 
                && ((godina % 4 == 0) && (godina % 100 == 0) && (godina % 400 == 0))) ||
             ((mesec == 2)                                                                                       && (dan <= 0 || 28 < dan)
                && (godina  % 4 != 0)));
      
    do {
      sat = Svetovid.in.readByte("Unesite sat: ");
      if (sat < 0 || 23 < sat) {
        System.out.println("Greska. Ponovite unos.");
      }
    } while (sat < 0 || 23 < sat);
    
    do {
      minut = Svetovid.in.readByte("Unesite minut: ");
      if (minut < 0 || 59 < minut) {
        System.out.println("Greska. Ponovite unos.");
      }
    } while (minut < 0 || 59 < minut);
    
    int vreme = godina << 20 | mesec << 16 | dan << 11 | sat << 6 | minut;
    
    System.out.printf("Pakovano: %d (%x)%n", vreme, vreme);
    
    godina = (short)(vreme >>> 20);
    mesec  = (byte) (vreme >>> 16 & 0x0f);
    dan    = (byte) (vreme >>> 11 & 0x1f);
    sat    = (byte) (vreme >>> 6  & 0x1f);
    minut  = (byte) (vreme        & 0x3f);
    
    System.out.printf("Raspakovano: %d.%d.%d %d:%d%n", 
                      dan, mesec, godina, sat, minut);
  }
}