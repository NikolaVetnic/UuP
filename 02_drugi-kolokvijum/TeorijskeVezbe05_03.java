class TeorijskeVezbe05_03 {
  static void analyzeString(String s) {
    char[] chars = s.toCharArray();
    int[] count = new int[11];
    
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] >= '0' && chars[i] <= '9') count[chars[i] - '0']++;
      else count[10]++;
    }
    
    for (int i = 0; i < count.length; i++) {
      if (i < 10) {
        System.out.print("Cifra " + i + ": \t");
        for (int j = 0; j < count[i]; j++) System.out.print("*");
      }
      else {
        System.out.print("Ostalih: \t");
        for (int j = 0; j < count[i]; j++) System.out.print("*");
      }
      System.out.println();
    }
  }
  
  public static void main(String[] args) {
    String s = Svetovid.in.readLine("String: ");
    analyzeString(s);
  }
}
