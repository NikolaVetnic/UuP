class Kolokvijum4_01 {
  
  // (d)
  static Polinom[] podeliPolinom(Polinom p) {
    if (p == null) return null;
    
    // p(x) - prvi zahtev, q(x) - drugi zahtev
    Polinom q = PolinomN.kopiraj(p);
    
    System.out.println("\nPocetak");
    
    for (int i = 0; i <= p.st; i++) {
      if (i == 1 || i == 3 || i == 9 || i == 27 || i == 81)
        q.k[i] = 0.0;
      else
        p.k[i] = 0.0;
    }
    PolinomN.nadjiStepen(p);
    PolinomN.nadjiStepen(q);
    
    Polinom[] output = {p, q};
    
    return output;
  }
  
  // (c)
  static void prebrojMonome(Polinom p) {
    if (p == null) return;
    
    int count = 0;
    
    for (int i = 0; i <= p.st; i++) {
      if (i % 2 == 1 && p.k[i] < 0)
        count++;
    }
    
    System.out.println("Monoma neparnog stepena sa strogo negativnim koef. ima: " + count);
  }
  
  public static void main(String[] args) {
    // (a)
    Polinom p = PolinomN.ucitaj();
    Polinom q = PolinomN.ucitaj();
    
    System.out.print("p(x) * q(x) = ");
    PolinomN.stampaj(PolinomN.puta(p, q));
    System.out.println("\n");
    
    // (b)
    Polinom t = new Polinom();
    t.st = 7;
    t.k[1] = 14.0;
    t.k[7] = 2.0;
    Polinom r = new Polinom();
    r.st = 4;
    r.k[0] = 6.3;
    r.k[4] = -1.0;
    r = PolinomN.puta(r, t);
    PolinomN.anuliraj(t);
    
    t = PolinomN.brojPuta(p, 2*PolinomN.izracunaj(-1, q));
    r = PolinomN.oduzmi(r, t);
    PolinomN.anuliraj(t);
    
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println("\n");
    
    // (c)
    prebrojMonome(r);
    
    // (d)
    Polinom[] out = podeliPolinom(r);
    
    System.out.print("Polinom koji sadrzi monome sa stepenom koji je stepen od 3: ");
    PolinomN.stampaj(out[0]);
    System.out.println();
    
    System.out.print("Onaj drugi: ");
    PolinomN.stampaj(out[1]);
    System.out.println("\n");
  }
}
