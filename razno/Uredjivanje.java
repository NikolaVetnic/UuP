/**
 * Ideja: kreirati program koji uredjuje clanove unetog niza po opadaj-
 * ucim vrednostima, ali bez unistavanja podataka u unetom nizu. Ovo se
 * postize pridruzivanjem treceg kontrolnog niza sa logickim velicinama
 * ciji su svi clanovi inicijalizovani sa TRUE. Kako se koji clan unet-
 * og niza izdvoji i smesti u uredjen, odgovarajuci clan kontrolnog po-
 * desava se na FALSE i time iskljucuje iz dalje obrade.
 */

class Uredjivanje {
  public static void main(String[] args) {
    
    // Unos broja clanova niza:
    int n;
    do {
      n = Svetovid.in.readInt("Unesite broj clanova niza: ");
      if (n <= 0) {
        Svetovid.out.println("Greska. Ponovite unos.");
      };
    } while (n <= 0);
    
    // Tri niza: 
    // intArray unosi korisnik, 
    // ordArray je uredjen, 
    // checkArray je kontrolni
    int[] intArray = new int[n];
    boolean[] checkArray = new boolean[n];
    int[] ordArray = new int[n];
    
    // Inicijalizacija brojaca, trenutnog maksimuma i njegovog indeksa.
    int i = 1, j = 0;
    int ind = 0, max = 0;
    
    // Unos prvog clana niza, zarad utvrdjivanja maksimuma.
    intArray[0] = Svetovid.in.readInt("Unesite " + 0 + ". clan niza: ");
    ordArray[0] = intArray[0];
    
    // Unos ostalih clanova niza:
    do {
      intArray[i] = Svetovid.in.readInt("Unesite " + i + ". clan niza: ");
      // Inicijalizacija clanova kontrolnog niza.
      checkArray[i] = Boolean.TRUE;

      // Odmah se trazi najmanji clan unetog niza
      // i on postaje prvi clan uredjenog niza.
      if (intArray[i] >= ordArray[0]) {
        ordArray[0] = intArray[i];
        // Cuva se indeks maksimalnog elementa.
        ind = i;
      }
      i++;
    } while (i < n);
    
    /**
     * Clan kontrolnog niza koji odgovara maksimumu unetog se postavlja
     * na FALSE.
     */
     
    checkArray[ind] = Boolean.FALSE;
    
    /**
     * Glavna 'for' petlja, pocinje od 1 buduci da se vec zna prvi clan
     * uredjenog niza.
     */
     
    for (i = 1; i < n; i++) {
      
      /**
       * Druga 'for' petlja, pregledaju se samo clanovi kod kojih kont-
       * rolni niz vraca TRUE.
       */
       
      for (j = 0; j < n; j++) {
        if (checkArray[j]) {
          /**
           * Za maksimum se postavlja prvi clan niza kod kojeg kontrol-
           * ni vraca TRUE. Ovo je vazno jer se cak i ovaj 'privremeni'
           * maksimum MORA traziti medju preostalim clanovima iskljuci-
           * vo.
           */
           
          max = intArray[j];
        }
      }
      
      /**
       * Treca 'for' petlja koja zapravo trazi maksimum i njemu odgova-
       * rajuci indeks.
       */
       
      for (j = 0; j < n; j++) {
        if (checkArray[j]) {
          if (intArray[j] >= max) {
            max = intArray[j];
            ind = j;
          }
        }
      }
      
      /**
       * Kada se nadje maksimum, odgovarajuci clan kontrolnog se posta-
       * vlja na FALSE, a aktuelni clan uredjenog niza tada dobija vre-
       * dnost maksimuma.
       */
       
      checkArray[ind] = Boolean.FALSE;
      ordArray[i] = max;
    }
    
    /**
     * Ispis je mogao biti uradjen i u prethodnoj petlji ali je izdvoj-
     * en zarad preglednosti.
     */
     
    for (i = 0; i < n; i++) {
      Svetovid.out.println("ordArray[" + i + "] = " + ordArray[i] + "; ");
    }

  }
}
