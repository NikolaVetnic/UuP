/* Koristeci klase Polinom i PolinomN, napisati program koji:
 * a) ucitava polinome p(x) i q(x) i stampa njihovu razliku,
 * b) stampa polinom r(x) = q'(1)q(x) - p(x)(x^2 - 3) + 2x^4 + 5x^3.
 * 
 * Napisati i testirati na polinomu r(x) metod koji:
 * c) odstranjuje iz polinoma sve monome sa parnim stepenom,
 * d) stampa sve nenula monome (svaki u novom redu) ciji se koeficijent
 *    i stepen razlikuju za najvise 5. 
 */

class Dodatni04 {
  
  static Polinom izvod(Polinom p) {
    if (p == null)
      return null;
    
    Polinom rez = new Polinom();
    rez.st = p.st - 1;
    
    if (p.st > 0) {
      for (int i = 0; i <= rez.st; i++) {
        rez.k[i] = p.k[i+1] * (i+1);
      }
    }
    return rez;
  }
  
  // (c)
  static void odstraniMonome(Polinom p) {
    if (p == null) return;
    
    for (int i = 0; i <= p.st; i++) {
      if (i % 2 == 0)
        p.k[i] = 0.0;
    }
    PolinomN.nadjiStepen(p);
  }
  
  // (d)
  static void stampajMonome(Polinom p) {
    if (p == null) return;
    
    Polinom rez = new Polinom();
    
    if (p.st > -1) {
      for (int i = 0; i <= p.st; i++) {
        if (Math.abs(p.k[i] - i) <= 5) {
          rez.st = i;
          rez.k[i] = p.k[i];
          System.out.print("rez(x) = ");
          PolinomN.stampaj(rez);
          System.out.println();
          PolinomN.anuliraj(rez);
        }
      }
    }
  }
  
  public static void main(String[] args) {
    // (a)
    Polinom p = PolinomN.ucitaj();
    Polinom q = PolinomN.ucitaj();
    
    System.out.println("a) Ucitani polinomi p(x) i q(x): ");
    System.out.print("p(x) = ");
    PolinomN.stampaj(p);
    System.out.println();
    
    System.out.print("q(x) = ");
    PolinomN.stampaj(q);
    System.out.println();
    
    // (b), r(x) = q'(1)q(x) - p(x)(x^2 - 3) + 2x^4 + 5x^3
    Polinom r = new Polinom();
    Polinom t = new Polinom();
    
    t = izvod(q);
    r = PolinomN.puta(t, q);
    PolinomN.anuliraj(t);
    
    t.st = 2;
    t.k[0] = -3.0;
    t.k[2] = 1.0;
    t = PolinomN.puta(p, t);
    r = PolinomN.oduzmi(r, t);
    PolinomN.anuliraj(t);
    
    t.st = 4;
    t.k[3] = 5.0;
    t.k[4] = 2.0;
    r = PolinomN.saberi(r, t);
    PolinomN.anuliraj(t);
    
    System.out.println("b) rezultantni polinom: ");
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (c)
    t = PolinomN.kopiraj(r);
    odstraniMonome(t);
    System.out.println("c) t(x) sa odstranjenim svim monomima sa parnim stepenom: ");
    System.out.print("t(x) = ");
    PolinomN.stampaj(t);
    System.out.println();
    PolinomN.anuliraj(t);
    
    // (d)
    System.out.println("d) Monomi iz r(x) ciji se koeficijent i stepen razlikuju za najvise 5: ");
    stampajMonome(r);
  }
}
