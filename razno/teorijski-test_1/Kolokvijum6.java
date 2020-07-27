class Kolokvijum6 {
  public static void main(String[] args) {
    int[] niz = {0, 0, 0, 3, 0, 2, 0, 0, 0, 42, 0, 44, 0};
    double[] arr = new double[18];
    int[][] matrica = new int[3][4];
    int i = 3;
    int br = 1;
    do {
      br += niz[i];
      i += 2;
    } while (i < 12);
    System.out.println("i = " + i + ", br = " + br);
    int[][] m = new int[3][];
    m[0] = new int[1];
    m[1] = new int[2];
    m[2] = new int[3];
    System.out.println(m[0].length);
    System.out.println(m[1].length);
    System.out.println(m[2].length);
    for (i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        System.out.print("m[" + i + ", " + j + "] = " + m[i][j] + "\t");
      }
      System.out.println();
    }
  }
}