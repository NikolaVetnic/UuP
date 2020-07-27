/**
 * Izracunava vrednost funkcije u zavisnosti od 'znak':
 * 's' - sin(x)
 * 'c' - cos(x)
 * 'a' - atan(x)
 * 'l' - ln(x)
 * 'e' - exp(x)
 */

class TeorijskeVezbe04_01 {
  public static void main(String[] args) {
    double x, rez;
    char znak;
    
    System.out.print("Unesite realan broj x: ");
    x = Svetovid.in.readDouble();
    
    do {
      System.out.print("Unesite znak s, c, a, l ili e: ");
      znak = Svetovid.in.readChar();
    } while (znak != 's' && znak != 'c' && znak != 'a' &&
                 znak != 'l' && znak != 'e');
    
    rez = 0.0;
    
    switch(znak) {
      case 's':
        rez = Math.sin(x);
        break;
      case 'c':
        rez = Math.cos(x);
        break;
      case 'a':
        rez = Math.atan(x);
        break;
      case 'l':
        rez = Math.log(x);
        break;
      case 'e':
        rez = Math.exp(x);
        break;
      default:
        break;
    }
    
    System.out.println("Rezultat je: " + rez);
  }
}
