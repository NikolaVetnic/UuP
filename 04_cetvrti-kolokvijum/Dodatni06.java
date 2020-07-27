/* Koristeci klase Polinom i PolinomN, napisati program koji:
 * a) ucitava polinome p(x) i q(x) i stampa ostatak pri deljenju ta dva
 *    polinoma,
 * b) stampa r(x) = p(0)(3 - 2x^2 + x^3) - (x^2 - 3x - 5x^3)q(x)
 * 
 * Napisati i testirati na polinomu r(x) metod koji:
 * c) nalazi aritmeticku sredinu koeficijenata monoma parnog stepena sa
 *    strogo pozitivnim koeficijentima (ako aritmenticka sredina ne po-
 *    stoji metod kao rezultat vrati -1),
 * d) broji koliko ima monoma sa ne-nula koeficijentima kod kojih je k-
 *    oeficijent veci nego koeficijent sledbenika (monom B je sledbenik
 *    monoma A takav da je B prvi monom sa ne-nula koeficijentom, a ci-
 *    ji je stepen veci od stepena monoma A). 
 */

class Dodatni06 {
  
  // (d)
  static int prebrojMonome(Polinom p) {
    if (p == null) return -1;
    
    int count = 0;
    
    for (int i = 0; i < p.st; i++) {
      if (p.k[i] != 0) {
        double koef1 = p.k[i];
        double koef2 = 0.0;
        
        int j = i + 1;
        do {
          if (p.k[j] != 0) {
            koef2 = p.k[j];
          }
          else
            koef2 = 0.0;
          j++;
        } while (koef2 == 0.0);
        
        if (koef1 > koef2)
          count++;
      }
    }
    return count;
  }
  
  // (c)
  static double aritmetickaSredina(Polinom p) {
    if (p == null) return -1.0;
    
    if (p.st > -1) {
      double sum = 0.0;
      int count = 0;
      
      for (int i = 0; i <= p.st; i += 2) {
        if (p.k[i] > 0) {
          sum += p.k[i];
          count++;
        }
      }
      return sum / count;
    }
    else
      return -1.0;
  }
  
  public static void main(String[] args) {
    // (a) ucitava polinome p(x) i q(x) i stampa ostatak pri deljenju ta dva polinoma
    Polinom p = PolinomN.ucitaj();
    Polinom q = PolinomN.ucitaj();
    
    System.out.println("(a) ucitava polinome p(x) i q(x) i stampa ostatak pri deljenju ta dva polinoma");
    
    System.out.print("p(x) = ");
    PolinomN.stampaj(p);
    System.out.println();
    
    System.out.print("q(x) = ");
    PolinomN.stampaj(q);
    System.out.println();
    
    Polinom[] kolOst = PolinomN.deli(p, q);
    System.out.print("Ostatak pri deljenju p(x) sa q(x): ");
    PolinomN.stampaj(kolOst[1]);
    System.out.println();
    
    // (b) stampa polinom r(x) = p(0)(3 - 2x^2 + x^3) - (x^2 - 3x - 5x^3)q(x)
    Polinom t = new Polinom();
    Polinom r = new Polinom();
    
    t.st = 3;
    t.k[0] = 3.0;
    t.k[2] = -2.0;
    t.k[3] = 1.0;
    r = PolinomN.brojPuta(t, PolinomN.izracunaj(0.0, p));
    PolinomN.anuliraj(t);
    
    t.st = 3;
    t.k[1] = -3.0;
    t.k[2] = 1.0;
    t.k[3] = -5.0;
    t = PolinomN.puta(t, q);
    r = PolinomN.oduzmi(r, t);
    
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (c) nalazi aritmeticku sredinu koeficijenata monoma parnog stepena sa strogo pozitivnim koeficijentima 
    //     (ako aritmenticka sredina ne postoji metod kao rezultat vrati -1)
    System.out.println("Aritmeticka sredina koeficijenata monoma parnog stepena sa strogo poz. koef.: " + aritmetickaSredina(r));
    
    // (d) broji koliko ima monoma sa ne-nula koeficijentima kod kojih je koeficijent veci nego koeficijent sledbenika  
    //     (sledbenik monoma A je monom B takav da je B prvi monom sa ne-nula koeficijentom ciji je stepen veci od stepena monoma A). 
    System.out.println("Broj monoma sa ne-nula koef. kod kojih je koef. veci nego koef. sledbenika: " + prebrojMonome(r));
  }
}
