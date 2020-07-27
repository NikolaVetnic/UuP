class BubbleSortiranje {
  public static void bubbleSort(int[] arr) {
    int i, temp;
    boolean flag = true;
    
    while (flag) {
      flag = false;
      for (i = 0; i < arr.length - 1; i++) {
        if (arr[i] < arr[i + 1]) {
          temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
          flag = true;
        }
      }
    }
  }
  
  public static void main(String[] args) {
    int arr[] = {3, 60, 35, 2, 45, 320, 5};
    
    System.out.println("Array before bubbleSort");
    for (int i = 0; i < arr.length - 1; i++) {
      System.out.print("arr[" + i + "] = " + arr[i] + "; ");
    }
    
    bubbleSort(arr);
    
    System.out.println();
    
    System.out.println("Array after bubbleSort");
    for (int i = 0; i < arr.length - 1; i++) {
      System.out.print("arr[" + i + "] = " + arr[i] + "; ");
    }
    
    System.out.println();
  }
}

