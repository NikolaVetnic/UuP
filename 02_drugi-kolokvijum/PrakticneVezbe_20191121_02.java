class PrakticneVezbe_20191121_02 {
  
  static void lexCheck(String a, String b) {
    if (a.length() < b.length()) {
      String tmp = a;
      a = b;
      b = tmp;
    }
    
    boolean check = false;
    int i = 0;
    int order = 0;
    
    while (i < b.length() && !check) {
      if (Character.toLowerCase(a.charAt(i)) < Character.toLowerCase(b.charAt(i))) {
        order = 1;
        check = true;
      }
      else if (Character.toLowerCase(a.charAt(i)) > Character.toLowerCase(b.charAt(i))) {
        order = 2;
        check = true;
      }
      i++;
    }
    
    if (check) {
      switch(order) {
        case 1:
          System.out.println("String '" + a + "' je leksikografski veci.");
          break;
        case 2:
          System.out.println("String '" + b + "' je leksikografski veci.");
      }
    }
    else {
      if (a.length() != b.length()) System.out.println("String '" + b + "' je leksikografski veci.");
      else System.out.println("Stringovi su potpuno jednaki.");
    }
  }
  
  public static void main(String[] args) {
    String a = Svetovid.in.readLine("String a: ");
    String b = Svetovid.in.readLine("String b: ");
    
    lexCheck(a, b);
  }
}
