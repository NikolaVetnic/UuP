class PrakticneVezbe_20191121_01 {
  
  static void compareStrings(String a, String b) {
    if (a.length() != b.length()) System.out.println("Stringovi nisu jednaki.");
    else {
      boolean check = false;
      int i = 0;
      
      while (i < a.length() && !check) {
        if (Character.toLowerCase(a.charAt(i)) != Character.toLowerCase(b.charAt(i)))
          check = true;
        i++;
      }
      
      if (check) System.out.println("Stringovi nisu jednaki.");
      else System.out.println("Stringovi su jednaki.");
    }
  }
  
  public static void main(String[] args) {
    String a = Svetovid.in.readLine("String a: ");
    String b = Svetovid.in.readLine("String b: ");
    
    compareStrings(a, b);
  }
}
