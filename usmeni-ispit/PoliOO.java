class PoliOO {
  static final int maxSt = 100;
  double[] k = new double[maxSt + 1];
  int st = -1;
  
  private enum Znak {
    PLUS, MINUS 
  }
  
  void anuliraj() {
    for (int i = maxSt; i >= 0; i--)
      k[i] = 0.0;
    st = -1;
  }
  
  PoliOO kopiraj() {
    PoliOO q = new PoliOO();
    q.st = st;
    for (int i = 0; i <= maxSt; i++) {
      q.k[i] = k[i];
    }
    return q;
  }
  
  void nadjiStepen() {
    final double eps = 1.0E-5;
    st = maxSt;
    while (st > -1 && Math.abs(k[st] - 0.0) < eps) {
      st--;
    }
  }
  
  double izracunaj(double x) {
    double rezultat;
    
    if (st == -1)
      rezultat = 0.0;
    else {
      rezultat = k[st];
      for (int i = st - 1; i > -1; i--) {
        rezultat = rezultat * x + k[i];
      }
    }
    return rezultat;
  }
  
  PoliOO brojPuta(double c) {
    PoliOO q = new PoliOO();
    if (st != -1 && c != 0.0) {
      q.st = st;
      for (int i = 0; i <= q.st; i++) {
        q.k[i] = k[i] * c;
      }
    }
    return q;
  }
  
  static PoliOO ucitaj() {
    PoliOO p = new PoliOO();
    
    int pom;
    do {
      pom = Svetovid.in.readInt("Stepen: ");
    } while (pom < 0 || pom > maxSt);
    p.st = pom;
    
    double koef;
    do {
      koef = Svetovid.in.readDouble("p[" + p.st + "] = ");
    } while (p.st > 0 && koef == 0.0);
    p.k[p.st] = koef;
    
    if (p.st == 0 && p.k[p.st] == 0)
      p.st = -1;
    else {      
      for (int i = p.st - 1; i >= 0; i--)
        p.k[i] = Svetovid.in.readDouble("p[" + i + "] = ");
    }
    return p;
  }
  
  void stampaj() {
    System.out.print(this);
  }
  
  public String toString() {
    StringBuilder s = new StringBuilder();
    
    if (st > 0) {
      if (k[st] < 0.0)
        s.append("-");
      if (Math.abs(k[st]) != 1.0)
        s.append(Math.abs(k[st]));
      if (st > 1)
        s.append("x^" + st);
      else
        s.append("x");
      
      for (int i = st - 1; i > 0; i--) {
        if (k[i] != 0.0) {
          if (k[i] < 0.0)
            s.append(" - ");
          else
            s.append(" + ");
        }
        if (Math.abs(k[i]) != 1.0)
          s.append(Math.abs(k[i]));
        if (i > 1)
          s.append("x^" + i);
        else
          s.append("x");
      }
      
      if (k[0] != 0.0) {
        if (k[0] < 0.0)
          s.append(" - ");
        else
          s.append(" + ");
      }
      s.append(Math.abs(k[0]));
    }
    else {
      if (k[0] < 0.0)
        s.append("-" + Math.abs(k[0]));
      else
        s.append(k[0]);
    }
    return s.toString();
  }
  
  private static PoliOO sab(PoliOO p1, PoliOO p2, Znak op) {
    if (p1 == null || p2 == null)
      return null;
    
    PoliOO sum = new PoliOO();
    if (p1.st > p2.st)
      sum.st = p1.st;
    else
      sum.st = p2.st;
    
    if (op == Znak.PLUS) {
      for (int i = 0; i <= sum.st; i++)
        sum.k[i] = p1.k[i] + p2.k[i];
    }
    else {
      for (int i = 0; i <= sum.st; i++)
        sum.k[i] = p1.k[i] - p2.k[i];
    }
    
    sum.nadjiStepen();
    
    return sum;
  }
  
  PoliOO saberi(PoliOO p) {
    return sab(this, p, Znak.PLUS);
  }
  
  PoliOO oduzmi(PoliOO p) {
    return sab(this, p, Znak.MINUS);
  }
  
  PoliOO puta(PoliOO p) {
    if (p == null) 
      return null;
    
    if (st + p.st > maxSt)
      return null;
    
    PoliOO result = new PoliOO();
    
    if (st != -1 && p.st != -1) {
      result.st = st + p.st;
      for (int i = 0; i <= st; i++) {
        for (int j = 0; j <= p.st; j++) {
          result.k[i+j] += k[i] * p.k[j]; 
        }
      }
    }
    return result;
  }
  
  
}