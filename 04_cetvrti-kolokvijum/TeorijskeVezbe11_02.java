class TeorijskeVezbe11_02 {
  public static void main(String args[]) {
    int a, b, c;
    do {
      a = Svetovid.in.readInt("Unesite ceo broj A (A != 0): ");
      if (a == 0) System.out.println("Greska. Ponovite.");
    } while (a == 0);
    b = Svetovid.in.readInt("Unesite ceo broj B: ");
    c = Svetovid.in.readInt("Unesite ceo broj C: ");
    
    Polinom p = new Polinom();
    p.st = 2;
    p.k[2] = a;
    p.k[1] = b;
    p.k[0] = c;
    
    System.out.print("Unesen je polinom: ");
    PolinomN.stampaj(p);
    System.out.println();
    
    int n;
    do {
      n = Svetovid.in.readInt("Unesite broj na koji se stepenuje polinom: ");
      if (n <= 0) System.out.println("Greska. Ponovite.");
    } while (n <= 0);
    
    Polinom pNaN = new Polinom();
    pNaN.st = 0;
    pNaN.k[0] = 1;
    
    for (int i = 1; i <= n; i++) {
      pNaN = PolinomN.puta(p, pNaN);
    }
    
    Polinom q = new Polinom();
    Polinom r = new Polinom();
    
    q = new Polinom();
    r = new Polinom();
    for (int i = 0; i <= pNaN.st; i++) {
      if (i % 2 == 0)
        q.k[i / 2] = pNaN.k[i];
      else
        r.k[i / 2] = pNaN.k[i]; 
    }
    
    PolinomN.nadjiStepen(q); 
    PolinomN.nadjiStepen(r);
    
    System.out.print("pNaN(x) = "); 
    PolinomN.stampaj(pNaN);
    System.out.println();
    
    System.out.print("q(x) = "); 
    PolinomN.stampaj(q);
    System.out.println();
    
    System.out.print("r(x) = "); 
    PolinomN.stampaj(r); 
    System.out.println();
  }
}
