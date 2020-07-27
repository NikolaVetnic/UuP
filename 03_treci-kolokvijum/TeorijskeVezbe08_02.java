class TeorijskeVezbe08_02 {
  
  static int digitSum(int num) {
    if (num < 10) {
      return num;
    }
    else {
      return (num % 10) + digitSum(num / 10);
    }
  }
  
  public static void main(String[] args) {
    int num;
    do {
      num = Svetovid.in.readInt("Unesite prirodan broj: ");
    } while (num <= 0);
    
    System.out.println("Zbir cifara broja " + num + ": " + digitSum(num));
  }
}
