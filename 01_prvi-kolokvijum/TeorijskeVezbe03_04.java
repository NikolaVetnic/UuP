class TeorijskeVezbe03_04 {
  public static void main(String[] args) {
    int a, b, c = 1, nzd = 1;
    
    do {
      a = Svetovid.in.readInt("Unesite prvi prirodni broj: ");
      if (a <= 0) { System.out.println("Greska. Ponovite unos."); }
    } while (a <= 0);
    
    do {
      b = Svetovid.in.readInt("Unesite drugi prirodni broj: ");
      if (b <= 0) { System.out.println("Greska. Ponovite unos."); }
    } while (b <= 0);
    
    do {
      if (a % c == 0 && b % c == 0) {
        nzd = c;
      }
      c++;
    } while (c <= a / 2 || c <= b / 2);
    
    if (nzd > 1) { System.out.println("Najveci zajednicki delilac je: " + nzd); }
    else { System.out.println("Brojevi nemaju zajednickih delilaca."); }
  }
}
