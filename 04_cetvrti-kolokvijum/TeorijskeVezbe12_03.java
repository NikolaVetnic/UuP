class TeorijskeVezbe12_03 {
  
  // (b)
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
  
  // (c)
  static void zaokruziKoef(Polinom a) {
    if (a == null) return;
    
    for (int i = 0; i <= a.st; i++) {
      a.k[i] = Math.round(a.k[i]);
    }
    PolinomN.nadjiStepen(a);
  }
  
  // (d)
  static int visestrukostNule(Polinom p, double t) {
    if (p == null) 
      return -1;
    
    Polinom xMinusT = new Polinom();
    xMinusT.st = 1;
    xMinusT.k[0] = -t;
    xMinusT.k[1] = 1.0;
    
    int n = 0;
    
    while (PolinomN.izracunaj(t, p) == 0.0) {
      Polinom[] kolOst = PolinomN.deli(p, xMinusT);
      p = kolOst[0];
      n++;
    }
    return n;
  }
  
  public static void main(String[] args) {
    // (a)
    Polinom p = PolinomN.ucitaj();
    System.out.print("p(x) = ");
    PolinomN.stampaj(p);
    System.out.println();
    
    Polinom q = PolinomN.ucitaj();
    System.out.print("q(x) = ");
    PolinomN.stampaj(q);
    System.out.println();
    
    Polinom r = PolinomN.saberi(p, q);
    System.out.print("p(x) + q(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (b)
    Polinom tmp = new Polinom();
    tmp.st = 1;
    tmp.k[0] = 1.0;
    tmp.k[1] = 2.0;
    r = kompozicija(q, tmp);
    PolinomN.anuliraj(tmp);
    
    tmp.st = 2;
    tmp.k[2] = 1.0;
    double d = PolinomN.izracunaj(2.0, p);
    tmp = PolinomN.puta(tmp, p);
    tmp = PolinomN.brojPuta(tmp, d);
    r = PolinomN.saberi(r, tmp);
    PolinomN.anuliraj(tmp);
    
    tmp.st = 3;
    tmp.k[0] = -1;
    tmp.k[3] = 4;
    r = PolinomN.saberi(r, tmp);
    
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (c)
    zaokruziKoef(r);
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (d)
    double t = Svetovid.in.readDouble("Unesite realan broj: ");
    System.out.println("t = " + t + " se javlja kao nula polinoma r(x) " + visestrukostNule(r, t) + " puta.");
  }
}
