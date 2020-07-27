/* Koristeci klase Polinom i PolinomN, napisati program koji:
 * a) ucitava polinome p(x) i q(x) i stampa njihovu razliku,
 * b) stampa polinom r(x) = p(x)/q(x) + p(x)^2 - 4q(x) + x^3 + 7.
 * 
 * Napisati i testirati na polinomu r(x) metod koji:
 * c) vraca "kompresovani" polinom t(x) za koji vazi
 *    t.k[0] = r.k[0] + r.k[1]
 *    t.k[1] = r.k[2] + r.k[3]
 *    ...
 *    ukoliko je stepen polinoma r(x) veci od 1. U suprotnom, vraca taj
 *    isti polinom;
 * d) izbacuje sve monome ciji je koeficijent manji od apsolutne vredn-
 *    osti razlike koeficijenata uz najveci i najmanji stepen polinoma. 
 */

class Dodatni12 {
  
  // (d)
  static void izbaciMonome(Polinom p) {
    if (p == null) return;
    
    double check = Math.abs(p.k[0] - p.k[p.st]);
    
    for (int i = 0; i <= p.st; i++) {
      if (p.k[i] < check)
        p.k[i] = 0.0;
    }
    PolinomN.nadjiStepen(p);
  }
  
  // (c)
  static Polinom kompresuj(Polinom p) {
    if (p == null) return null;
    
    if (p.st > 1) {
      Polinom t = new Polinom();
      t.st = p.st / 2;
      
      int j = 0;
      
      for (int i = 0; i <= p.st / 2; i++) {
        t.k[i] = p.k[j] * p.k[j+1];
        j += 2;
      }
      return t;
    }
    else
      return p;
  }
  
  public static void main(String[] args) {
    // (a) ucitava polinome p(x) i q(x) i stampa njihovu razliku
    Polinom p = PolinomN.ucitaj();
    Polinom q = PolinomN.ucitaj();
    
    Polinom r = PolinomN.oduzmi(p, q);
    
    System.out.println("(a) ucitava polinome p(x) i q(x) i stampa njihovu razliku");
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println("\n");
    PolinomN.anuliraj(r);
    
    // (b) stampa polinom r(x) = p(x)/q(x) + p(x)^2 - 4q(x) + x^3 + 7
    System.out.println("(b) stampa polinom r(x) = p(x)/q(x) + p(x)^2 - 4q(x) + x^3 + 7");
    
    r = PolinomN.deli(p, q)[0];
    Polinom t = PolinomN.puta(p, p);
    r = PolinomN.saberi(r, t);
    PolinomN.anuliraj(t);
    
    t = PolinomN.brojPuta(q, 4);
    r = PolinomN.oduzmi(r, t);
    PolinomN.anuliraj(t);
    
    t.st = 3;
    t.k[0] = 7.0;
    t.k[3] = 1.0;
    r = PolinomN.saberi(r, t);
    PolinomN.anuliraj(t);
    
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println("\n");
    
    // (c) vraca "kompresovani" polinom t(x)
    System.out.println("(c) vraca 'kompresovani' polinom t(x)");
    
    t = kompresuj(r);
    System.out.print("t(x) = ");
    PolinomN.stampaj(t);
    System.out.println("\n");
    PolinomN.anuliraj(t);
    
    // (d) izbacuje sve monome ciji je koeficijent manji od apsolutne vrednosti razlike koeficijenata uz najveci i najmanji stepen polinoma
    System.out.println("(d) izbacuje sve monome ciji je koeficijent...");
    izbaciMonome(r);
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
  }
}
