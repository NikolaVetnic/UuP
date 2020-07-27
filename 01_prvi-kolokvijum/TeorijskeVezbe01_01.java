class Razlika {
  public static void main(String[] args){
    int br1 = Svetovid.in.readInt("Unesite prvi broj: ");
    int br2 = Svetovid.in.readInt("Unesite drugi broj: ");
    
    int razlika = br1 - br2;
    
    Svetovid.out.println("Razlika unetih brojeva je: " + razlika);
  }
}