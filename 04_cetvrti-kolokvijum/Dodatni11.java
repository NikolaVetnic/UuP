/* Koristeci klase Polinom i PolinomN, napisati program koji:
 * a) kreira polinom r(x) koji odgovara razvoju funkcije sin(x) u Tejl-
 *    orov red:
 *    sin(x) ~ x - x^3/3! + x^5/5! i x^7/7! +...+ x^(2n+1)/(2n+1)!, 
 *        n <= 10;
 * b) za unetu vrednost broja x iz intervala [-1..1], izracunati razli-
 *    ku izmedju p(x) i Math.sin(x).
 * 
 * Napisati i testirati na polinomu r(x) metod koji:
 * c) izracunava vrednost odredjenog integrala na intervalu [0.5, 0.7],
 * d) brise sve koeficijente koji su po apsolutnoj vrednoti manji od v-
 *    rednosti 0.00001.
 * 
 * (Program moze lepo da se testira za n = 5 i x = 0.5.) 
 */

class Dodatni4_11_1 {
  
  // (d)
  static void brisiKoef(Polinom p) {
    if (p == null) return;
    
    for (int i = 1; i <= p.st; i += 2) {
      if (Math.abs(p.k[i]) < 0.00001)
        p.k[i] = 0;
    }
    PolinomN.nadjiStepen(p);
  }
  
  // (c)
  static void integral(Polinom p) {
    if (p == null) return;
    
    for (int i = p.st; i >= 1; i -= 2) {
      p.k[i+1] = p.k[i] * (1.0 / (i + 1));
      p.k[i] = 0;
    }
    PolinomN.nadjiStepen(p);
  }
  
  static int fact(int n) {
    if (n == 1)
      return 1;
    else
      return n * fact(n - 1);
  }
  
  public static void main(String[] args) {
    
    // (a) kreira polinom r(x) koji odgovara razvoju funkcije sin(x) u Tejlorov red
    System.out.println("(a) kreira polinom r(x) koji odgovara razvoju funkcije sin(x) u Tejlorov red");
    
    int n = Svetovid.in.readInt("Unesite prirodan broj: ");
    
    Polinom p = new Polinom();
    p.st = 2 * n - 1;
    for (int i = 0; i < n; i++) {
      System.out.println("Cycle: " + i);
      p.k[2*i+1] = Math.pow(-1, i) * 1.0 / fact(2*i+1);
      System.out.println("p.k[" + (2*i+1) + "] = " + p.k[2*i+1]);
    }
    
    System.out.print("p(x) = ");
    PolinomN.stampaj(p);
    System.out.println("\n");
    
    // (b) za unetu vrednost broja x iz intervala [-1..1], izracunati razliku izmedju p(x) i Math.sin(x)
    System.out.println("(b) za unetu vrednost broja x iz intervala [-1..1], izracunati razliku izmedju p(x) i Math.sin(x)");
    
    double x = Svetovid.in.readDouble("Unesite broj u opsegu [-1..1]: ");
    System.out.println("Razlika je: " + Math.abs(PolinomN.izracunaj(x, p) - Math.sin(x)) + "\n");
    
    // (c) izracunava vrednost odredjenog integrala na intervalu [0.5, 0.7]
    Polinom integrateP = PolinomN.kopiraj(p);
    integral(integrateP);
    System.out.print("Resenje je: " + (PolinomN.izracunaj(0.7, integrateP) - PolinomN.izracunaj(0.5, integrateP)) + "\n");
    
    // (d) brise sve koeficijente koji su po apsolutnoj vrednoti manji od 0.00001
    brisiKoef(p);
    System.out.print("p(x) = ");
    PolinomN.stampaj(p);
    System.out.println("\n");
    
  }
}
