/* Koristeci klase Polinom i PolinomN, napisati program koji:
 * a) ucitava polinome p(x) i q(x) i stampa njihov proizvod,
 * b) stampa polinom r(x) = q(-2)(x^6 + 3x^4 + 7) + (2x^5)*p(x).
 * 
 * Napisati i testirati na r(x) metod koji:
 * c) dize na kub negativne koeficijente monoma u polinomu,
 * d) iz polinoma izbacuje prvih k monoma parnog stepena sa ne-nula ko-
 *    eficijentima (gledano od monoma sa najmanjim stepenom), gde je p-
 *    arametar k metoda (unos vrednosti za parametar realizovati u main
 *    metodi).  
 */

class Dodatni07 {
  
  // (d)
  static Polinom izbaciMonome(Polinom p, int k) {
    if (p == null) 
      return null;
    
    Polinom rez = new Polinom();
    int count = 0;
    boolean check = false;
    
    for (int i = 0; i <= p.st; i++) {
      if (i % 2 == 0 && count <= k) {
        rez.k[i] = 0.0;
        count++;
      }
      else
        rez.k[i] = p.k[i];
    }
    PolinomN.nadjiStepen(rez);
    return rez;
  }
  
  // (c)
  static void koefNaKub(Polinom p) {
    if (p == null) return;
    
    for (int i = 0; i <= p.st; i++) {
      if (p.k[i] < 0)
        p.k[i] = Math.pow(p.k[i], 3);
    }
  }
  
  public static void main(String[] args) {
    // (a) ucitava polinome p(x) i q(x) i stampa njihov proizvod
    Polinom p = PolinomN.ucitaj();
    Polinom q = PolinomN.ucitaj();
    Polinom r = PolinomN.puta(p, q);
    
    System.out.println("(a) ucitava polinome p(x) i q(x) i stampa njihov proizvod");
    
    System.out.print("p(x) = ");
    PolinomN.stampaj(p);
    System.out.println();
    
    System.out.print("q(x) = ");
    PolinomN.stampaj(q);
    System.out.println();
    
    System.out.print("p(x) * q(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    PolinomN.anuliraj(r);
    
    // (b) stampa polinom r(x) = q(-2)(x^6 + 3x^4 + 7) + (2x^5)*p(x)
    Polinom t = new Polinom();
    t.st = 6;
    t.k[0] = 7.0;
    t.k[4] = 3.0;
    t.k[6] = 1.0;
    r = PolinomN.brojPuta(t, PolinomN.izracunaj(-2.0, q));
    PolinomN.anuliraj(t);
    
    t.st = 5;
    t.k[5] = 2.0;
    t = PolinomN.puta(r, p);
    r = PolinomN.saberi(r, t);
    PolinomN.anuliraj(t);
    
    System.out.println("(b) stampa polinom r(x) = q(-2)(x^6 + 3x^4 + 7) + (2x^5)*p(x)");
    
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (c) dize na kub negativne koeficijente monoma u polinomu
    System.out.println("(c) dize na kub negativne koeficijente monoma u polinomu");
    
    t = PolinomN.kopiraj(r);
    koefNaKub(t);
    
    System.out.print("rezultat = ");
    PolinomN.stampaj(t);
    System.out.println();
    
    PolinomN.anuliraj(t);
    
    // (d) iz polinoma izbacuje prvih k monoma parnog stepena sa ne-nula koeficijentima
    System.out.println("(d) iz polinoma izbacuje prvih k monoma parnog stepena sa ne-nula koeficijentima");
    
    int k = Svetovid.in.readInt("Unesite k: ");
    t = izbaciMonome(r, k);
    
    System.out.print("rezultat = ");
    PolinomN.stampaj(t);
    System.out.println();
  }
}
