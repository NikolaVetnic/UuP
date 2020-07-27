class TeorijskeVezbe12_02 {
  
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
  static void uvecajStepen(Polinom p) {
    if (p == null) return;
    
    p.k[p.st+3] = p.k[p.st];
    p.k[p.st] = 0;
    PolinomN.nadjiStepen(p);
  }
  
  // (d)
  static void stampajMonom(Polinom p) {
    if (p == null) return;
    
    double max = 0.0;
    int koef = 0;
    
    for (int i = 1; i <= p.st; i++) {
      if (p.k[i] * i > max) {
        max = p.k[i] * i;
        koef = i;
      }
    }
    
    Polinom rez = new Polinom();
    rez.st = koef;
    rez.k[koef] = p.k[koef];
    PolinomN.stampaj(rez);
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
    
    Polinom[] kolOst = PolinomN.deli(p, q);
    System.out.print("p(x) / q(x) = ");
    PolinomN.stampaj(kolOst[0]);
    System.out.print(", uz ostatak ");
    PolinomN.stampaj(kolOst[1]);
    System.out.println();
    
    // (b)
    Polinom tmp = new Polinom();
    Polinom rez = new Polinom();
    
    tmp = kompozicija(p, q);
    rez = PolinomN.saberi(rez, tmp);
    PolinomN.anuliraj(tmp);
    
    double d = PolinomN.izracunaj(1.0, q);
    tmp = PolinomN.brojPuta(p, d);
    rez = PolinomN.saberi(rez, tmp);
    PolinomN.anuliraj(tmp);
    
    tmp = PolinomN.puta(p, p);
    rez = PolinomN.saberi(rez, tmp);
    PolinomN.anuliraj(tmp);
    
    tmp.st = 3;
    tmp.k[0] = 2.0;
    tmp.k[1] = -3.0;
    tmp.k[3] = -1.0;
    rez = PolinomN.saberi(rez, tmp);
    PolinomN.anuliraj(tmp);
    
    System.out.print("r(x) = q(x–1) + q(1)p(x) + p^2(x) – x^3 – 3x + 2 = ");
    PolinomN.stampaj(rez);
    System.out.println();
    
    // (c)
    uvecajStepen(rez);
    System.out.print("rez(x) = ");
    PolinomN.stampaj(rez);
    System.out.println();
    
    // (d)
    stampajMonom(rez);
  }
}
