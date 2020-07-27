class PoliOOVezba {
  
  public static void main(String[] args) {
    PoliOO p = new PoliOO();
    p.k[0] = 3.0; p.k[1] = 4.0;
    p.nadjiStepen();
    p = p.brojPuta(2.0);
    System.out.println(p.k[1] + "\t" + p.k[0] + ",\t" + p.st);
    System.out.println(p.izracunaj(1.0));
    
    PoliOO q = PoliOO.ucitaj();
    System.out.println(q.k[1] + "\t" + q.k[0] + ",\t" + q.st);
    
    PoliOO r = p.puta(q);
    p.stampaj();
    System.out.println();
    q.stampaj();
    System.out.println();
    r.stampaj();
    System.out.println();
  }
}