/**
 * Stampa prvi ceo broj veci od 1 koji je jednak zbiru cetvrtih stepena
 * svojih cifara.
 */

class TeorijskeVezbe04_05 {
  int n = 1;
  
  glavnaPetlja: while (true) {
        n++;
    int zbir = 0, pom = n;
    
    while (pom != 0) {
      int cifra = pom % 10;
      zbir += Math.pow(cifra, 4);
      
      if (zbir >= n) continue glavnaPetlja;
      
      pom /= 10;
    }
    if (zbir == n) break;
  }
  System.out.println("Prvi ceo broj koji zadovoljava: " + n);
  }

}
