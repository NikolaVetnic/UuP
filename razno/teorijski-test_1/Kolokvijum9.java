class Kolokvijum9 {
  public static void main(String[] args) {
    Kupac kupac1 = new Kupac();
    kupac1.ime = "Pera";
    kupac1.prezime = "Peric";
    kupac1.caksire = new Pantalone[3];
    kupac1.caksire[0] = new Pantalone();
    kupac1.caksire[0].sirina = 10;
    kupac1.caksire[0].duzina = 10;
    kupac1.caksire[0].proizvodjac = "Proizvodjac1";
  }
}

class Pantalone {
  int sirina;
  int duzina;
  String proizvodjac;
}

class Kupac {
  String ime, prezime;
  Pantalone[] caksire;
}