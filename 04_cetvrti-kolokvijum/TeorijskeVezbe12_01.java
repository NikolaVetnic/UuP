class TeorijskeVezbe12_01 {
  
  static Polinom izvod(Polinom p) {
    if (p == null)
      return null;
    
    Polinom rez = new Polinom();
    
    if (p.st > 0) {
      rez.st = p.st - 1;
      for (int i = 0; i <= rez.st; i++)
        rez.k[i] = rez.k[i] + p.k[i+1] * (i+1);
    }
    return rez;
  }
  
  // (c)
  static void odstraniNegativne(Polinom p) {
    if (p == null) return;
    
    for (int i = 0; i <= p.st; i++) {
      if (p.k[i] < 0)
        p.k[i] = 0;
    }
    PolinomN.nadjiStepen(p);
  }
  
  
  // (d)
  static void stampajMonome(Polinom p) {
    if (p == null) return;
    
    Polinom pom = new Polinom();
    
    for (int i = 0; i <= p.st; i++) {
      if (p.k[i] > p.st) {
        PolinomN.anuliraj(pom);
        
        pom.st = i;
        pom.k[i] = p.k[i];
        
        PolinomN.stampaj(pom);
        System.out.println();
      }
    }
  }
  
  public static void main(String[] args) {
    // (a)
    System.out.println("Unesite polinom p: ");
    Polinom p = PolinomN.ucitaj();
    System.out.print("p(x) = ");
    PolinomN.stampaj(p);
    System.out.println();
    
    System.out.println("Unesite polinom q: ");
    Polinom q = PolinomN.ucitaj();
    System.out.print("q(x) = ");
    PolinomN.stampaj(q);
    System.out.println();
    
    if (p.st * q.st <= Polinom.maxSt) {
      System.out.print("Proizvod polinoma p(x) i q(x): ");
      PolinomN.stampaj(PolinomN.puta(p, q));
      System.out.println();
    }
    else
      System.out.println("Proizvod polinoma p(x) i q(x) je prevelikog stepena.");
    
    // (b)
    Polinom r = new Polinom();
    Polinom tmp = new Polinom();
    
    tmp = izvod(p);
    r = PolinomN.oduzmi(q, tmp);
    PolinomN.anuliraj(tmp);
    
    tmp = PolinomN.brojPuta(p, 2.0);
    r = PolinomN.oduzmi(r, tmp);
    PolinomN.anuliraj(tmp);
    
    tmp.st = 2;
    tmp.k[0] = -4;
    tmp.k[2] = 3;
    r = PolinomN.saberi(r, tmp);
    PolinomN.anuliraj(tmp);
    
    System.out.print("r(x) = q(x) – p'(x) – 2p(x) + 3x^2 – 4 = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (c)
    tmp = PolinomN.kopiraj(r);
    odstraniNegativne(tmp);
    System.out.print("r(x) bez monoma sa neg. koef. = ");
    PolinomN.stampaj(tmp);
    PolinomN.anuliraj(tmp);
    System.out.println();
    
    // (d)
    stampajMonome(r);
  }
}
