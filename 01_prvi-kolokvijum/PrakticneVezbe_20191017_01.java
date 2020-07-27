class PrakticneVezbe_20191017_01 {
  public static void main(String[] args) {
    int br1;
    int br2;
    
    do {
      br1 = Svetovid.in.readInt("Unesite prvi prirodan broj: ");
      if (br1 <= 0) {
        Svetovid.out.println("Greska. Ponovite unos.");
      }
    } while(br1 <= 0);
    
    do {
      br2 = Svetovid.in.readInt("Unesite drugi prirodan broj: ");
      if (br2 <= 0) {
        Svetovid.out.println("Greska. Ponovite unos.");
      }
    } while(br2 <= 0);
    
    Svetovid.out.println("Aritmeticka sredina je: " + ((br1 + br2) / 2.0));
  }
}
