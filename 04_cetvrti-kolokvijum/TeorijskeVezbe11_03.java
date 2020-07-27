class TeorijskeVezbe11_03 {
  
  static Polinom kompozicija(Polinom a, Polinom b) {
    if (a == null || b == null || a.st * b.st > Polinom.maxSt)
      return null;
    
    Polinom rez = new Polinom();
    
    if (a.st > -1) {
      rez.st = 0;
      rez.k[0] = a.k[0];
      
      Polinom bNaN = new Polinom();
      bNaN.st = 0;
      bNaN.k[0] = 1.0;
      
      for (int n = 1; n <= a.st; n++) {
        bNaN = PolinomN.puta(b, bNaN);
        Polinom bNaNPutaKoef = PolinomN.brojPuta(bNaN, a.k[n]);
        rez = PolinomN.saberi(rez, bNaNPutaKoef);
      }
    }
    return rez;
  }
  
  public static void main(String[] args) {
    System.out.println("Unesite polinom p: ");
    Polinom p = PolinomN.ucitaj();
    
    double t = Svetovid.in.readDouble("Unesite t: ");
    
    System.out.print("p(x) = ");
    PolinomN.stampaj(p);
    System.out.println();
    
    Polinom xt = new Polinom();
    xt.st = 1;
    xt.k[0] = t;
    xt.k[1] = 1.0;
    
    Polinom q = kompozicija(p, xt);
    
    if (q != null) {
      System.out.print("q(x) = p(x + " + t + ") = ");
      PolinomN.stampaj(q);
      System.out.println();
    }
    else
      System.out.println("Polinom q je prevelikog stepena.");
  }
}
