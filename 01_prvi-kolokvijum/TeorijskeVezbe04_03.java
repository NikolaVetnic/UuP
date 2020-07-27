/**
 * Ucitava znakove sve dok se ne unese '.'. Na izlazu ispisuje da li se
 * od unetih znakova moze formirati rec "banana".
 */

class TeorijskeVezbe04_03 {
  public static void main(String[] args) {
    char c;
    int brB = 0, brA = 0, brN = 0;
    
    System.out.println("Unesite znakove i zavrsite unos tackom.");
    c = Svetovid.in.readChar();
    
    while (c != '.') {
      switch (c) {
        case 'b':
          brB++;
          break;
        case 'a':
          brA++;
          break;
        case 'n':
          brN++;
      }
      c = Svetovid.in.readChar();
    }
    
    if (brB >= 1 && brA >= 3 && brN >= 2) {
      System.out.println("Od unetih karaktera se moze ispisati rec \"banana\".");
    }
    else {
      System.out.println("Od unetih karaktera se ne moze ispisati rec \"banana\".");
    }
  }
}
