/**
 * Program koji ucitava prirodne brojeve sve dok ne bude unesen broj 0,
 * i odredjuje koliko je ucitanih brojeva parno a koliko neparno.
 */

class TeorijskeVezbe02_05 {
    public static void main(String[] args) {
        int broj, brPar = 0, brNepar = 0;
        
        System.out.println("Unos prirodnih brojeva zavrsite brojem 0.");
        do {
            System.out.print("Unesite broj: ");
            broj = Svetovid.in.readInt();
            if (broj % 2 == 0) {
                brPar++;
            }
            else {
                brNepar++;
            }
        } while (broj != 0);
        
        System.out.println("Parnih ima: " + --brPar + ", a neparnih: " + brNepar);
    }
}
