class Sutra {
  public static void main(String[] args) {
    while (true) {
      Svetovid.out.print("Unesite datum: ");
      int dan = Svetovid.in.readInt(),
          mesec = Svetovid.in.readInt(),
          godina = Svetovid.in.readInt();
      if (dan == 0 || mesec == 0 || godina == 0) break;
      
      int d = 0;
      switch (mesec) {
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
          d = 31;
          break;
        case 4: case 6: case 9: case 11:
          d = 30;
          break;
        case 2:
          if (godina % 4 == 0 && godina % 100 != 0 || godina % 400 == 0) {
            d = 29;
            break;
          }
          else {
            d = 28;
            break;
          }
      }
      
      if (dan < d) {
        dan++;
      }
      else {
        dan = 1;
        mesec++;
      }
      
      Svetovid.out.println("Sutrasnji datum: " + dan + "." + mesec + "." + godina + ".");
  }
  }
}