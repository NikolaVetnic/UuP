/* Koristeci klase Polinom i PolinomN, napisati program koji:
 * a) ucitava polinome p(x) i q(x) i stampa njihov zbir,
 * b) stampa polinom r(x) = q(x)*p(x) - 4p(x) - x^3 + 2x - 5.
 * 
 * Napisati i testirati na r(x) metod koji:
 * c) vraca koliko polinom ima monoma sa ne-nula koeficijentom ciji st-
 *    epen pri deljenju sa 3 daje ostatak k, pri cemu je k parametar m-
 *    etoda (unos vrednosti za parametar realizovati u main metodi). 
 * d) deli polinom na tri polinoma: prvi sadrzi monome ciji su koefici-
 *    jenti negativni, drugi monome ciji su koeficijenti pozitivni i m-
 *    anji od 10 i treci sve ostale monome (ispis dobijenih polinoma r-
 *    ealizovati u main metodi; polinom sa kojim je pozvana metoda mora
 *    biti ocuvan). 
 */

class Dodatni09 {
  
  // (d) deli polinom na tri polinoma
  static Polinom[] podeliPolinom(Polinom p) {
    if (p == null) return null;
    
    // koef. pozitivni i >= 10
    Polinom a = PolinomN.kopiraj(p);
    // koef. pozitivni i < 10
    Polinom b = PolinomN.kopiraj(p);
    // koef. negativni
    Polinom c = PolinomN.kopiraj(p);
    
    for (int i = 0; i <= p.st; i++) {
      if (p.k[i] >= 0) {
        if (p.k[i] >= 10) {
          // a(x), koef. pozitivni i >= 10
          b.k[i] = 0;
          c.k[i] = 0;
        }
        else {
          // b(x), koef. pozitivni i < 10
          a.k[i] = 0;
          c.k[i] = 0;
        }
      }
      else {
        // c(x), koef. negativni
        a.k[i] = 0;
        b.k[i] = 0;
      }
    }
    PolinomN.nadjiStepen(a);
    PolinomN.nadjiStepen(b);
    PolinomN.nadjiStepen(c);
    
    Polinom[] output = {a, b, c};
    
    return output;
  }
  
  // (c) vraca koliko polinom ima monoma sa ne-nula...
  static int kolikoIma(Polinom p, int k) {
    if (p == null) return -1;
    
    int count = 0;
    
    for (int i = 0; i <= p.st; i++) {
      if (p.k[i] != 0) {
        if (i % 3 == k)
          count++;
      }
    }
    return count;
  }
  
  public static void main(String[] args) {
    // (a) ucitava polinome p(x) i q(x) i stampa njihov zbir
    Polinom p = PolinomN.ucitaj();
    Polinom q = PolinomN.ucitaj();
    
    System.out.println("(a) ucitava polinome p(x) i q(x) i stampa njihov zbir");
    System.out.print("p(x) + q(x) = ");
    PolinomN.stampaj(PolinomN.saberi(p, q));
    System.out.println();
    
    // (b) stampa polinom r(x) = q(x)*p(x) - 4p(x) - x^3 + 2x - 5
    Polinom t = new Polinom();
    Polinom r = new Polinom();
    
    t = PolinomN.brojPuta(p, 4.0);
    r = PolinomN.puta(p, q);
    r = PolinomN.oduzmi(r, t);
    PolinomN.anuliraj(t);
    
    t.st = 3;
    t.k[0] = -5.0;
    t.k[1] = 2.0;
    t.k[3] = -1.0;
    r = PolinomN.saberi(r, t);
    PolinomN.anuliraj(t);
    
    System.out.println("(b) stampa polinom r(x) = q(x)*p(x) - 4p(x) - x^3 + 2x - 5");
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (c) vraca koliko polinom ima monoma sa ne-nula...
    System.out.println("(c) vraca koliko polinom ima monoma sa ne-nula...");
    
    int k = Svetovid.in.readInt("Unesite k: ");
    k = k % 3;
    System.out.println("Monoma ima: " + kolikoIma(r, k));
    
    // (d) deli polinom na tri polinoma...
    System.out.println("(d) deli polinom na tri polinoma...");
    
    Polinom[] podeljenPolinom = podeliPolinom(r);
    
    System.out.print("a(x) = ");
    PolinomN.stampaj(podeljenPolinom[0]);
    System.out.println();
    
    System.out.print("b(x) = ");
    PolinomN.stampaj(podeljenPolinom[1]);
    System.out.println();
    
    System.out.print("c(x) = ");
    PolinomN.stampaj(podeljenPolinom[2]);
    System.out.println();
    
  }
}
