/* Koristeci klase Polinom i PolinomN, napisati program koji:
 * a) ucitava polinome p(x) i q(x), stampa njihovu aritmeticku sredinu,
 * b) stampa polinom:
 *    r(x) = (q(x) + p(2)*x)^2 + 3(q(x) + p(2)*x) - 4x^3 - 1.
 * 
 * Napisati i testirati na polinomu r(x) metod koji:
 * c) obrce koeficijente polinoma r(x), tako da se r.k[0] zameni mesti-
 *    ma sa r.k[r.st], ...
 * d) racuna proizvod monoma sa najvecim i najmanjim koeficijentom. 
 */

class Dodatni10 {
  
  // (d) racuna proizvod monoma sa najvecim i najmanjim koeficijentom
  static Polinom proizvodMonoma(Polinom p) {
    if (p == null) return null;
    
    double min = p.k[0];
    int kMin = 0;
    double max = p.k[0];
    int kMax = 0;
    
    for (int i = 1; i <= p.st; i++) {
      if (p.k[i] < min) {
        kMin = i;
      }
      if (p.k[i] > max) {
        kMax = i;
      }
    }
    
    Polinom rez = new Polinom();
    rez.st = kMin * kMax;
    rez.k[kMin*kMax] = p.k[kMin] * p.k[kMax];
    
    return rez;
  }
  
  // (c) obrce koeficijente polinoma r(x)
  static void obrniKoef(Polinom p) {
    if (p == null) return;
    
    for (int i = 0; i <= p.st / 2; i++) {
      double t = p.k[i];
      p.k[i] = p.k[p.st-i];
      p.k[p.st-i] = t;
    }
    PolinomN.nadjiStepen(p);
  }
  
  
  public static void main(String[] args) {
    //System.out.println("5 / 2 = " + 5 / 2);
    //System.out.println("4 / 2 = " + 4 / 2);
    
    // (a) ucitava polinome p(x) i q(x) i stampa njihovu aritmeticku sredinu
    
    Polinom p = PolinomN.ucitaj();
    Polinom q = PolinomN.ucitaj();
    
    Polinom r = PolinomN.saberi(p, q);
    r = PolinomN.brojPuta(r, 0.5);
    
    System.out.println("(a) ucitava polinome p(x) i q(x) i stampa njihovu aritmeticku sredinu");
    
    System.out.print("p(x) = ");
    PolinomN.stampaj(p);
    System.out.println();
    
    System.out.print("q(x) = ");
    PolinomN.stampaj(q);
    System.out.println();
    
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println("\n");
    PolinomN.anuliraj(r);
    
    // (b) stampa polinom r(x) = (q(x) + p(2)*x)^2 + 3(q(x) + p(2)*x) - 4x^3 - 1
    System.out.println("(b) stampa polinom r(x) = (q(x) + p(2)*x)^2 + 3(q(x) + p(2)*x) - 4x^3 - 1");
    
    Polinom t = new Polinom();
    t.st = 1;
    t.k[1] = PolinomN.izracunaj(2.0, p);
    t = PolinomN.saberi(q, t);
    r = PolinomN.puta(t, t);
    r = PolinomN.saberi(r, PolinomN.brojPuta(t, 3.0));
    PolinomN.anuliraj(t);
    
    t.st = 3;
    t.k[3] = -4.0;
    t.k[0] = -1.0;
    r = PolinomN.saberi(r, t);
    PolinomN.anuliraj(t);
    
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println("\n");
    
    // (c) obrce koeficijente polinoma r(x)
    System.out.println("(c) obrce koeficijente polinoma r(x)");
    
    t = PolinomN.kopiraj(r);
    obrniKoef(t);
    
    System.out.print("r(x) = ");
    PolinomN.stampaj(t);
    System.out.println("\n");
    PolinomN.anuliraj(t);
    
    // (d) racuna proizvod monoma sa najvecim i najmanjim koeficijentom
    System.out.println("(d) racuna proizvod monoma sa najvecim i najmanjim koeficijentom");
    
    System.out.print("r(x) = ");
    PolinomN.stampaj(proizvodMonoma(r));
    System.out.println();
  }
}
