class ArrayTest {
  public static void main(String[] args) {
    int n = Svetovid.in.readInt("Array length: ");
    double[] arr = new double[n];
    double sum = 0.0;
    
    // primer for petlje gde se sve izvrsava u koraku
    for (int i = 0; i < n; arr[i] = 1.0 / (i + 1), sum += arr[i++]);
    
    System.out.println("sum = " + String.format("%.4f", sum));
  }
}