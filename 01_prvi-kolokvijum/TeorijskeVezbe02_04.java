/**
 * PROGRAM KOJI ISPISUJE CIFRE UCITANOG PRIRODNOG BROJA u obrnutom red-
 * osledu.
 */

class TeorijskeVezbe02_04 {
    public static void main(String[] args) {
        int broj, cifra;
        
        System.out.print("Unesite prirodan broj: ");
        broj = Svetovid.in.readInt();
        
        System.out.print("Obrnuti broj je: ");
        do {
            cifra = broj % 10;
            System.out.print(cifra);
            broj = broj / 10; 
            // broj /= 10; - alternativni zapis
        } while (broj != 0);
        
        System.out.println();        
    }
}
