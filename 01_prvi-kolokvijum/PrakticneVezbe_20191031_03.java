class PrakticneVezbe_20191031_03 {
  public static void main(String[] args) {
    int m;
    do {
      m = Svetovid.in.readInt("Unesite osnovu sistema: ");
      if (m > 10 && m < 2) { System.out.println("Greska. Ponovite unos."); }
    } while (m > 10 && m < 2);
    
    int n = Svetovid.in.readInt("Unesite broj: ");
    int nCopy = n, i = 0, result = 0, cifra = 0;
    boolean check = true;
    
    while (n > 0 && check) {
      cifra = n % 10;
      if (cifra >= m) {
        System.out.println("Cifra na " + (i + 1) + " mestu unetog broja je van opsega!");
        check = false;
      }
      result += cifra * Math.pow(m, i++);
      n /= 10;
    }
    
    if (check) System.out.println("Broj " + nCopy + " u sistemu sa bazom " + m + 
                                  " u dekadnom sistemu iznosi " + result + ".");
  }
}
