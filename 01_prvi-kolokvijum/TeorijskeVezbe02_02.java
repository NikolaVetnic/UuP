/**
 * Program koji ispisuje zbir cifara ucitanog prirodnog broja.
 * % - moduo (ostatak pri deljenju)
 * 12345 % 10 = 5;
 * 12345 / 10 = 1234;
 */

class TeorijskeVezbe02_02 {
    public static void main(String[] args) {
        int broj, cifra, zbir;
        
        System.out.print("Unesite prirodan broj: ");
        broj = Svetovid.in.readInt();
        
        zbir = 0;
        
        while (broj != 0) {
            cifra = broj % 10;
            zbir = zbir + cifra;
            broj = broj / 10;
        }
        
        System.out.println("Zbir cifara je: " + zbir);
    }
}
