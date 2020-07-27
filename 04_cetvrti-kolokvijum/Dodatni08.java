/* Koristeci klase Polinom i PolinomN, napisati program koji:
 * a) ucitava polinome p(x) i q(x) i stampa njihov kolicnik,
 * b) stampa polinom r(x) = 5q^2(x)(2.5x^3 + x) - p(2) + 8.
 * 
 * Napisati i testirati na r(x) metodu koja:
 * c) dize na kvadrat koeficijente monoma ciji je stepen neparan broj,
 * d) deli polinom na dva polinoma: jedan koji sadrzi monome ciji su k-
 *    oeficijenti celobrojne vrednosti, i drugi ciji koeficijenti su t-
 *    akvi da nisu celobrojne vrednosti (ispis oba polinoma realizovat-
 *    i u main metodu; polinom sa kojim je pozvana metoda mora biti oc-
 *    uvan).   
 */

class Dodatni08 {
  
  // (d) deli polinom na dva polinoma...
  static Polinom[] deliPolinom(Polinom p) {
    if (p == null) 
      return null;
    
    // z - celobrojni, r - ostali;
    Polinom z = PolinomN.kopiraj(p);
    Polinom r = PolinomN.kopiraj(p);
    
    for (int i = 0; i <= p.st; i++) {
      if (p.k[i] == Math.round(p.k[i]))
        r.k[i] = 0;
      else
        z.k[i] = 0;
    }
    
    PolinomN.nadjiStepen(z);
    PolinomN.nadjiStepen(r);
    
    Polinom[] output = {z, r};
    
    return output;
  }
  
  // (c) dize na kvadrat koeficijente monoma ciji je stepen neparan broj
  static void koefNaKvadrat(Polinom p) {
    if (p == null) return;
    
    for (int i = 1; i <= p.st; i += 2) {
      p.k[i] = Math.pow(p.k[i], 2);
    }
  }
  
  public static void main(String[] args) {
    // (a) ucitava polinome p(x) i q(x) i stampa njihov kolicnik
    Polinom p = PolinomN.ucitaj();
    Polinom q = PolinomN.ucitaj();
    Polinom[] kolOst = PolinomN.deli(p, q);
    
    System.out.println("(a) ucitava polinome p(x) i q(x) i stampa njihov kolicnik");
    
    System.out.print("p(x) = ");
    PolinomN.stampaj(p);
    System.out.println();
    
    System.out.print("q(x) = ");
    PolinomN.stampaj(q);
    System.out.println();
    
    System.out.print("Kolicnik pri deljenju p(x) sa q(x): ");
    PolinomN.stampaj(kolOst[0]);
    System.out.println();
    
    // (b) stampa polinom r(x) = 5q^2(x)(2.5x^3 + x) - p(2) + 8
    Polinom t = new Polinom();
    Polinom r = new Polinom();
    
    t.st = 3;
    t.k[1] = 1.0;
    t.k[3] = 2.5;
    r = PolinomN.puta(q, q);
    r = PolinomN.brojPuta(r, 5.0);
    r = PolinomN.puta(r, t);
    r.k[0] = r.k[0] - PolinomN.izracunaj(2.0, p) + 8.0;
    PolinomN.anuliraj(t);
    
    System.out.println("(b) stampa polinom r(x) = 5q^2(x)(2.5x^3 + x) - p(2) + 8");
    
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (c) dize na kvadrat koeficijente monoma ciji je stepen neparan broj
    System.out.println("(c) dize na kvadrat koeficijente monoma ciji je stepen neparan broj");
    
    t = PolinomN.kopiraj(r);
    koefNaKvadrat(t);
    PolinomN.anuliraj(t);
    
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (d) deli polinom na dva polinoma...
    System.out.print("z(x) = ");
    PolinomN.stampaj(deliPolinom(r)[0]);
    System.out.println();
    
    System.out.print("r(x) = ");
    PolinomN.stampaj(deliPolinom(r)[1]);
    System.out.println();
  }
}
