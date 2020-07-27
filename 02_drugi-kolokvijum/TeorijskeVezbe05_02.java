class TeorijskeVezbe05_02 {
  static int baseConversion(int n, int base) {
    int i = 0, tmp = n, m = 0;
    
    while (tmp > 0) {
      m += (tmp % base) * Math.pow(10, i++);
      tmp /= base;
    }
    
    return m;
  }
  
  public static void main(String[] args) {
    int n = Svetovid.in.readInt("Unesi broj: ");
    int base = Svetovid.in.readInt("Unesi bazu: ");
    
    int m = baseConversion(n, base);
    
    System.out.println("m = " + m);
  }
}
