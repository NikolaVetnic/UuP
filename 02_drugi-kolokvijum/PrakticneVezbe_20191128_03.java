class PrakticneVezbe_20191128_03 {
  static void printTable(String s) {
    int[] content = new int[27];
    
    for (int i = 0; i < s.length(); i++) {
      if (Character.toLowerCase(s.charAt(i)) >= 'a' &&
          Character.toLowerCase(s.charAt(i)) <= 'z') {
        content[Character.toLowerCase(s.charAt(i)) - 'a']++;
      }
      else content[26]++;
    }
    
    for (int i = 0; i < content.length; i++) {
      if (i < 26) System.out.print((char)(i + 'A') + "\t");
      else System.out.print("Ostali\t");
      
      for (int j = 0; j < content[i]; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
  
  public static void main(String[] args) {
    String s = Svetovid.in.readLine("Unesite string: ");
    printTable(s);
  }
}
