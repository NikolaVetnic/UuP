class Kolokvijum {
  public static void main(String[] args) {
    double[] x = new double[10];
    double[] y = x;
    double[] z = y;
    y[6] = 6.0;
    z[6] = 7.0;
    System.out.println(x[7]);
    System.out.println(y[6]);
    System.out.println(z[6]);
  }
}