class TeorijskeVezbe03_01 {
  public static void main(String[] args) {
    char c;
    // ucitavanje prvog znaka
    
    System.out.println("Unos znakova zavrsite tackom."); 
    System.out.print("Unesite znak: ");
    c = Svetovid.in.readChar();

    // ispis i ucitavanje ostalih znakova
    while (c != '.') { System.out.print(" --> ");
    if (('A' <= c) && (c <= 'Z')) {
      System.out.println((char)(c + 'a' - 'A')); }
        else {
          System.out.println(c);
        }
        
        System.out.print("Unesite znak: "); c = Svetovid.in.readChar();
    }
  }
}
