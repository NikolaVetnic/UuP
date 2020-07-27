class Najmanji {
  public static void main(String[] args) {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite broj clanova niza: ");
      if (n <= 0) { System.out.println("Greska. Ponovite unos."); }
    } while (n <= 0);
    
    int[] arr = new int[n];
    
    arr[0] = Svetovid.in.readInt("Unesite 1. clan niza: ");
    int min = arr[0];
    
    for (int i = 1; i < n; i++) {
      arr[i] = Svetovid.in.readInt("Unesite " + (i + 1) + ". clan niza: ");
      if (arr[i] < min) min = arr[i];
    }
    
    System.out.println("Najmanji clan niza je: " + min);
  }
}