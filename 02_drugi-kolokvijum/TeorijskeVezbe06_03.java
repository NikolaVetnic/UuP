class TeorijskeVezbe06_03 {
  
  static int convertString(String s) {
    int num = 0;
    int pow = 0;
    
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) >= '0' && '9' >= s.charAt(i))
        num += (s.charAt(i) - '0') * Math.pow(10, pow++);
      else {
        System.out.println("String sadrzi znakove koji nisu cifre. Prekid rada.");
        return -1;
      }
    }
    System.out.println("Konvertovana vrednost: " + num);
    return num;
  }
  
  public static void main(String[] args) {
    String s = Svetovid.in.readLine("Unesite string: ");
    int num = convertString(s);
  }
}
