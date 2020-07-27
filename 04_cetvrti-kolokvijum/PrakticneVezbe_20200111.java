class PrakticneVezbe_20200111 {
  
  static Polinom uvecaj(Polinom r) {
    for (int i = 0; i <= r.st; i++) {
      if (r.k[i] > 0)
        r.k[i]++;
    }
    return r;
  }
  
  static Polinom najmanjiKoef(Polinom r) {
    int min = 0;
    
    for (int i = 0; i <= r.st; i++) {
      if (r.k[i] < r.k[min])
        min = i;
    }
    
    Polinom rez = new Polinom();
    rez.st = min;
    rez.k[min] = r.k[min];
    
    return rez;
  }
  
  public static void main(String[] args) {
    Polinom p = PolinomN.ucitaj();
    System.out.print("p(x) = ");
    PolinomN.stampaj(p);
    System.out.println();
    
    Polinom q = PolinomN.ucitaj();
    System.out.print("q(x) = ");
    PolinomN.stampaj(q);
    System.out.println();
    
    // (a)
    Polinom zbir = new Polinom();
    zbir.st = 0;
    zbir.k[0] = 0;
    
    if (p != null && q != null)
      zbir = PolinomN.saberi(p, q);
    else
      System.out.println("Jedan od sabiraka je null.");
    
    System.out.print("zbir(x) = ");
    PolinomN.stampaj(zbir);
    System.out.println();
    
    // (b)
    Polinom r = new Polinom();
    r.st = 0;
    r.k[0] = 0;
    
    Polinom pom2 = PolinomN.brojPuta(p, 3);
    
    Polinom pom3 = new Polinom();
    pom3.st = 4;
    pom3.k[4] = 2;
    pom3.k[1] = 3;
    
    r = PolinomN.oduzmi(q, pom2);
    r = PolinomN.saberi(r, pom3);
    
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (c)
    System.out.print("r(x) = ");
    PolinomN.stampaj(uvecaj(r));
    System.out.println();
    
    // (d)
    System.out.print("monom = ");
    PolinomN.stampaj(najmanjiKoef(p));
    System.out.println();
    
  }
}
