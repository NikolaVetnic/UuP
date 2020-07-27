class PolyDivision {
  
  static Polinom[] deljenje(Polinom p, Polinom q) {
    if (p == null || q == null || q.st == -1)
      return null;
    
    Polinom kol = new Polinom();
    kol.st = p.st - q.st;
    
    Polinom ost = PolinomN.kopiraj(p);
    
    for (int i = kol.st; i >= 0; i--) {
      kol.k[i] = ost.k[i + q.st] / q.k[q.st];
      ost = PolinomN.oduzmi(ost, PolinomN.puta(kol, q));
      System.out.println();
    }
    PolinomN.anuliraj(ost);
    ost = PolinomN.oduzmi(p, PolinomN.puta(kol, q));
    
    Polinom[] output = {kol, ost};
    return output;
  }
  
  
  public static void main(String[] args) {
    Polinom p = new Polinom();
    p = PolinomN.ucitaj();
    
    Polinom q = new Polinom();
    q = PolinomN.ucitaj();
    
    Polinom[] output = PolinomN.deli(p, q);
    PolinomN.stampaj(output[0]);
    System.out.println();
    PolinomN.stampaj(output[1]);
    System.out.println();
    
    output = deljenje(p, q);
    PolinomN.stampaj(output[0]);
    System.out.println();
    PolinomN.stampaj(output[1]);
    System.out.println();
  }
}
