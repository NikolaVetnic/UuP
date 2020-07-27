class Binary {
  public static void main(String[] args) {
    byte num = Svetovid.in.readByte("Enter integer: ");
    
    System.out.println("Integer 'num' in binary is " 
                         + Integer.toBinaryString(num));
    System.out.println("Integer 'num << 2' in binary is " 
                         + Integer.toBinaryString(num << 2));
    System.out.println("Integer 'num >> 2' in binary is " 
                         + Integer.toBinaryString(num >> 2));
    System.out.println("Integer 'num >>> 2' in binary is " 
                         + Integer.toBinaryString(num >>> 2));
  }
}