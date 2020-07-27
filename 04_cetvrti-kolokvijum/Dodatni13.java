/* Koristeci klase Polinom i PolinomN, napisati program koji:
 * a) ucitava polinome p(x) i q(x) i stampa polinom cija je suma koefi-
 *    cijenata veca (u slucaju da su sume jednake stampa polinom p(x)),
 * b) stampa polinom r(x) = p(x)*q(x) - q(x)^3 - 4q(x) + x^4 -3x^3 + 12
 * 
 * Napisati i testirati na polinomu r(x) metod koji:
 * c) sve koeficijente monoma parnog stepena mnozi sa 2, a sve koefici-
 *    jente monoma neparnog stepena sabira sa 5,
 * d) mnozi polinom polinomom x, monom nultog stepena novog polinoma p-
 *    ostaje aritmeticka sredina svih ostalih koeficijenata. 
 */

class Dodatni13 {
  
  // (d)
  static Polinom transformisi(Polinom p) {
    if (p == null) 
      return null;
    
    Polinom rez = new Polinom();
    rez.st = p.st + 1;
    
    double sum = 0.0;
    
    for (int i = 0; i <= p.st; i++) {
      rez.k[i+1] = p.k[i];
      sum += p.k[i];
    }
    
    rez.k[0] = sum / (p.st + 1);
    
    return rez;
  }
  
  // (c)
  static void drndajMonome(Polinom p) {
    if (p == null) return;
    
    for (int i = 0; i <= p.st; i++) {
      if (i % 2 == 0)
        p.k[i] *= 2.0;
      else
        p.k[i] += 5.0;
    }
  }
  
  public static void main(String[] args) {
    // (a) ucitava polinome p(x) i q(x) i stampa polinom cija je suma koeficijenata veca
    Polinom p = PolinomN.ucitaj();
    Polinom q = PolinomN.ucitaj();
    
    double sum1 = 0.0, sum2 = 0.0;
    
    for (int i = 0; i <= p.st; i++)
      sum1 += p.k[i];
    
    for (int i = 0; i <= q.st; i++)
      sum2 += q.k[i];
    
    System.out.println("(a) ucitava polinome p(x) i q(x) i stampa polinom cija je suma koeficijenata veca");
    
    if (sum1 > sum2) {
      System.out.print("Polinom p(x) ima vecu sumu koeficijenata: ");
      PolinomN.stampaj(p);
    }
    else if (sum2 > sum1) {
      System.out.print("Polinom q(x) ima vecu sumu koeficijenata: ");
      PolinomN.stampaj(q);
    }
    else {
      System.out.print("Polinomi imaju jednaku sumu koeficijenata pa se zato stampa p(x): ");
      PolinomN.stampaj(p);
    }
    System.out.println("\n");
    
    // (b) stampa polinom r(x) = p(x)*q(x) - q(x)^3 - 4q(x) + x^4 -3x^3 + 12
    System.out.println("(b) stampa polinom r(x) = p(x)*q(x) - q(x)^3 - 4q(x) + x^4 -3x^3 + 12");
    
    Polinom r = PolinomN.puta(p, q);
    
    Polinom t = PolinomN.puta(q, q);
    t = PolinomN.puta(t, q);
    r = PolinomN.oduzmi(r, t);
    PolinomN.anuliraj(t);
    
    t = PolinomN.brojPuta(q, 4.0);
    r = PolinomN.oduzmi(r, t);
    PolinomN.anuliraj(t);
    
    t.st = 4;
    t.k[0] = 12.0;
    t.k[3] = -3.0;
    t.k[4] = 1.0;
    PolinomN.saberi(r, t);
    PolinomN.anuliraj(t);
    
    System.out.println("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println("\n");
    
    // (c) sve koeficijente monoma parnog stepena mnozi sa 2, a sve koeficijente monoma neparnog stepena sabira sa 5
    System.out.println("(c) sve koeficijente monoma parnog stepena mnozi sa 2, a sve koeficijente monoma neparnog stepena sabira sa 5");
    
    t = PolinomN.kopiraj(r);
    drndajMonome(t);
    
    System.out.println("t(x) = ");
    PolinomN.stampaj(t);
    PolinomN.anuliraj(t);
    System.out.println("\n");
    
    // (d) mnozi polinom polinomom x, a monom nultog stepena novog polinoma postaje aritmeticka sredina svih ostalih koeficijenata
    System.out.println("d) mnozi polinom polinomom x, a monom nultog stepena novog polinoma postaje aritmeticka sredina svih ostalih koeficijenata");
    
    t = transformisi(r);
    System.out.println("t(x) = ");
    PolinomN.stampaj(t);
    System.out.println("\n");
  }
}
