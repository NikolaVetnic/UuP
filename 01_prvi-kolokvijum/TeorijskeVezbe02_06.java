/**
 * Napisati program koji ucitava sekvencu znakova sve dok ne ucita znak
 * '.' i ispisuje koliko medju unetim znakovima ima slova, cifara i os-
 * talih znakova.
 */

class TeorijskeVezbe02_06 {
    public static void main(String[] args) {
        char c;
        int slova = 0;
        int cifre = 0;
        int ostali = 0;
        
        System.out.println("Unesite znakove i unos zavrsite tackom.");
        c = Svetovid.in.readChar();
        
        while (c != '.') {
            if (('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
                slova++;
            }
            else if ('0' <= c && c <= '9') {
                cifre++;
            }
            else {
                ostali++;
            }
            
            System.out.println("Unesite znakove i unos zavrsite tackom.");
            c = Svetovid.in.readChar();
        }
        
        System.out.println("Slova: " + slova);
        System.out.println("Cifre: " + cifre);
        System.out.println("Ostali: " + ostali);        
    }
}
