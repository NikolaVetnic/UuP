class MojPolinomVezba {
  
  public static void main(String[] args) {
    MojPolinom p = new MojPolinom();
    p.st = 1;
    p.k[1] = 1.0;
    p.k[0] = 2.0;
    System.out.println(p.st + "\t" + p.k[1] + "\t" + p.k[0]);
    MojPolinomN.stampaj(p);
    System.out.println();
    
    p = MojPolinomN.saberi(MojPolinomN.brojPuta(p, 3.0), p);
    MojPolinomN.stampaj(p);
    System.out.println();
    
    MojPolinom q = MojPolinomN.kopiraj(p);
    p = MojPolinomN.puta(p, p);
    MojPolinomN.stampaj(p);
    System.out.println();
    
    System.out.println("Deljenje:");
    MojPolinomN.stampaj(MojPolinomN.deli(p, q)[0]);
    System.out.println();
    MojPolinomN.stampaj(MojPolinomN.deli(p, q)[1]);
    System.out.println();
  }
}