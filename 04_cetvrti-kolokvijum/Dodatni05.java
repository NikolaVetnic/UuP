/* Koristeci klase Polinom i PolinomN, napisati program koji:
 * a) ucitava polinome p(x) i q(x) i stampa njihov proizvod,
 * b) stampa polinom r(x) = (p(x) + 3x^2 + 2x)(2x^3 + q(3)).
 * 
 * Napisati i testirati na polinomu r(x) metod koji:
 * c) odstranjuje iz polinoma monome ciji su koeficijenti kvadrati cel-
 *    og broja,
 * d) proverava da li su koeficijenti monoma poredjani u opadajucem re-
 *    dosledu, gledano od monoma najveceg stepena. 
 */

class Dodatni05 {
  
  // (c)
  static void odstraniMonome(Polinom p) {
    if (p == null) return;
    
    for (int i = 0; i <= p.st; i++) {
      double k = p.k[i];
      int l = (int)Math.sqrt(k);
      if (k == Math.pow(l, 2))
        p.k[i] = 0;
    }
    PolinomN.nadjiStepen(p);
  }
  
  // (d)
  static boolean proveriKoef(Polinom p) {
    for (int i = p.st; i >= 1; i--) {
      if (p.k[i] <= p.k[i-1])
        return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    // (a) ucitava polinome p(x) i q(x) i stampa njihov proizvod
    Polinom p = PolinomN.ucitaj();
    Polinom q = PolinomN.ucitaj();
    
    System.out.println("(a) ucitava polinome p(x) i q(x) i stampa njihov proizvod");
    
    System.out.print("p(x) = ");
    PolinomN.stampaj(p);
    System.out.println();
    
    System.out.print("q(x) = ");
    PolinomN.stampaj(p);
    System.out.println();
    
    // (b) stampa polinom r(x) = (p(x) + 3x^2 + 2x)(2x^3 + q(3))
    Polinom t = new Polinom();
    Polinom r = new Polinom();
    
    t.st = 2;
    t.k[1] = 2.0;
    t.k[2] = 3.0;
    r = PolinomN.saberi(p, t);
    PolinomN.anuliraj(t);
    
    t.st = 3;
    t.k[3] = 2.0;
    t.k[0] = PolinomN.izracunaj(3.0, q);
    r = PolinomN.puta(r, t);
    PolinomN.anuliraj(t);
    
    System.out.println("(b) stampa polinom r(x) = (p(x) + 3x^2 + 2x)(2x^3 + q(3))");
    
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (c) odstranjuje iz polinoma sve monome ciji su koeficijenti kvadrati celog broja
    System.out.println("(c) odstranjuje iz polonoma sve monome ciji su koeficijenti kvadrati celog broja");
    
    odstraniMonome(r);
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (d) proverava da li su koeficijenti monoma poredjani u opadajucem redosledu, gledano od monoma najveceg stepena.
    System.out.println("(d) proverava da li su koeficijenti monoma poredjani u opadajucem redosledu, gledano od monoma najveceg stepena.");
    
    if (proveriKoef(r))
      System.out.println("Koeficijenti monoma JESU poredjani u opadajucem redosledu, gledano od monoma najveceg stepena.");
    else
      System.out.println("Koeficijenti monoma NISU poredjani u opadajucem redosledu, gledano od monoma najveceg stepena.");
  }
}
