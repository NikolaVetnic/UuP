class PrakticneVezbe_20200109 {
  
  static Polinom izvod(Polinom p) {
    if (p == null)
      return null;
    
    Polinom rez = new Polinom();
    
    if (p.st > 0) {
      rez.st = p.st - 1;
      for (int i = 0; i <= rez.st; i++) {
        rez.k[i] = p.k[i+1] * (i+1);
      }
    }
    return rez;
  }
  
  static Polinom kompozicija(Polinom a, Polinom b) {
    if (a == null || b == null || a.st * b.st > Polinom.maxSt)
      return null;
    
    Polinom rez = new Polinom();
    
    if (a.st > -1) {
      rez.st = 0;
      rez.k[0] = a.k[0];
      
      Polinom bNaN = new Polinom();
      bNaN.st = 0;
      bNaN.k[0] = 1;
      
      for (int n = 1; n <= a.st; n++) {
        bNaN = PolinomN.puta(bNaN, b);
        Polinom bNaNPutaKoef = PolinomN.brojPuta(bNaN, a.k[n]);
        rez = PolinomN.saberi(rez, bNaNPutaKoef);
      }
    }
    return rez;
  }
  
  public static void main(String[] args) {
    // zadatak a)
    Polinom a = new Polinom();
    a.st = 2;
    a.k[2] = 3;
    
    System.out.print("a(x) = ");
    PolinomN.stampaj(a);
    System.out.println();
    
    // zadatak b)
    Polinom b = new Polinom();
    b.st = 0;
    b.k[0] = 6;
    
    System.out.print("b(x) = ");
    PolinomN.stampaj(b);
    System.out.println();
    
    // zadatak c)
    Polinom c = new Polinom();
    c.st = 3;
    c.k[3] = 4;
    c.k[1] = -2.5;
    c.k[0] = 8;
    
    System.out.print("c(x) = ");
    PolinomN.stampaj(c);
    System.out.println();
    
    // zadatak d)
    Polinom d = PolinomN.ucitaj();
    
    System.out.print("d(x) = ");
    PolinomN.stampaj(d);
    System.out.println();
    
    // zadatak e)
    Polinom sab1 = PolinomN.saberi(a, b);
    Polinom sab2 = PolinomN.oduzmi(c, d);
    Polinom e = PolinomN.puta(sab1, sab2);
    
    System.out.print("e(x) = ");
    PolinomN.stampaj(e);
    System.out.println();
    
    // zadatak f)
    Polinom f = PolinomN.brojPuta(e, 2);
    
    System.out.print("f(x) = ");
    PolinomN.stampaj(f);
    System.out.println();
    
    // zadatak g)
    System.out.println("f(1) = " + PolinomN.izracunaj(1, f));
    
    // zadatak h)
    Polinom h = izvod(f);
    
    System.out.print("h(x) = ");
    PolinomN.stampaj(h);
    System.out.println();
    
    // zadatak i)
    Polinom i = kompozicija(h, a);
    
    System.out.print("i(x) = ");
    PolinomN.stampaj(i);
    System.out.println();
  }
}
