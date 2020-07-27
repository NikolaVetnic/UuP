class TeorijskeVezbe08_01 {
  
  static void reverseDigits(int n) {
    if (n < 10) {
      System.out.print(n);
    }
    else {
      System.out.print(n % 10);
      reverseDigits(n / 10);
    }
  }
  
  public static void main(String[] args) {
    int n = Svetovid.in.readInt("Unesite n: ");
    reverseDigits(n);
    
    System.out.println();
  }
}
