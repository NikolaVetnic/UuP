class PrakticneVezbe_20191031_02 {
  public static void main(String[] args) {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite prirodan broj: ");
      if (n <= 0) { System.out.println("Greska. Ponovite unos."); }
    } while (n <= 0);
    
    int i = 1, sum = 0;
    
    while (sum < n) {
      sum += i++;
      //if (sum < n) i++;
    }
    
    System.out.println("Trazeni broj je: " + (i - 2));
  }
}
