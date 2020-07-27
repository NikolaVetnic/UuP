class PrakticneVezbe_20191121_04 {
  
  static void searchString(String a, String b) {
    
    for (int i = 0; i <= a.length() - b.length(); i++) {
      if (Character.toLowerCase(a.charAt(i)) == Character.toLowerCase(b.charAt(0))) {
        boolean check = false;
        int j = 0;
        
        while (j < b.length() && !check) {
          if(Character.toLowerCase(b.charAt(j)) != Character.toLowerCase(a.charAt(j + i))) {
            check = true;
          }
          j++;
        }
        if (!check) System.out.println("String '" + b + "' je pronadjen na poziciji " + i + " stringa '" + a + "'.");
      }
    }
  }
  
  public static void main(String[] args) {
    String a = Svetovid.in.readLine("Unesite osnovni string: ");
    
    String b;
    do {
      b = Svetovid.in.readLine("Unesite string za pretragu: ");
      if (b.length() > a.length()) System.out.println("Greska. String za pretragu mora biti kraci od osnovnog.");
    } while (b.length() > a.length());
    
    searchString(a, b);
  }
}
