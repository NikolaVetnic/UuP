class TeorijskeVezbe11_01 {
  public static void main(String args[]) {
    final int gr = 1000;
    System.out.println("Unesite polinom p: ");
    Polinom p = PolinomN.ucitaj();
    for (int i = -gr; i <= gr; i++) {
      if (PolinomN.izracunaj(i, p) == 0.0)
        System.out.println("Nula polinoma je: " + i);
    }
  }
}
