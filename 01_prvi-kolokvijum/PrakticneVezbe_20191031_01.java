class PrakticneVezbe_20191031_01 {
  public static void main(String[] args) {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite prirodan broj: ");
      if (n <= 0) { System.out.println("Greska. Ponovite unos."); }
    } while (n <= 0);
    
    int sum = 0;
    
    while (n > 0) {
      sum += n % 10;
      n = n / 10;
    }
    
    System.out.println("Zbir cifara unetog broja je: " + sum);
  }
}
