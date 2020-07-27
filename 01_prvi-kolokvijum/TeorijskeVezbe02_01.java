/**
 * Program racuna minimum od n ucitavnih celih brojeva, gde je n > 0 d-
 * ati prirodan broj. 
 */

class TeorijskeVezbe02_01 {
    public static void main(String[] args){
        int n, x, i, min;
        
        // ucitavanje broja brojeva
        System.out.print("Unesite ceo broj n, n > 0: ");
        n = Svetovid.in.readInt();
        
        // ucitavanje prbog broja i postavljanje minimuma
        System.out.print("Unesite 1. broj: ");
        x = Svetovid.in.readInt();
        min = x;
        
        for (i = 2; i <= n; i++) {
            System.out.print("Unesite " + i + ". broj: ");
            x = Svetovid.in.readInt();
            
            if (x < min) {
                min = x;
            }
        }
        
        System.out.println("Najmanji uneti broj je: " + min);
    }
}
