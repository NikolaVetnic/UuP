/**
 * Program koji implementira igru pogadjanja broja. Program zamisli br-
 * oj izmedju 1 i 100 pomocu rnd, a korisnik pogadja broj u vise pokus-
 * aja. Nakon svakog pokusaja korisnik odbija infomraciju da li je pog-
 * odio broj, ili da u sledecem pokusaju treba da navede veci ili manji
 * broj.
 */

class TeorijskeVezbe02_03 {
    public static void main(String[] args) {
        int broj1, broj2, n;
        
        // postavljanje zamisljenog broja
        // Math.random -> [0,1)
        broj1 = (int)(Math.random() * 100) + 1;
        
        broj2 = 0;
        n = 1;
        
        while (broj1 != broj2) {
            System.out.print("Unesite broj: ");
            broj2 = Svetovid.in.readInt();
            
            if (broj1 > broj2) {
                System.out.println("Unesite veci broj...");                
            }
            else if (broj1 < broj2) {
                System.out.println("Unesite manji broj...");
            }          
            
            n = n + 1;
        }
        
        System.out.println("Pogodak iz pokusaja: " + n);
    }
}
