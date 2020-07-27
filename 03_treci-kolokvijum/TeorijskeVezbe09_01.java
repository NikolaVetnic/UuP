class TeorijskeVezbe09_01 {
  static int chainCount(int n) {
    if (n == 1) return 2;
    else if (n == 2) return 3;
    else return chainCount(n - 2) + chainCount(n - 1);
  }
  
  public static void main(String[] args) {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite duzinu lanca: ");
    } while (n < 1);
    
    System.out.println("Postoji " + chainCount(n) + " varijanti lanaca duzine " + n + ".");
  }
}
