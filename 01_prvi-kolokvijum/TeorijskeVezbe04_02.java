/**
 * Ucitava redni broj dana u nedelji i uz pomoc switch-a ispisuje da l-
 * i je radni dan ili ne.
 */

class TeorijskeVezbe04_02 {
  public static void main(String[] args) {
    int n;
    System.out.print("Unesite redni broj dana u nedelji: ");
    n = Svetovid.in.readInt();
    switch (n) {
      case 1: case 2: case 3: case 4: case 5:
        System.out.println("Uneli ste radni dan.");
        break;
      case 6: case 7:
        System.out.println("Uneli ste vikend");
        break;
      default:
        System.out.println("Ne postoji dan sa tim rednim brojem.");
    }
  }
}
