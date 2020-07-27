class Polinom {
  static final int maxSt = 100;
  double[] k = new double[maxSt+1];
  int st = -1;
}

enum Znak {
  PLUS, MINUS
}

class PolinomN {
 
  /* Anulira polinom p */
  static void anuliraj(Polinom p) {
    if (p != null) {
      p.st = -1;
      for (int i = 0; i <= p.maxSt; i++)
        p.k[i] = 0.0;
    }
  }

  /* Kreira i vraca kopiju polinoma p */
  static Polinom kopiraj(Polinom p) {
    if (p == null)
      return null;
    Polinom q = new Polinom();
    q.st = p.st;
    for (int i = 0; i <= p.maxSt; i++)
      q.k[i] = p.k[i];
    return q;
  }

  /* Pronalazi stepen polinoma p i smesta ga u strukturu */
  static void nadjiStepen(Polinom p) {
    if (p != null) {
      final double eps = 1.0E-5;
      p.st = p.maxSt;
      while (p.st > -1 && (Math.abs(p.k[p.st]-0.0) < eps)) {
        /* Postavlja stepen polinoma za prvi koeficijent
           razlicit od 0, ili na -1 ako su svi koeficijenti
           0. Pri poredjenju sa nulom pitamo se da li
           je koeficijent dovoljno blizu nule
        */
        p.st--;
      }
    }
  }

  /* Izracunava vrednost polinoma p za dato x */
  static double izracunaj(double x, Polinom p) {
    if (p == null)
      return Double.NaN;
    double rezultat;
    if (p.st == -1)
      rezultat = 0.0;
    else {
      rezultat = p.k[p.st];
      for (int i = p.st - 1; i >= 0; i--)
        rezultat = rezultat * x + p.k[i];
    }
    return rezultat;
  }

  /* Ucitava polinom */
  static Polinom ucitaj() {
    Polinom p = new Polinom();
    int pom;
    double koef;
    do {
      System.out.print("Stepen polinoma (>= 0, <= " + p.maxSt + "): ");
      pom = Svetovid.in.readInt();
    } while (pom < 0 || pom > p.maxSt);
    p.st = pom;
    do {
      System.out.print("Koeficijent uz x^" + p.st + ": ");
      koef = Svetovid.in.readDouble();
    } while (p.st > 0 && koef == 0.0);
    p.k[p.st] = koef;
    if (p.st == 0 && p.k[p.st] == 0.0) {
      p.st = -1;
    }
    else {
      for (int i = p.st - 1; i >= 0; i--) {
        System.out.print("Koeficijent uz x^" + i + ": ");
        koef = Svetovid.in.readDouble();
        p.k[i] = koef;
      }
    }
    return p;
  }

  /* Stampa polinom p */
  static void stampaj(Polinom p) {
    if (p != null) {
      if (p.st > 0) { /* ako polinom ima x stampati: */
        if (p.k[p.st] < 0.0) /* najpre vodeci monom */
          System.out.print("-");
        if (Math.abs(p.k[p.st]) != 1.0)
          System.out.print(Math.abs(p.k[p.st]));
        if (p.st > 1)
          System.out.print("x^" + p.st);
        else
          System.out.print("x");
        /* stampati ostale monome sa x */
        for (int i = p.st - 1; i >= 1; i--) {
          if (p.k[i] != 0.0) {
            if (p.k[i] > 0.0)
              System.out.print("+");
            else
              System.out.print("-");
            if (Math.abs(p.k[i]) != 1.0)
              System.out.print(Math.abs(p.k[i]));
            if (i > 1)
              System.out.print("x^" + i);
   	        else if (i == 1)
              System.out.print("x");
          }
        }
        /* na kraju stampati slobodan clan */
        if (p.k[0] != 0.0) {
          if (p.k[0] > 0.0)
            System.out.print("+" + p.k[0]);
          else
            System.out.print("-" + Math.abs(p.k[0]));
        }
      }
      else { /* ako polinom nema x */
        if (p.k[0] < 0.0)
          System.out.print("-" + Math.abs(p.k[0]));
        else
          System.out.print(p.k[0]);
      }
    }
  }
  
  private static Polinom sab(Polinom p1, Polinom p2, Znak op) {
    if (p1 == null || p2 == null)
      return null;
    Polinom zbir = new Polinom();    
    if (p1.st > p2.st)
      zbir.st = p1.st;
    else
      zbir.st = p2.st;
    if (op == Znak.PLUS)
      for (int i = 0; i <= zbir.st; i++)
        zbir.k[i] = p1.k[i] + p2.k[i];
    else
      for (int i = 0; i <= zbir.st; i++)
        zbir.k[i] = p1.k[i] - p2.k[i];
    nadjiStepen(zbir);
    /* Nalazi stepen zbira za slucaj da su se
       neki koeficijenti anulirali sabiranjem */
    return zbir;
  }

  /* Sabira polinome p1 i p2 vracajuci zbir */
  static Polinom saberi(Polinom p1, Polinom p2) {
    return sab(p1, p2, Znak.PLUS);
  }

  /* Oduzima polinom p2 od polinoma p1 vracajuci razliku */
  static Polinom oduzmi(Polinom p1, Polinom p2) {
    return sab(p1, p2, Znak.MINUS);
  }

  /* Mnozi broj c sa polinomom p vracajuci proizvod */
  static Polinom brojPuta(Polinom p, double c) {
    if (p == null)
      return null;
    Polinom rezultat = new Polinom();
    if (p.st != -1 && c != 0.0) {
      rezultat.st = p.st;
      for (int i = 0; i <= p.st; i++)
        rezultat.k[i] = c * p.k[i];
    }
    return rezultat;
  }

  /* Mnozi polinom p1 sa p2 vracajuci proizvod */
  static Polinom puta(Polinom p1, Polinom p2) {
    if (p1 == null || p2 == null)
      return null;
    int proizvodSt = p1.st + p2.st;
    if (proizvodSt > Polinom.maxSt)
      return null;
    Polinom proizvod = new Polinom();
    if (p1.st != -1 && p2.st != -1) {
      proizvod.st = proizvodSt;
      for (int i = 0; i <= p1.st; i++)
        for (int j = 0; j <= p2.st; j++)
          proizvod.k[i+j] += p1.k[i] * p2.k[j];
    }
    return proizvod;
  }

  /* Deli dva polinoma, vracajuci kolicnik i ostatak u nizu */
  static Polinom[] deli(Polinom p1, Polinom p2) {
    if (p1 == null || p2 == null)
      return null;
    if (p2.st == -1)
      return null;
    int i, j, m, l;
    Polinom ostatak = kopiraj(p1);
    Polinom kolicnik = new Polinom();
    if (p1.st >= p2.st) {
      kolicnik.st = p1.st - p2.st;
      for (j = p1.st; j >= p2.st; j--) {
        i = j - p2.st;
        kolicnik.k[i] = ostatak.k[j] / p2.k[p2.st];
        for (m = 0; m <= p2.st; m++) {
          l = m + i;
          ostatak.k[l] -= kolicnik.k[i] * p2.k[m];
        }
      }
      nadjiStepen(ostatak);
    }
    Polinom[] rezultat = {kolicnik, ostatak};
    return rezultat;
  }
}