class MojPolinom {
  static final int maxSt = 100;
  double[] k = new double[maxSt + 1];
  int st = -1;
}

enum Znak {
  PLUS, MINUS
}

class MojPolinomN {
  
  // anuliranje polinoma
  static void anuliraj(MojPolinom p) {
    if (p == null)
      return;
    p.st = -1;
    for (int i = 0; i <= MojPolinom.maxSt; i++) {
      p.k[i] = 0.0;
    }
  }
  
  // kopiranje polinoma
  static MojPolinom kopiraj(MojPolinom p) {
    if (p == null)
      return null;
    
    MojPolinom q = new MojPolinom();
    q.st = p.st;
    for (int i = 0; i <= p.st; i++)
      q.k[i] = p.k[i];
    
    return q;
  }
  
  // nalazenje stepena polinoma
  static void nadjiStepen(MojPolinom p) {
    if (p != null) {
      double eps = 1.0E-5;
      p.st = MojPolinom.maxSt;
      while (p.st > -1 && Math.abs(p.k[p.st] - 0.0) < eps)
        p.st--;
    }
  }
  
  // izracunaj polinom za vrednost x
  static double izracunaj(MojPolinom p, double x) {
    if (p == null)
      return Double.NaN;
    
    double rezultat;
    
    if (p.st == -1)
      rezultat = 0.0;
    else {
      rezultat = p.k[p.st];
      for (int i = p.st - 1; i > -1; i--) {
        rezultat = rezultat * x + p.k[i];
      }
    }
    return rezultat;
  }
    
  // mnozenje polinoma sa brojem
  static MojPolinom brojPuta(MojPolinom p, double c) {
    if (p == null)
      return null;
    
    MojPolinom rezultat = new MojPolinom();
    
    if (p.st != -1 && c != 0.00) {
      rezultat.st = p.st;
      
      for (int i = 0; i <= p.st; i++)
        rezultat.k[i] = p.k[i] * c;
    }
    return rezultat;
  }
  
  // ucitavanje polinoma
  static MojPolinom ucitaj() {
    MojPolinom p = new MojPolinom();
    double koef;
    int pom;
    
    do {
      pom = Svetovid.in.readInt("Stepen polinoma: ");
    } while (pom < 0 || pom > MojPolinom.maxSt);
    p.st = pom;
    
    do {
      koef = Svetovid.in.readDouble("p[" + p.st + "]: ");
    } while (p.st > 0 && koef == 0.0);
    p.k[p.st] = koef;
    
    if (p.st == 0 && p.k[p.st] == 0.0)
      p.st = -1;
    else {
      for (int i = 0; i < p.st; i++) {
        p.k[i] = Svetovid.in.readDouble("p[" + i + "] = ");
      }
    }
    return p;
  }
  
  // stampanje polinoma
  static void stampaj(MojPolinom p) {
    if (p != null) {
      if (p.st > 0) {
        if (p.k[p.st] < 0.0)
          System.out.print("-");
        if (Math.abs(p.k[p.st]) != 1.0)
          System.out.print(Math.abs(p.k[p.st]));
        if (p.st != 1)
          System.out.print("x^" + p.st);
        else
          System.out.print("x");
        
        for (int i = p.st - 1; i > 0; i--) {
          if (p.k[p.st] < 0.0)
            System.out.print("-");
          else
            System.out.print("+");
          if (Math.abs(p.k[i]) != 1.0)
            System.out.print(Math.abs(p.k[p.st]));
          if (i > 1)
            System.out.print("x^" + i);
          else if (i == 1)
            System.out.print("x");
        }
        
        if (p.k[0] != 0.0) {
          if (p.k[0] < 0.0)
            System.out.print("-");
          else
            System.out.print("+");
          System.out.print(Math.abs(p.k[0]));
        }
      }
      else {
        if (p.k[0] < 0)
          System.out.print("-" + Math.abs(p.k[0]));
        else
          System.out.print(p.k[0]);
      }
    }
  }
  
  // pomocni metod za sabiranje i oduzimanje
  static MojPolinom sab(MojPolinom p1, MojPolinom p2, Znak op) {
    if (p1 == null || p2 == null)
      return null;
    
    MojPolinom rezultat = new MojPolinom();
    
    if (p1.st > p2.st)
      rezultat.st = p1.st;
    else
      rezultat.st = p2.st;
    
    if (op == Znak.PLUS) {
      for (int i = 0; i <= rezultat.st; i++)
        rezultat.k[i] = p1.k[i] + p2.k[i];
    }
    else {
      for (int i = 0; i <= rezultat.st; i++)
        rezultat.k[i] = p1.k[i] - p2.k[i];
    }
    
    MojPolinomN.nadjiStepen(rezultat);
    return rezultat;
  }
  
  // saberi polinome
  static MojPolinom saberi(MojPolinom p1, MojPolinom p2) {
    return sab(p1, p2, Znak.PLUS);
  }
  
  // oduzmi polinom
  static MojPolinom oduzmi(MojPolinom p1, MojPolinom p2) {
    return sab(p1, p2, Znak.MINUS);
  }
  
  // pomnozi polinome
  static MojPolinom puta(MojPolinom p1, MojPolinom p2) {
    if (p1 == null || p2 == null)
      return null;
    
    MojPolinom rezultat = new MojPolinom();
    
    int proizvod = p1.st + p2.st;
    if (proizvod > MojPolinom.maxSt)
      return null;
    
    if (p1.st != -1 && p2.st != -1) {
      rezultat.st = proizvod;
      
      for (int i = p1.st; i >= 0; i--)
        for (int j = p2.st; j >= 0; j--)
          rezultat.k[i+j] += p1.k[i] * p2.k[j];
    }
    return rezultat;
  }
  
  // deljenje polinoma
  static MojPolinom[] deli(MojPolinom p1, MojPolinom p2) {
    if (p1 == null || p2 == null)
      return null;
    
    if (p2.st == -1)
      return null;
    
    MojPolinom ost = MojPolinomN.kopiraj(p1);
    MojPolinom kol = new MojPolinom();
    
    int i, j, m, l;
    
    if (p1.st >= p2.st) {
      kol.st = p1.st - p2.st;
      for (j = p1.st; j >= p2.st; j--) {
        i = j - p2.st;
        kol.k[i] = p1.k[j] / p2.k[p2.st];
        for (m = 0; m <= p2.st; m++) {
          l = m + i;
          ost.k[l] -= kol.k[i] * p2.k[m];
        }
      }
      nadjiStepen(ost);
    }
    MojPolinom[] rezultat = {kol, ost};
    return rezultat;
  }
}