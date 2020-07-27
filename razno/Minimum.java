class Minimum {
  public static void main(String[] args) {
    int n = Svetovid.in.readInt("Unesite broj clanova niza: ");
    
    int[] intArray = new int[n];
    
    intArray[0] = Svetovid.in.readInt("Unesite 1. clan: ");
    int min = intArray[0];
    
    for (int i = 1; i < n; i++) {
      intArray[i] = Svetovid.in.readInt("Unesite " + (i + 1) + ". clan: ");
      if (intArray[i] < min) {
        min = intArray[i];
      }
    }
    
    Svetovid.out.println("Najmanji clan niza je: " + min);
  }
}