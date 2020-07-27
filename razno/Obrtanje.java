class Obrtanje {
  public static void main(String[] args) {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite broj clanova niza: ");
      if (n <= 0) { System.out.println("Greska. Ponovite unos."); }
    } while (n <= 0);
    
    int[] arr = new int[n];
    
    for (int i = 0; i < n; i++) {
      arr[i] = Svetovid.in.readInt("Unesite " + (i + 1) + ". clan niza: ");
    }
    
    System.out.println("Ucitani niz: ");
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + "\t");
    }
    System.out.println();
    
    int temp;
    
    for (int i = 0; i < (n / 2); i++) {
      temp = arr[n - i - 1];
      arr[n - i - 1] = arr[i];
      arr[i] = temp;
    }
    
    System.out.println("Obrnut niz: ");
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + "\t");
    }
    System.out.println();
  }
}