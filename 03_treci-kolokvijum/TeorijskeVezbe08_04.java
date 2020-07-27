class TeorijskeVezbe08_04 {
  
  static boolean palindrome(String s, int start, int end) {
    if (start == end) return true;
    else if (Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end))) {
      return palindrome(s, ++start, --end);
    }
    else return false;
  }
  
  public static void main(String[] args) {
    String s = Svetovid.in.readLine("Unesite string: ");
    if (palindrome(s, 0, s.length()-1)) System.out.println("String je palindrom.");
    else System.out.println("String nije palindrom.");
  }
}
