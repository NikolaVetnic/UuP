class PrakticneVezbe_20191017_02 {
  public static void main(String[] args) {
    char c = Svetovid.in.readChar("Unesite znak: ");
    
    if (('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
      Svetovid.out.println("Uneli ste slovo.");
    }    
    else if ('0' <= c && c <= '9') {
      Svetovid.out.println("Uneli ste cifru.");
    }
    else {
      Svetovid.out.println("Uneli ste znak.");
    }
  }
}
