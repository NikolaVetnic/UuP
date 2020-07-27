class TeorijskeVezbe08_03 {
  
  static int larComDiv(int a, int b) {
    if (a == b) return a;
    else if (a > b) return larComDiv(a - b, b);
    else return larComDiv(a, b - a);
  }
  
  public static void main(String[] args) {
    int a;
    do {
      a = Svetovid.in.readInt("Unesite prvi prirodan broj: ");
    } while (a <= 0);
    
    int b;
    do {
      b = Svetovid.in.readInt("Unesite prvi prirodan broj: ");
    } while (b <= 0);
    
    System.out.println("Najveci zajednicki delilac brojeva je: " + larComDiv(a, b));
  }
}
