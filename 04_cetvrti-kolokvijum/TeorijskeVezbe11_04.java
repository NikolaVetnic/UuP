class TeorijskeVezbe11_04 {
  
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
  
  public static void main(String[] args) {
    Polinom f0 = new Polinom();
    f0.st = 0;
    f0.k[0] = 4.0;
    
    Polinom f1 = new Polinom();
    f1.st = 1;
    f1.k[0] = 1.0;
    f1.k[1] = -1.0;
    
    Polinom x2 = new Polinom();
    x2.st = 2;
    x2.k[2] = 1.0;
    
    Polinom x = new Polinom();
    x.st = 1;
    x.k[1] = 1.0;
    
    Polinom fn = null;
    Polinom f6 = null;
    
    for (int n = 2; n <= 11; n++) {
      
      Polinom izv = izvod(f0);        // f0'   ili f'_n-2(x)
      Polinom izv2 = izvod(izv);      // f0''  ili f''_n-2(x)
      izv = izvod(f1);                // f1'   ili f'_n-1(x)
      
      Polinom razlIzvoda = PolinomN.oduzmi(izv, izv2);
      Polinom drugiSab = PolinomN.puta(x, razlIzvoda);
      
      Polinom prviSab = PolinomN.puta(x2, f1);
      
      Polinom f02 = PolinomN.puta(f0, f0);
      Polinom treciSab = PolinomN.saberi(prviSab, drugiSab);
      
      Polinom temp = PolinomN.saberi(prviSab, drugiSab);
      fn = PolinomN.saberi(temp, treciSab);
      
      if (n == 6)
        f6 = fn;
      
      f0 = f1;
      f1 = fn;
    }
    
    Polinom[] kolost = PolinomN.deli(fn, f6);
    Polinom a = kolost[0];
    Polinom b = kolost[1];
    
    System.out.print("a(x) = ");
    PolinomN.stampaj(a);
    System.out.println();
    
    System.out.print("b(x) = ");
    PolinomN.stampaj(b);
    System.out.println();
  }
}
