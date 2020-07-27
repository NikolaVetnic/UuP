class AutomobiliNiz {
  public static void main(String[] args) {
    Vlasnik[] vlasnici = new Vlasnik[10]; 
    vlasnici[0] = new Vlasnik();
    vlasnici[0].ime = "Pera";
    vlasnici[0].prezime = "Peric";
    vlasnici[0].JMBG = "0101900800001"; 
    vlasnici[0].auto = new Automobil(); 
    vlasnici[0].auto.marka = "Yugo Koral 55"; 
    vlasnici[0].auto.proizvodjac = "Crvena zastava"; 
    vlasnici[0].auto.godinaProiz = 1989; 
    vlasnici[0].auto.boja = "crvena"; 
    vlasnici[0].auto.brKonja = 55; 
    vlasnici[0].auto.brVrata = 3;
  } 
}

class Automobil {
  String marka, proizvodjac; int godinaProiz;
  String boja;
  int brKonja, brVrata = 5; String regBroj;
}

class Vlasnik {
  String ime, prezime, JMBG;
  Automobil auto;
}