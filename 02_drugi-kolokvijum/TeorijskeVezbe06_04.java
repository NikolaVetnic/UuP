class TeorijskeVezbe06_04 {
  static void copyString(String s) {
    int p = Svetovid.in.readInt("Unesite p: ");
    int n = Svetovid.in.readInt("Unesite n: ");
    String sum = "";
    
    if (p + n <= s.length()) {
      for (int i = p; i < p + n; i++) {
        sum = sum + s.charAt(i);
      }
      System.out.println("Rezultat: " + sum);
    }
    else System.out.println("Zadate vrednosti izlaze van opsega stringa.");
  }
  
  public static void main(String[] args) {
    String s = Svetovid.in.readLine("Unesite string: ");
    copyString(s);
  }
}
