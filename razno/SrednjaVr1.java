class SrednjaVr1 {
  public static void main(String[] args) {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite broj clanova niza: ");
      if (n <= 0) { System.out.println("Greska. Ponovite unos."); }
    } while (n <= 0);
    
    int[] arr = new int[n];
    double sum = 0.0; 
    int count = 0;
    
    for (int i = 0; i < n; i++) {
      arr[i] = Svetovid.in.readInt("Unesite " + (i + 1) + ". clan niza: ");
      if (arr[i] % 3 == 0) {
        sum += arr[i];
        count++;
      }
    }
    
    if (count != 0) {
      System.out.println("Srednja vrednost clanova deljivih sa 3 je: " + (sum / count));
    }
    else {
      System.out.println("Ne postoje clanovi niza deljivi sa 3.");
    }
  }
}